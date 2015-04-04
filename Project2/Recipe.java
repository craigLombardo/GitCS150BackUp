import java.util.ArrayList;
import java.util.Collections;

/**
 * This class serves as a Recipe in our ingredient book. Each recipe will have a name,
 * a course type, the ingredients it's made of, and the prep/cook time of the recipe.
 * @author Craig Lombardo
 */
public class Recipe{
  
  private String myName, myCourse, myType, myMain, myAddons, mySides, myPrepTime, myCookTime;
  private ArrayList<String> myIngredients;
  private boolean hasMeat; 
  
  /**
   * This constructor method creates a Recipe with a specified name,
   * course type, ingredients, and the prep/cook time of the recipe.
   * @param name The name of the recipe.
   * @param course The course type: Appetizer, Salad, Entree or Dessert.
   * @param ingredients The ingredients required to make this Recipe.
   * @param prepTime How long it takes to prep the Recipe (Minutes).
   * @param cookTime How long it takes to cook the Recipe (Minutes).
   */
  public Recipe(String name, String course, String type, String main, String addons, String sides, String prepTime, String cookTime){
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
   * @return int The prep time of the Recipe.
   */
  public String getPrepTime(){
    return myPrepTime;
  }
  
  /**
   * This method returns the cook time of the Recipe.
   * @return int The cook time of the Recipe.
   */
  public String getCookTime(){
    return myCookTime;
  } 
  
  /**
   * This method returns the ingredient list of the Recipe.
   * @return ArrayList The ingredient list of the Recipe.
   */
  public ArrayList<String> getIngredients(){
    return myIngredients;
  }
  
  public static void main(String[] args){
    Recipe tmp = new Recipe("1","2","3","soup no","hello World", "No Sides", "9", "9");
    ArrayList<String> test = tmp.getIngredients();
    for(int i=0; i<test.size(); i++){
      System.out.println(test.get(i));
    }
    System.out.println("name: " + tmp.getName());
    System.out.println("type: " + tmp.getCourse());
    System.out.println("cuisine: " + tmp.getType());
    System.out.println("main: " + tmp.getMain());
    System.out.println("addons: " + tmp.getAddons());
    System.out.println("sides: " + tmp.getSides());
    System.out.println("prep: " + tmp.getPrepTime());
    System.out.println("cook: " + tmp.getCookTime());
  }
  
}
