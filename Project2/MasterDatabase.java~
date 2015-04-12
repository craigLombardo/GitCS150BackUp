import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class MasterDatabase{
  
  public HashMap<String,ArrayList<Recipe>> map;
  
  public MasterDatabase(){
    map = new HashMap<String,ArrayList<Recipe>>();
  }
  
  public boolean add(Recipe newR){
    ensureAvailable(newR.getName().substring(0,1));
    map.get(newR.getName().substring(0,1)).add(newR);
    return true;
  }
  
  public void remove(Recipe item){
    map.get(item.getName().substring(0,1)).remove(item);
  }
  
  /**
   * This method ensures that there is an available ArrayList to add the recipe to.
   * This method takes in a letter which corresponds to the mapping of the HashMap and ensures
   * that letter has an ArrayList at that location, if it does then we pass through, if not then
   * we add one.
   * @param letter The letter to check;
   */
  public void ensureAvailable(String letter){
    if(map.get(letter)==null){
      map.put(letter, new ArrayList<Recipe>());
    }
  }
  
  /**
   * searches for a value in sorted array
   * @param array array to search in
   * @param value searched value
   * @param left index of left boundary
   * @param right index of right boundary
   * @return position of searched value, if it presents in the array or -1, if it is absent
   * 
   * modified from http://www.algolist.net/Algorithms/Binary_search
   */
  
  public Recipe binarySearch(ArrayList<Recipe> array, String name, int left, int right){
    if(left > right) return null;
    int middle = (left + right)/2;
    if(array.get(middle).getName().equals(name)){
      return array.get(middle);
    }
    else if(array.get(middle).getName().compareTo(name) > 0) return binarySearch(array, name, left, middle - 1);
    else return binarySearch(array, name, middle + 1, right);           
  }
  
  public Recipe find(String name){
    ensureAvailable(name.substring(0,1));  
    ArrayList<Recipe> list = map.get(name.substring(0,1)); 
    return binarySearch(list, name, 0, list.size()-1);
  }
  
  public void printOut(String outputFile) {
    PrintWriter dataWriter = null;
    try{
      dataWriter = new PrintWriter(outputFile);
    }
    catch(java.io.FileNotFoundException e){
      System.out.println("erroe");
    }
    Iterator it = map.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        ArrayList current = (ArrayList) pair.getValue();
        for(int i=0; i<current.size(); i++){
          Recipe rec = (Recipe) current.get(i);
          dataWriter.println(rec.getInfo());
        }
       // it.remove(); // avoids a ConcurrentModificationException
    }
    dataWriter.close();
  }
  
  public static void main(String[] args){
    MasterDatabase test = new MasterDatabase();
    Recipe tmp = new Recipe("testing","2","3","beef cheese","peas eggs", "lettuce Sides", 9, 9);
    test.add(tmp);
    tmp = new Recipe("resting2","2","3","beef cheese","peas eggs", "lettuce Sides", 9, 9);
    test.add(tmp);
    tmp = new Recipe("testing21","2","3","beef cheese","peas eggs", "lettuce Sides", 9, 9);
    test.add(tmp);
    Recipe found = test.find("testing");
    if(found!=null) System.out.println(found.getInfo());
    else System.out.println("No recipes were found with that name");
    //test.remove(found);
    found = test.find("testing");
    if(found!=null) System.out.println(found.getInfo());
    else System.out.println("No recipes were found with that name");
    test.printOut("ppppptmp.txt");
  }
  
}