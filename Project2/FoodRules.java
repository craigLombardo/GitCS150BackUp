import java.util.ArrayList;
import java.util.Collections;

/**
 * This class will handle the food rules used by our cookbook. This class will
 * delineate what warrants a meat, seafood, etc. It will also help in labeling
 * food restrictions such as vegetarian and vegan.
 * @author Craig Lombardo
 */
public class FoodRules{
  
  private ArrayList<String> meat, seafood, shellfish, vegetables, dairy, soy, other, cuisineType;
  private ArrayList<String> allIngredients, allCourses, validInclusions;
  
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
    
    seafood = new ArrayList<String>();
    
    seafood.add("salmon");
    seafood.add("scallops");
    seafood.add("shrimp");
    
    shellfish = new ArrayList<String>();
    
    shellfish.add("scallops");
    shellfish.add("shrimp");
    
    soy = new ArrayList<String>();
    
    soy.add("tempeh");
    soy.add("tofu");
    
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
    cuisineType.add("Asian");
    cuisineType.add("MiddleEastern");
    cuisineType.add("SouthAsian");
    Collections.sort(cuisineType);
    
    allCourses = new ArrayList<String>();

    allCourses.add("appetizer");
    allCourses.add("entree");
    allCourses.add("salad");

    allIngredients = new ArrayList<String>();

    for(int i=0; i<meat.size(); i++) allIngredients.add(meat.get(i));
    for(int i=0; i<seafood.size(); i++) allIngredients.add(seafood.get(i));
    for(int i=0; i<shellfish.size(); i++) allIngredients.add(shellfish.get(i));
    for(int i=0; i<soy.size(); i++) allIngredients.add(soy.get(i));
    for(int i=0; i<vegetables.size(); i++) allIngredients.add(vegetables.get(i));
    for(int i=0; i<dairy.size(); i++) allIngredients.add(dairy.get(i));
    for(int i=0; i<other.size(); i++) allIngredients.add(other.get(i));
    
    validInclusions = new ArrayList<String>();
    
    validInclusions.add("meat");
    validInclusions.add("seafood");
    validInclusions.add("vegetarian");
    validInclusions.add("vegan");
    validInclusions.add("dairy");
    validInclusions.add("shellfish");
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
  public ArrayList<String> getSeafood(){
    return seafood;
  }
  
  /**
   * This method returns an ArrayList corresponding to the list of all shellfish.
   * @return A list of all possible shellfish options.
   */
  public ArrayList<String> getShellfish(){
    return shellfish;
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
    ArrayList<String> arr = new ArrayList<String>();
    
    for(int i=0; i<vegetables.size(); i++) arr.add(vegetables.get(i));
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
  
  /**
   * This method returns an ArrayList corresponding to the list of all soy options.
   * @return A list of all possible soy options.
   */
  public ArrayList<String> getSoy(){
    return soy;
  }
  
  /**
   * This method returns an ArrayList corresponding to the list of all ingredient options.
   * @return A list of all possible ingredient options.
   */
  public ArrayList<String> getIngredients(){
    return allIngredients;
  }
  
  public void addIngredient(String ingredient){
    allIngredients.add(ingredient);
    Collections.sort(allIngredients);
  }
  
  public ArrayList<String> getCourses(){
    return allCourses;
  }
  
  public ArrayList<String> getInclusions(){
    return validInclusions;
  }
  
}