import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.util.Scanner;

/**
 * This class will hold all of the known Junction points and road connections. A Junction can be
 * merely a Junction in which roads meet, or there could be a Restaurant or
 * Farm at that point.
 * 
 * @author Craig Lombardo
 */
public class Database{
  
  private HashMap<String,Junction> map;
  private ArrayList<Farm> farms;
  private ArrayList<Restaurant> rests;
  private Double gasPrice;
  private int mealCount;
  
  /**
   * The constructor method creates a new empty database.
   * @param conn An input file serving as the connectivity list, all entries should
   * be on their own line in the form of:<br>&#60;conn1&#62; - &#60;conn2&#62; &#60;distance&#62;
   * @param farm An input file serving as the list of Farms in the area, all entries
   * should be on their own line and should be in the form of:<br>
   * farm &#60;node name&#62; - &#60;ingredient1&#62; &#60;cost&#62; &#60;ingredient2&#62; &#60;cost&#62; ...
   * @param rest An input file serving as the list of Restaurants in the area, all
   * entries should be on their own line and should be in the form of:<br>
   * restaurant &#60;node name&#62;
   */
  public Database(String conn, String farm, String rest){
    map = new HashMap<String,Junction>();
    farms = new ArrayList<Farm>();
    rests = new ArrayList<Restaurant>();
    Scanner connSc = null;
    Scanner farmSc = null;
    Scanner restSc = null;
    try{
      connSc = new Scanner(new File(conn));
      farmSc = new Scanner(new File(farm));
      restSc = new Scanner(new File(rest));
      addFarms(farmSc);
      addRests(restSc);
      addConns(connSc);
    }
    catch(java.io.FileNotFoundException e){
      
    }
  }
  
  /**
   * This method sets the gas price.
   * @param p The price per unit
   */
  public void setGasPrice(Double p){
    gasPrice = p;
  }
  
  /**
   * This method sets the number of meals required to make
   * @param n The number of meals
   */
  public void setMealCount(int n){
    mealCount = n;
  }
  
  private void addFarms(Scanner farmSc){
    while(farmSc.hasNextLine()){
      ArrayList<Item> farmSupply = new ArrayList<Item>();
      Scanner line = new Scanner(farmSc.nextLine());
      line.next();
      String num = line.next();
      line.next();
      while(line.hasNext()){
        Item newI = new Item(line.next(),Double.parseDouble(line.next()));
        if(farmSupply.size()==0) farmSupply.add(newI);
        else{
          boolean insert = true;
          for(Item i : farmSupply){
            if(i.getName().equals(newI.getName())){
              if(newI.getCost()<i.getCost()){
                i.setCost(newI.getCost());
                insert = false;
                break;
              }
            }
          }
          if(insert) farmSupply.add(newI);
        }
      }
      Collections.sort(farmSupply);
      Farm newF = new Farm(num,farmSupply);
      map.put(newF.getName(), new Junction(newF.getName(), newF, null));
      farms.add(newF);
      line.close();
    }
  } 
  
  private void addRests(Scanner restSc){
    while(restSc.hasNextLine()){
      Scanner line = new Scanner(restSc.nextLine());
      line.next();
      String num = line.next();
      Restaurant newR = new Restaurant(num);
      map.put(num,new Junction(num,null,newR));
      rests.add(newR);
      line.close();
    }
  }
  
  private void addConns(Scanner connSc){
    while(connSc.hasNextLine()){
      Scanner line = new Scanner(connSc.nextLine());
      String nOne = line.next();
      Junction jOne = map.get(nOne);
      if(jOne == null){
        Junction newJ = new Junction(nOne,null,null);
        map.put(nOne,newJ);
      }
      
      line.next();
      
      String nTwo = line.next();
      Junction jTwo = map.get(nTwo);
      if(jTwo == null){
        Junction newJ = new Junction(nTwo,null,null);
        map.put(nTwo,newJ);
      }
      connect(nOne,nTwo,Integer.parseInt(line.next()));
      line.close();
    }
  }
  
  /**
   * This method adds a new Junction to the database if it is not
   * already present. 
   * @param j The junction to be added.
   * @return true if added, false otherwise
   */
  public boolean addJunction(Junction j){
    if(map.containsKey(j.getName())) return false;
    else{
      map.put(j.getName(),j);
      return true;
    }
  }
  
  /**
   * This method connects two junctions via a road.
   * @param one The name/key of the first junction
   * @param two The name/key of the second Junction.
   * @param dist The distance of the road.
   * @return true if the two were connected, false if not
   */
  public boolean connect(String one, String two, int dist){
    Junction jOne = map.get(one);
    Junction jTwo = map.get(two);
    if(jOne != null && jTwo != null){
      jOne.connectTo(jTwo,dist);
      return true;
    }
    else return false;
  }
  
  /**
   * This method was modified from Algolist.com
   * http://www.algolist.com/code/java/Dijkstra%27s_algorithm
   * @param source The Junction we are starting from
   * @param target The Junction we are trying to get to
   * @return An ArrayList of Junctions corresponding to the shortest path to
   * this node. It is important to note that it is the shortest from the computed
   * which varies based on starting point.
   */
  public ArrayList<Junction> getShortestPathTo(Junction source, Junction target){
    source.computePaths(map);
    ArrayList<Junction> path = new ArrayList<Junction>();
    for(Junction node = target; node != null; node = node.getPrevious()){
      path.add(node);
    }
    Collections.reverse(path);
    return path.size()<=1 ? new ArrayList<Junction>() : path;
  }
  
  /**
   * This method gets the distance of a given path
   * @param list The path to get the distance across
   * @return The distance of the entire path
   */
  public int getDistance(ArrayList<Junction> list){
    int total = 0;
    for(int i=0; i<list.size()-1; i++) total += list.get(i).getDistTo(list.get(i+1));
    return total;
  }
  
  private void trim(ArrayList<String> need, ArrayList<Item> got){
    for(int i=need.size()-1; i>=0; i--){
      for(int k=0; k<got.size(); k++) 
        if(got.get(k).getName().equals(need.get(i))){
        need.remove(i);
        got.remove(k);
        break;
      }
    }
  }
  
  /**
   * This method calculates the cost to get all of the ingredients needed and where to get them.
   * It is important to note that this method prints out to the console, it does not return anything.
   * @param list THe list of ingredients needed.
   */
  public void getCosts(ArrayList<String> list){
    ArrayList<String> newL;
    for(Restaurant r : rests){
      newL = new ArrayList<String>();
      for(String s : list) newL.add(s);
      Junction start = map.get(r.getName());
      System.out.println("\n\nCheapest find for Restaurant "+r.getName());
      System.out.println("Total cost: "+getBest(start,start,newL)+"\n");
    }
  }
  
  private double getBest(Junction source, Junction current, ArrayList<String> list){
    double total = 0.0;
    Farm bestFarm = null;
    double bestAvgPrice = Double.POSITIVE_INFINITY;
    double bestGasPrice = Double.POSITIVE_INFINITY;
    ArrayList<Item> matches = new ArrayList<Item>();
    ArrayList<Item> tmp;
    for(Farm f : farms){
      double dist = getDistance(getShortestPathTo(current,map.get(f.getName())));
      double gasCost = dist*gasPrice;
      double farmCost = 0.0;
      ArrayList<Item> items = f.getItems();
      tmp = new ArrayList<Item>();
      for(Item i : items){
        for(int j=0; j<list.size(); j++){
          if(i.getName().equals(list.get(j))){
            farmCost+=(f.findItem(i.getName()).getCost())*mealCount;
            tmp.add(i);
          }
        }
      }
      double avgFarmCost = (farmCost/tmp.size());
      if((avgFarmCost + gasCost)<(bestAvgPrice + bestGasPrice)){
        bestAvgPrice = avgFarmCost;
        bestGasPrice = gasCost;
        bestFarm = f;
        matches = new ArrayList<Item>();
        for(Item i : tmp) matches.add(i);
      }
    }
    if(bestFarm!=null){
      ArrayList<Junction> path = getShortestPathTo(current,map.get(bestFarm.getName()));
      System.out.println("Path taken:");
      if(path.size()==0) System.out.print("We stayed at this location!");
      for(int i=0;i<path.size();i++){
        System.out.print(path.get(i).getName());
        if(i<path.size()-1) System.out.print(" -> ");
      }
      System.out.println("\nDistance: "+getDistance(path));
      System.out.println("\nIngredients purchased for price...");
      for(Item i : matches) System.out.println(i.getName()+" for " + bestFarm.findItem(i.getName()).getCost());
      System.out.println("Total Cost to get these Ingredients: "+(double)(bestAvgPrice*matches.size()+bestGasPrice)+"\n");
      ArrayList<Item> items = bestFarm.getItems();
      ArrayList<String> out = new ArrayList<String>();
      for(Item i : items) out.add(i.getName());
      trim(list,matches);
      total+=bestAvgPrice*matches.size()+bestGasPrice;
      if(list.size()>0) total+=getBest(source,map.get(bestFarm.getName()),list);
      else{
        ArrayList<Junction> home = getShortestPathTo(map.get(bestFarm.getName()),source);
        System.out.println("Path Back to Restaurant: ");
        for(int i=0;i<home.size();i++){
          System.out.print(home.get(i).getName());
          if(i<home.size()-1) System.out.print(" -> ");
        }
        System.out.println("\nDistance: "+getDistance(home));
        double dist = getDistance(home);
        double gasCost = dist*gasPrice;
        total+= gasCost;
      }
    }
    return total;
  }
  
  /**
   * This method calculates the best route based on an input of ingredients separated by a space
   * @param words The ingredients separated by a space
   */
  public void calculate(String words){
    ArrayList<String> list = getList(words);
    getCosts(list);
  }
  
  private ArrayList<String> getList(String words){
    ArrayList<String> output = new ArrayList<String>();
    Scanner sc = new Scanner(words);
    while(sc.hasNextLine()){
      for(int i=0; i<3; i++) sc.nextLine();
      for(int i=0; i<3; i++){
        Scanner inner = new Scanner(sc.nextLine());
        inner.next();
        while(inner.hasNext()) output.add(inner.next());
        inner.close();
      }
      for(int i=0; i<3; i++) sc.nextLine();
    }
    sc.close();
    Collections.sort(output);
    return output;
  }
  
}