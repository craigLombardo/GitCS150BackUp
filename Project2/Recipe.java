import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * This class serves as a Recipe in our ingredient book. Each recipe will have a name,
 * a course type, the ingredients it's made of, and the prep/cook time of the recipe.
 * @author Craig Lombardo
 */
public class Recipe implements Comparable<Recipe>{
  
  private String myName, myCourse, myType, myMain, myAddons, mySides;
  private int myPrepTime, myCookTime;
  private ArrayList<String> myIngredients;
  private boolean hasMeat = false, hasSeafood = false, hasDairy = false;
  private boolean hasShellfish = false, hasEggs = false;
  private ArrayList<TreeMap<Integer,Recipe>> myLocations;
  
  /**
   * This constructor method creates a Recipe with a specified name,
   * course type, ingredients, and the prep/cook time of the recipe.
   * @param name The name of the recipe.
   * @param course The course type: Appetizer, Salad, Entree or Dessert.
   * @param ingredients The ingredients required to make this Recipe.
   * @param prepTime How long it takes to prep the Recipe (Minutes).
   * @param cookTime How long it takes to cook the Recipe (Minutes).
   */
  public Recipe(String name, String course, String type, String main, String addons, String sides, int prepTime, int cookTime){
    myName = name;
    myCourse = course;
    myType = type;
    myMain = main;
    myAddons = addons;
    mySides = sides;
    myPrepTime = prepTime;
    myCookTime = cookTime;
    
    myIngredients = new ArrayList<String>();
    String allIngredients = (main + " " + addons + " " + sides +" ");
    int start = 0;
    for(int i=0; i<allIngredients.length(); i++){
      if(allIngredients.substring(i,i+1).compareTo(" ") == 0){
        myIngredients.add(allIngredients.substring(start,i));
        start = i+1;
      }
    }
    Collections.sort(myIngredients);
    
    FoodRules rules = new FoodRules();
    
    ArrayList<String> meats = rules.getMeats();
    ArrayList<String> seafood = rules.getSeafood();
    ArrayList<String> dairy = rules.getDairy();
    ArrayList<String> shellfish = rules.getShellfish();
    
    for(int i=0; i<myIngredients.size(); i++){
      for(int j=0; j<meats.size() && myIngredients.get(i).compareTo(meats.get(j)) >= 0 && !hasMeat; j++){
        if(myIngredients.get(i).compareTo(meats.get(j))==0){
          hasMeat = true;
        }
      }
      
      for(int j=0; j<seafood.size() && myIngredients.get(i).compareTo(seafood.get(j)) >= 0 && !hasSeafood; j++){
        if(myIngredients.get(i).compareTo(seafood.get(j))==0) hasSeafood = true;
      }
      
      for(int j=0; j<dairy.size() && myIngredients.get(i).compareTo(dairy.get(j)) >= 0 && !hasDairy; j++){
        if(myIngredients.get(i).compareTo(dairy.get(j))==0) hasDairy = true;
      }
      
      for(int j=0; j<shellfish.size() && myIngredients.get(i).compareTo(shellfish.get(j)) >= 0 && !hasShellfish; j++){
        if(myIngredients.get(i).compareTo(shellfish.get(j))==0) hasShellfish = true;
      }
      
      if(!hasEggs && myIngredients.get(i).compareTo("eggs") == 0) hasEggs = true;
    }
    myLocations = new ArrayList<TreeMap<Integer,Recipe>>();
  }
  
  /**
   * This method returns the name of the Recipe.
   * @return String The Recipe name.
   */
  public String getName(){
    return myName;
  }
  
  /**
   * This method returns the course type of the Recipe.
   * @return String The course type of the Recipe.
   */
  public String getCourse(){
    return myCourse;
  }
  
  /**
   * This method returns the cousine type of the Recipe.
   * @return String The cousine type of the Recipe.
   */
  public String getType(){
    return myType;
  }
  
  /**
   * This method returns the main ingredients of the Recipe.
   * @return String The main ingredients of the Recipe.
   */
  public String getMain(){
    return myMain;
  }
  
  /**
   * This method returns the addons of the Recipe.
   * @return String The addons of the Recipe.
   */
  public String getAddons(){
    return myAddons;
  }
  
  /**
   * This method returns the sides of the Recipe.
   * @return String The sides of the Recipe.
   */
  public String getSides(){
    return mySides;
  }
  
  /**
   * This method returns the prep time of the Recipe.
   * @return The prep time of the Recipe.
   */
  public int getPrepTime(){
    return myPrepTime;
  }
  
  /**
   * This method returns the cook time of the Recipe.
   * @return The cook time of the Recipe.
   */
  public int getCookTime(){
    return myCookTime;
  } 
  
  public int getTotalTime(){
    return (myPrepTime + myCookTime);
  }
  
  /**
   * This method returns the ingredient list of the Recipe.
   * @return ArrayList The ingredient list of the Recipe.
   */
  public ArrayList<String> getIngredients(){
    return myIngredients;
  }
  
  /**
   * This method returns true if the recipe has meat, false if it does not.
   */
  public boolean containsMeat(){
    return hasMeat;
  }
  
  /**
   * This method returns true if the recipe has seafood, false if it does not.
   */
  public boolean containsSeafood(){
    return hasSeafood;
  }
  
  /**
   * This method returns true if the recipe has shellfish, false if it does not.
   */
  public boolean containsShellfish(){
    return hasShellfish;
  }
  
  /**
   * This method returns true if the recipe has dairy, false if it does not.
   */
  public boolean containsDairy(){
    return hasDairy;
  }
  
  /**
   * This method returns true if the recipe has eggs, false if it does not.
   */
  public boolean containsEggs(){
    return hasEggs;
  }
  
  /**
   * This method returns true if the recipe is vegetarian, false if it is not.
   */
  public boolean isVegetarian(){
    return !hasMeat && !hasSeafood;
  }
  
  /**
   * This method returns true if the recipe is vegan, false if it is not.
   */
  public boolean isVegan(){
    return isVegetarian() && !hasDairy && !hasEggs;
  }
  
  public int compareTo(Recipe other){
    int total1 = myPrepTime + myCookTime;
    int total2 = other.getPrepTime() + other.getCookTime();
    if(total1 == total2) return 0; 
   else return  total1 > total2 ? 1 : -1;
  }
  
  public void addLocation(TreeMap<Integer,Recipe> location){
    myLocations.add(location);
  }
  
  public ArrayList<TreeMap<Integer,Recipe>> getLocations(){
    return myLocations;
  }
  
  public void delete(){
    for(int i=0; i<myLocations.size(); i++){
      myLocations.get(i).remove(myPrepTime+myCookTime);
    }
  }
  
  public String getInfo(){
    String output = "";
    output = output + "name: " + getName() + "\n";
    output = output + "type: " + getCourse() + "\n";
    output = output + "cuisine: " + getType() + "\n";
    output = output + "main: " + getMain() + "\n";
    output = output + "addons: " + getAddons() + "\n";
    output = output + "sides: " + getSides() + "\n";
    output = output + "prep: " + getPrepTime() + "\n";
    output = output + "cook: " + getCookTime() + "\n";
    return output;
  }
  
  public static void main(String[] args){
    Recipe tmp = new Recipe("1","2","3","no","peas eggs", "lettuce Sides", 9, 9);
    tmp = new Recipe("scallions","appetizer","French","peas","eggs", "lettuce", 9, 9);
    System.out.println(tmp.getInfo());
    System.out.println(tmp.isVegetarian());
  }
  
}
