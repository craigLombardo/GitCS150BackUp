import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.util.Scanner;

/**
 * This class will hold all of the known Junction points. A Junction can be
 * merely a Junction in which roads meet, or there could be a Restaurant or
 * Farm at that point.
 * 
 * @author Craig Lombardo
 */
public class Database{
  
  private HashMap<String,Junction> map;
  
  /**
   * The constructor method creates a new empty database.
   * @param conns An input file serving as the connectivity list, all entries should
   * be on their own line in the form of:<br>&#60;conn1&#62; - &#60;conn2&#62; &#60;distance&#62;
   * @param farms An input file serving as the list of Farms in the area, all entries
   * should be on their own line and should be in the form of:<br>
   * farm &#60;node name&#62; - &#60;ingredient1&#62; &#60;cost&#62; &#60;ingredient2&#62; &#60;cost&#62; ...
   * @param rests An input file serving as the list of Restaurants in the area, all
   * entries should be on their own line and should be in the form of:<br>
   * restaurant &#60;node name&#62;
   */
  public Database(String conns, String farms, String rests){
    map = new HashMap<String,Junction>();
    Scanner connSc = null;
    Scanner farmSc = null;
    Scanner restSc = null;
    try{
      connSc = new Scanner(new File(conns));
      farmSc = new Scanner(new File(farms));
      restSc = new Scanner(new File(rests));
      addFarms(farmSc);
      addRests(restSc);
      addConns(connSc);
    }
    catch(java.io.FileNotFoundException e){
      
    }
  }
  
  private void addFarms(Scanner farmSc){
    while(farmSc.hasNextLine()){
      ArrayList<Item> farmSupply = new ArrayList<Item>();
      Scanner line = new Scanner(farmSc.nextLine());
      line.next();
      String num = line.next();
      line.next();
      while(line.hasNext()){
        farmSupply.add(new Item(line.next(),Double.parseDouble(line.next())));
      }
      Collections.sort(farmSupply);
      Farm newF = new Farm(num,farmSupply);
      map.put(newF.getName(), new Junction(newF.getName(), newF, null));
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
   * This method returns the Database's HashMap.
   * @return The HashMap of the Database
   */
  public HashMap<String,Junction> getMap(){
    return map;
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
   * @param target The Junction we are trying to get to
   * @return An ArrayList of Junctions corresponding to the shortest path to
   * this node. It is important to note that it is the shortest from the computed
   * which varies based on starting point.
   */
  public ArrayList<Junction> getShortestPathTo(Junction target){
    ArrayList<Junction> path = new ArrayList<Junction>();
    for(Junction node = target; node != null; node = node.getPrevious()){
      path.add(node);
    }
    Collections.reverse(path);
    return path.size()<=1 ? new ArrayList<Junction>() : path;
  }
  
  /**
   * This needs updatind
   * @param args empty
   */
  public static void main(String[] args){
    Database test = new Database("exampleData/connectivity.txt","exampleData/farms.txt","exampleData/restaurants.txt");
    System.out.println(test.map);
    System.out.println();
    ArrayList<Item> tmp = test.map.get("22").getFarm().getItems();
    for(Item i : tmp) System.out.println(i.getName() + " : " + i.getCost());
    System.out.println();
    Junction dut = test.map.get("22");
    ArrayList<Junction.Road> ok = dut.getRoads();
    for(Junction.Road r : ok) System.out.println(dut.getName() + " - " + r.getOtherJunction(dut).getName() + " w: " + r.getDistance());
  }
  
}