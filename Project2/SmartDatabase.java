import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;

public class SmartDatabase{
  
  //Cousine type
  private final int ITALIAN=0,CHINESE=1,GREEK=2,TURKISH=3,INDIAN=4,PAKISTAN=5,FRENCH=6,KOREAN=7, 
    ASIAN=8, MIDDLE_EASTERN=9, SOUTH_ASIAN=10, ALLCUISINETYPES=11;
  
  private final int SALAD=0, APPETIZER=1, ENTREE=2, ALLFOODTYPES=3;
  
  private final int EXMEAT=0, EXSEAFOOD=1, EXSHELLFISH=2, EXDAIRY=3, EXVEGETARIAN=4,
    EXVEGAN=5, EXALL=6;
  
  private FoodRules ruleBook;
  private HashMap<String, ArrayList<ArrayList<ArrayList<TreeMap<Integer,Recipe>>>>> map;
  private ArrayList<String> validIngredients;
  
  public SmartDatabase(FoodRules rules){
    ruleBook = rules;
    map = new HashMap<String, ArrayList<ArrayList<ArrayList<TreeMap<Integer,Recipe>>>>>();
    validIngredients = ruleBook.getIngredients();
    for(int i=0; i<validIngredients.size(); i++){
      addNewIngredient(validIngredients.get(i));
    }
    addNewIngredient("all");
  }
  
  public void add(Recipe newR){
    ArrayList<String> ingred = new ArrayList<String>();
    for(int i=0; i<validIngredients.size(); i++) ingred.add(validIngredients.get(i));
    ingred.add("all");
    for(int i=0; i<ingred.size(); i++){
      String current = ingred.get(i);
      ArrayList<ArrayList<ArrayList<TreeMap<Integer,Recipe>>>> chooseType = map.get(current);
      if(chooseType == null){
        addNewIngredient(current);
        chooseType = map.get(current);
      }
      int cuisine = getCuisineVal(newR.getType());
      int course = getCourseVal(newR.getCourse());
      ArrayList<ArrayList<TreeMap<Integer,Recipe>>> chooseCourse = chooseType.get(cuisine);
      ArrayList<TreeMap<Integer,Recipe>> chooseExclusions = chooseCourse.get(course);
      addToExclusions(newR,chooseExclusions);
      if(course!=ALLFOODTYPES){
        chooseExclusions = chooseCourse.get(ALLFOODTYPES);
        addToExclusions(newR,chooseExclusions);
      }
      if(cuisine!=ALLCUISINETYPES){
        chooseCourse = chooseType.get(ALLCUISINETYPES);
        chooseExclusions = chooseCourse.get(course);
        addToExclusions(newR,chooseExclusions);
        if(course!=ALLFOODTYPES){
          chooseExclusions = chooseCourse.get(ALLFOODTYPES);
          addToExclusions(newR,chooseExclusions);
        }
      }
    }
  }
  
  private void addToExclusions(Recipe newR, ArrayList<TreeMap<Integer,Recipe>> exclusions){
    boolean meat = newR.containsMeat();
    boolean seafood = newR.containsSeafood();
    boolean shellfish = newR.containsShellfish();
    boolean dairy = newR.containsDairy();
    boolean vegetarian = newR.isVegetarian();
    boolean vegan = newR.isVegan();
    
    if(meat){
      exclusions.get(EXMEAT).put(newR.getTotalTime(),newR);
      newR.addLocation(exclusions.get(EXMEAT));
    }
    if(seafood){
      exclusions.get(EXSEAFOOD).put(newR.getTotalTime(),newR);
      newR.addLocation(exclusions.get(EXSEAFOOD));
    }
    if(shellfish){
      exclusions.get(EXSHELLFISH).put(newR.getTotalTime(),newR);
      newR.addLocation(exclusions.get(EXSHELLFISH));
    }
    if(dairy){
      exclusions.get(EXDAIRY).put(newR.getTotalTime(),newR);
      newR.addLocation(exclusions.get(EXDAIRY));
    }
    if(vegetarian){
      exclusions.get(EXVEGETARIAN).put(newR.getTotalTime(),newR);
      newR.addLocation(exclusions.get(EXVEGETARIAN));
    }
    if(vegan){
      exclusions.get(EXVEGAN).put(newR.getTotalTime(),newR);
      newR.addLocation(exclusions.get(EXVEGAN));
    }
    exclusions.get(EXALL).put(newR.getTotalTime(),newR);
    newR.addLocation(exclusions.get(EXALL));
  }
  
  private int getCuisineVal(String type){
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
  
  private int getCourseVal(String course){
    if(course.equals("salad")) return SALAD;
    else if(course.equals("appetizer")) return APPETIZER;
    else if(course.equals("entree")) return ENTREE;
    else return ALLFOODTYPES;
  }
  
  public void addNewIngredient(String name){
    ArrayList<ArrayList<ArrayList<TreeMap<Integer,Recipe>>>> chooseType = new ArrayList<ArrayList<ArrayList<TreeMap<Integer,Recipe>>>>();
    ArrayList<ArrayList<TreeMap<Integer,Recipe>>> chooseCourse;
    ArrayList<TreeMap<Integer,Recipe>> chooseExclusions;
    TreeMap<Integer,Recipe> dataHolder;
    for(int i=0; i<12; i++){
      chooseCourse = new ArrayList<ArrayList<TreeMap<Integer,Recipe>>>();
      for(int j=0; j<4; j++){
        chooseExclusions = new ArrayList<TreeMap<Integer,Recipe>>();
        for(int k=0; k<7; k++){
          dataHolder = new TreeMap<Integer,Recipe>();
          chooseExclusions.add(dataHolder);
        }
        chooseCourse.add(chooseExclusions);
      }
      chooseType.add(chooseCourse);
    }
    map.put(name,chooseType);
  }
  
  public void find(int time, ArrayList<String> ingred, ArrayList<String> exclude, String type, String course){
    ArrayList<TreeMap<Integer,Recipe>> options = getListOfTrees(time, ingred, exclude, type, course);
    System.out.println(options);
    MyStack<Recipe> stack = new MyStack<Recipe>();
    for(int i=0; i<options.size(); i++){
      TreeMap<Integer,Recipe> looking = options.get(i);
      Iterator it = looking.entrySet().iterator();
      while(it.hasNext()){
        Map.Entry pair = (Map.Entry)it.next();
        Recipe current = (Recipe) pair.getValue();
        if(time>=current.getTotalTime()){
          ArrayList<String> myIngred = current.getIngredients();
          ArrayList<Boolean> matches = new ArrayList<Boolean>();
          for(int j=0; j<ingred.size(); j++) matches.add(false);
          for(int k=0; k<myIngred.size(); k++){
            for(int j=0;j<ingred.size();j++){
              if(matches.get(j)!=true){
                if(ingred.get(j).equals(myIngred.get(k))){
                  matches.set(j,true);
                  break;
                }
              }
            }
          }
          boolean good = true;
          for(int j=0;j<matches.size();j++) if(matches.get(j)!=true){
            good=false;
          }
          if(good) good = checkExclusions(exclude,current);
          if(good){
            if(time==current.getTotalTime()){
              System.out.println(current.getInfo());
              return;
            }
            else stack.add(current);
          }
        }
        else break;
      }
    }
    Recipe answer = stack.getLast();
    String output = answer == null ? "I'm sorry, I could not find find any recipes that satisfy your conditions." : answer.getInfo();
    System.out.println(output);
  }
  
  private boolean checkInclusions(ArrayList<String> inclusions, Recipe recipe){
  return false;
  }
  
  private boolean checkExclusions(ArrayList<String> exclusions, Recipe recipe){
    for(int i=0; i<exclusions.size(); i++){
      String current = exclusions.get(i);
      if(current.equals("meat") && recipe.containsMeat()) return false;
      else if(current.equals("seafood") && recipe.containsSeafood()) return false;
      else if(current.equals("dairy") && recipe.containsDairy()) return false;
      else if(current.equals("vegan") && recipe.isVegan()) return false;
      else if(current.equals("vegetarian") && recipe.isVegetarian()) return false;
      else if(current.equals("shellfish") && recipe.containsShellfish()) return false;
    }
    return true;
  }
  
  private ArrayList<TreeMap<Integer,Recipe>> getListOfTrees(int time, ArrayList<String> ingred, ArrayList<String> exclude, String type, String course){
    ArrayList<ArrayList<ArrayList<TreeMap<Integer,Recipe>>>> chooseType = null;
    for(int i=0; i<validIngredients.size() && chooseType==null; i++){
      for(int k=0; k<ingred.size() && chooseType==null; k++){
        String current = ingred.get(k);
        if(validIngredients.get(i).equals(current)) chooseType = map.get(current);
      }
    }
    if(chooseType==null){
      chooseType = map.get("all");
    }
    ArrayList<ArrayList<TreeMap<Integer,Recipe>>> chooseCourse = type.equals("") ? chooseType.get(getCuisineVal("all")) : chooseType.get(getCuisineVal(type));
    ArrayList<TreeMap<Integer,Recipe>> chooseExclusions = course.equals("") ? chooseCourse.get(getCourseVal("all")) : chooseCourse.get(getCourseVal(course));
    ArrayList<TreeMap<Integer,Recipe>> options = null; 
    ArrayList<String> validChoices = ruleBook.getInclusions();
    for(int i=0; i<exclude.size() && options==null; i++){
      for(int k=0;k<validChoices.size() && options==null; k++){
        if(exclude.get(i).equals(validChoices.get(k))) options = getOthers(chooseExclusions,validChoices.get(k));
      }
    }
    if(options == null){
      options = new ArrayList<TreeMap<Integer,Recipe>>();
      options.add(chooseExclusions.get(EXALL));
    }
    return options;
  }
  
  private ArrayList<TreeMap<Integer,Recipe>> getOthers(ArrayList<TreeMap<Integer,Recipe>> list, String me){
    ArrayList<TreeMap<Integer,Recipe>> output = new ArrayList<TreeMap<Integer,Recipe>>();
    if(!me.equals("meat")) output.add(list.get(EXMEAT));
    if(!me.equals("seafood")) output.add(list.get(EXSEAFOOD));
    if(!me.equals("shellfish")) output.add(list.get(EXSHELLFISH));
    if(!me.equals("dairy")) output.add(list.get(EXDAIRY));
    if(!me.equals("vegetarian")) output.add(list.get(EXVEGETARIAN));
    if(!me.equals("vegan")) output.add(list.get(EXVEGAN));
    return output;
  }
  
  public static void main(String[] args){
    SmartDatabase test = new SmartDatabase(new FoodRules());
    Recipe tmp = new Recipe("scallionios","appetizer","French","peas","eggs", "lettuce", 9, 9);
    test.add(tmp);
    tmp = new Recipe("scallions3","all","Italian","scallions peas","arugula", "lettuce mesclun", 9, 9);
    test.add(tmp);
    tmp = new Recipe("scallions2","entree","Italian","scallions cauliflower","chicken", "spinach", 9, 9);
    test.add(tmp);
    ArrayList<String> lol = new ArrayList<String>();
    lol.add("lettuce");
    ArrayList<String> troll = new ArrayList<String>();
    troll.add("");
    test.find(19,lol, troll,"Italian","");
    System.out.println("");
    test.find(17,lol, troll,"French","");
    System.out.println("done");
  }
}