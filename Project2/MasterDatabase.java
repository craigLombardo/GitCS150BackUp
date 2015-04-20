import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Collections;

/**
 * This class serves as the "MasterDatabase" it will store all of it's elements
 * based on their name.
 * @author Craig Lombardo
 */
public class MasterDatabase{
  
  private HashMap<String,ArrayList<Recipe>> map;
  
  /**
   * This constructor creates a new, empty, MasterDatabase
   */
  public MasterDatabase(){
    map = new HashMap<String,ArrayList<Recipe>>();
  }
  
  /**
   * This method adds the new Recipe to the MasterDatabase.
   * @param newR The Recipe to add.
   */
  public void add(Recipe newR){
    ensureAvailable(newR.getName().substring(0,1));
    ArrayList<Recipe> current = map.get(newR.getName().substring(0,1));
    current.add(newR);
  }
  
  /**
   * This method removes a given item from the MasterDatabase.
   * @param item The recipe to remove.
   */
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
  private void ensureAvailable(String letter){
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
  
  private Recipe binarySearch(ArrayList<Recipe> array, String name, int left, int right){
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
    Collections.sort(list,new RecipeTreeNameComparator());
    return binarySearch(list, name, 0, list.size()-1);
  }
  
  /**
   * This method writes all of the Recipes to the output file specified.
   * Code was taken a modified from http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
   * for iteration through a HashMap.
   * @param outputFile The output file to write to.
   */
  public void printOut(String outputFile){
    PrintWriter dataWriter = null;
    try{
      dataWriter = new PrintWriter(outputFile);
    }
    catch(java.io.FileNotFoundException e){
      System.out.println("erroe");
    }
    Iterator it = map.entrySet().iterator();
    while (it.hasNext()){
        Map.Entry pair = (Map.Entry)it.next();
        ArrayList current = (ArrayList) pair.getValue();
        for(int i=0; i<current.size(); i++){
          Recipe rec = (Recipe) current.get(i);
          dataWriter.println(rec.getInfo());
        }
       it.remove();
    }
    dataWriter.close();
  }
  
}