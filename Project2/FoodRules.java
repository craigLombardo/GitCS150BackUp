import java.util.ArrayList;
import java.util.Collections;

/**
 * This class will handle the food rules used by our cookbook. This class will
 * delineate what warrants a meat, seafood, etc. It will also help in labeling
 * food restrictions such as vegetarian and vegan.
 * @author Craig Lombardo
 */
public class FoodRules{
  
  private ArrayList<String> meat, fish, vegetables, dairy, other, cuisineType;
  
  /**
   * This constructor method takes no parameters and sets all of the items included
   * in each category, as specified in the class description.
   */
  public FoodRules(){
    meat = new ArrayList<String>();
    
    meat.add("beef");
    meat.add("chicken");
    meat.add("goat");
    meat.add("lamb");
    
    fish = new ArrayList<String>();
    
    fish.add("salmon");
    fish.add("scallops");
    fish.add("shrimp");
    
    vegetables = new ArrayList<String>();
    
    vegetables.add("broccoli");
    vegetables.add("cauliflower");
    vegetables.add("spinach");
    vegetables.add("mushrooms");
    vegetables.add("beans");
    vegetables.add("potatoes");
    vegetables.add("beets");
    vegetables.add("peas");
    vegetables.add("rice");
    vegetables.add("kale");
    vegetables.add("lettuce");
    vegetables.add("chard");
    vegetables.add("mesclun");
    vegetables.add("arugula");
    vegetables.add("radishes");
    vegetables.add("scallions");
    vegetables.add("cucumbers");
    vegetables.add("carrots");
    vegetables.add("peas");
    Collections.sort(vegetables);
    
    dairy = new ArrayList<String>();
    
    dairy.add("cheese");
    dairy.add("milk");
    
    other = new ArrayList<String>();
    
    other.add("eggs");
    
    cuisineType = new ArrayList<String>();
    
    cuisineType.add("Italian");
    cuisineType.add("Chinese");
    cuisineType.add("Greek");
    cuisineType.add("Turkish");
    cuisineType.add("Indian");
    cuisineType.add("Pakistan");
    cuisineType.add("French");
    cuisineType.add("Korean");
    Collections.sort(cuisineType);
    
  }
  
  /**
   * This method returns an ArrayList corresponding to the list of all meats.
   * @return A list of all possible meat options.
   */
  public ArrayList<String> getMeats(){
    return meat;
  }
  
  /**
   * This method returns an ArrayList corresponding to the list of all seafood.
   * @return A list of all possible seafood options.
   */
  public ArrayList<String> getFish(){
    return fish;
  }
  
  /**
   * This method returns an ArrayList corresponding to the list of all vegetables.
   * @return A list of all possible vegetable options.
   */
  public ArrayList<String> getVegetables(){
    return vegetables;
  }
  
  /**
   * This method returns an ArrayList corresponding to the list of all cuisine types,
   * Italian, French, Chinese, etc.
   * @return A list of all possible cuisine types.
   */
  public ArrayList<String> getCuisineTypes(){
    return cuisineType;
  }
  
  /**
   * This method returns an ArrayList corresponding to the list of all dairy options.
   * @return A list of all possible dairy options.
   */
  public ArrayList<String> getDairy(){
    return dairy;
  }
  
  /**
   * This method returns an ArrayList corresponding to the list of all other options,
   * ie eggs in our case; however, this can be used for any items that fall in the "other"
   * category.
   * @return A list of all possible meat options.
   */
  public ArrayList<String> getOther(){
    return other;
  }
  
  /**
   * This method returns an ArrayList corresponding to the list of all vegetarian options.
   * @return A list of all possible vegetarian options.
   */
  public ArrayList<String> getVegetarian(){
    ArrayList<String> arr = vegetables;
    
    for(int i=0; i<dairy.size(); i++) arr.add(dairy.get(i));
    for(int i=0; i<other.size(); i++) arr.add(other.get(i));
    
    Collections.sort(arr);
    return arr;
  }
  
  /**
   * This method returns an ArrayList corresponding to the list of all vegan options.
   * @return A list of all possible vegan options.
   */
  public ArrayList<String> getVegan(){
    return vegetables;
  }
  
  public static void main(String[] args){
    FoodRules test = new FoodRules();
    for(int i=0; i< test.vegetables.size(); i++) System.out.println(test.vegetables.get(i));
  }
  
}