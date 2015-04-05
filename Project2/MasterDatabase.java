import java.util.HashMap;
import java.util.ArrayList;

public class MasterDatabase{
  
  private HashMap<String,ArrayList<Recipe>> map;
  
  public MasterDatabase(){
    map = new HashMap<String,ArrayList<Recipe>>();
  }
  
  public boolean add(Recipe newR){
    ensureAvailable(newR.getName().substring(0,1));
    map.get(newR.getName().substring(0,1)).add(newR);
    return true;
  }
  
  public boolean remove(String name){
    ensureAvailable(name.substring(0,1));
    if(find(name,true) != null) return true;
    else return false;
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
  
  public Recipe binarySearch(ArrayList<Recipe> array, String name, int left, int right, boolean pop){
    if(left > right) return null;
    int middle = (left + right)/2;
    if(array.get(middle).getName() == name){
      if(pop) return array.remove(middle);
      else return array.get(middle);
    }
    else if(array.get(middle).getName().compareTo(name) > 0) return binarySearch(array, name, left, middle - 1,pop);
    else return binarySearch(array, name, middle + 1, right,pop);           
  }
  
  public Recipe find(String name){
    return find(name,false);
  }
  
  private Recipe find(String name, boolean pop){
    ensureAvailable(name.substring(0,1));  
    ArrayList<Recipe> list = map.get(name.substring(0,1)); 
    return binarySearch(list, name, 0, list.size()-1,pop);
  }
  
  public static void main(String[] args){
    MasterDatabase test = new MasterDatabase();
    Recipe tmp = new Recipe("testing","2","3","beef cheese","peas eggs", "lettuce Sides", "9", "9");
    test.add(tmp);
    Recipe found = test.find("testing",false);
    if(found!=null) found.getInfo();
    else System.out.println("No recipes were found with that name");
    
    System.out.println("\n"+test.remove("testing"));
    
    found = test.find("testing",false);
    if(found!=null) found.getInfo();
    else System.out.println("No recipes were found with that name");
  }
  
}