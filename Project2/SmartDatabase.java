import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeSet;

public class SmartDatabase{
  
  //Cousine type
  private final int ITALIAN=0,CHINESE=1,GREEK=2,TURKISH=3,INDIAN=4,PAKISTAN=5,FRENCH=6,KOREAN=7, 
    ASIAN=8, MIDDLE_EASTERN=9, SOUTH_ASIAN=10, ALLCUISINETYPES=11;
  
  private final int SALAD=0, APPETIZER=1, ENTREE=2, ALLFOODTYPES=3;
  private FoodRules ruleBook;
  private HashMap<String, ArrayList<ArrayList<ArrayList<TreeSet<Recipe>>>>> map;
  
  public SmartDatabase(FoodRules rules){
    ruleBook = rules;
    map = new HashMap<String, ArrayList<ArrayList<ArrayList<TreeSet<Recipe>>>>>();
    ArrayList<String> ingredients = ruleBook.getIngredients();
    for(int i=0; i<ingredients.size(); i++){
      addNewIngredient(ingredients.get(i));
    }
  }
  
  public void add(Recipe newR){
    ArrayList<String> ingred = newR.getIngredients();
    for(int i=0; i<ingred.size(); i++){
      String current = ingred.get(i);
      ArrayList<ArrayList<ArrayList<TreeSet<Recipe>>>> chooseType = map.get(current);
      if(chooseType == null){
        addNewIngredient(current);
        chooseType = map.get(current);
      }
      ArrayList<ArrayList<TreeSet<Recipe>>> chooseCourse = chooseType.get(getCuisineVal(newR));
      ArrayList<TreeSet<Recipe>> chooseExclusions = chooseCourse.get(getCourseVal(newR));
      addToExclusions(newR,chooseExclusions);
    }
  }
  
  private void addToExclusions(Recipe newR, ArrayList<TreeSet<Recipe>> exclusions){
    boolean meat = newR.containsMeat();
    boolean seafood = newR.containsSeafood();
    boolean shellfish = newR.containsShellfish();
    boolean dairy = newR.containsDairy();
    boolean vegetarian = newR.isVegetarian();
    boolean vegan = newR.isVegan();
    
    if(meat) exclusions.get(0).add(newR);
    if(seafood) exclusions.get(1).add(newR);
    if(shellfish) exclusions.get(2).add(newR);
    if(dairy) exclusions.get(3).add(newR);
    if(vegetarian) exclusions.get(4).add(newR);
    if(vegan) exclusions.get(5).add(newR);
  }
  
  private int getCuisineVal(Recipe rec){
    String type = rec.getType();
    if(type.equals("Italian")) return ITALIAN;
    else if(type.equals("Chinese")) return CHINESE;
    else if(type.equals("Greek")) return GREEK;
    else if(type.equals("Turkish")) return TURKISH;
    else if(type.equals("Indian")) return INDIAN;
    else if(type.equals("Pakistan")) return PAKISTAN;
    else if(type.equals("French")) return FRENCH;
    else if(type.equals("Korean")) return KOREAN;
    else if(type.equals("Asian")) return ASIAN;
    else if(type.equals("MiddleEastern")) return MIDDLE_EASTERN;
    else if(type.equals("SouthAsian")) return SOUTH_ASIAN;
    else return ALLCUISINETYPES;
  }
  
    private int getCourseVal(Recipe rec){
    String course = rec.getType();
    if(course.equals("salad")) return SALAD;
    else if(course.equals("appetizer")) return APPETIZER;
    else if(course.equals("entree")) return ENTREE;
    else return ALLFOODTYPES;
  }
    
    public void addNewIngredient(String name){
      ArrayList<ArrayList<ArrayList<TreeSet<Recipe>>>> chooseType = new ArrayList<ArrayList<ArrayList<TreeSet<Recipe>>>>();
      ArrayList<ArrayList<TreeSet<Recipe>>> chooseCourse;
      ArrayList<TreeSet<Recipe>> chooseExclusions;
      TreeSet<Recipe> dataHolder;
      for(int i=0; i<12; i++){
        chooseCourse = new ArrayList<ArrayList<TreeSet<Recipe>>>();
        for(int j=0; j<4; j++){
          chooseExclusions = new ArrayList<TreeSet<Recipe>>();
          for(int k=0; k<6; k++){
            dataHolder = new TreeSet<Recipe>(new RecipeTreeTimeComparator());
            chooseExclusions.add(dataHolder);
          }
          chooseCourse.add(chooseExclusions);
        }
        chooseType.add(chooseCourse);
      }
      map.put(name,chooseType);
    }
  
  public static void main(String[] args){
    SmartDatabase test = new SmartDatabase(new FoodRules());
    Recipe tmp = new Recipe("scallions","appetizer","French","peas","eggs", "lettuce", 9, 9);
    System.out.println("one " + tmp);
    test.add(tmp);
    tmp = new Recipe("scallions3","appetizer","Italian","peas","eggs eggs eggs eggs", "lettuce mesclun", 9, 9);
    System.out.println("two " + tmp);
    test.add(tmp);
    tmp = new Recipe("scallions2","appetizer","Italian","scallions cauliflower","chicken", "spinach", 9, 9);
    System.out.println("three " + tmp);
    test.add(tmp);
    
    System.out.println(test.map);
  }
}