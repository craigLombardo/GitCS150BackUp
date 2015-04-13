import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class handles all of the user input and performs appropriate action based on the user input.
 * @author Craig Lombardo
 */
public class InputReader{
  
  private Scanner sc;
  private ArrayList<String> validCommands, validTypes, validIngredients, validCourses, validOptions;
  private SmartDatabase smartDatabase;
  private MasterDatabase masterDatabase;
  private FoodRules ruleBook;
  
  /**
   * This constructor method creates an input reader with the two databases and a ruleset.
   * @param smart The SmartDatabase to be used.
   * @param master The MasterDatabase to be used.
   * @param rules The ruleset to be used by this reader.
   */
  public InputReader(SmartDatabase smart, MasterDatabase master, FoodRules rules){
    validCommands = new ArrayList<String>();
    validCommands.add("add");
    validCommands.add("delete");
    validCommands.add("find");
    validCommands.add("plan");
    validCommands.add("quit");
    
    ruleBook = rules;
    validTypes = ruleBook.getCuisineTypes();
    validIngredients = ruleBook.getIngredients();
    validCourses = ruleBook.getCourses();
    
    smartDatabase = smart;
    masterDatabase = master;
    
    validOptions = ruleBook.getInclusions();
  }
  
  /**
   * This method gets the next command the user would like to do and then handles things
   * accordingly based on their response.
   */
  public void getCommand(){
    sc = new Scanner(System.in);
    boolean valid = false;
    System.out.println("What would you like to do? You can add, delete, find, plan, or quit");
    String response="";
    while(!valid){
      response = sc.nextLine();
      for(int i=0; i<validCommands.size(); i++){
        if(response.equals(validCommands.get(i))) valid = true;
      }
      if(!valid) System.out.println("That was not a valid option, try again.");
    }
    execute(response);
  }
  
  private void execute(String command){
    if(command.equals("quit")) quit();
    else{
      if(command.equals("add")) add();
      else if(command.equals("delete")) delete();
      else if(command.equals("find")) find();
      else if(command.equals("plan")) plan();
      else System.out.println("That was not a valid command, try again!");
      getCommand();
    }
  }
  
  private void add(){
    sc = new Scanner(System.in);
    String name = getName(sc,true);
    String course = getCourse(sc);
    String type = getType(sc,false);
    String main = getIngredients("main",sc);
    String addons = getIngredients("addons",sc);
    String sides = getIngredients("sides",sc);
    int prep = getTime("prep",sc);
    int cook = getTime("cook",sc);
    Recipe newR = new Recipe(name, course, type, main, addons, sides, prep, cook);
    System.out.println("Adding Recipe: ");
    System.out.println(newR.getInfo());
    smartDatabase.add(newR);
    masterDatabase.add(newR);
  }
  
  private String getName(Scanner sc, boolean add){
    System.out.println("What is the name of the recipe?");
    String name = sc.nextLine();
    if(!add){
      while(true){
        if(name.equals("")) System.out.println("I'm sorry but you need to type something in!");
        else return name;
        name = sc.nextLine();
      }
    }
    else{
      while(true){
      if(masterDatabase.find(name) != null) System.out.println("That name is taken! Choose another one!");
      else return name;
      name = sc.nextLine();
    }
  }
  }
  
  private String getType(Scanner sc, boolean find){
    System.out.println("What is the type of the recipe? i.e. Italian, Chinese, Greek, Turkish, Indian, Pakistan, French, or Korean");
    String type;
    while(true){
      type = sc.nextLine();
      if(find && type.equals("")){
        return "";
      }
      for(int i=0; i<validTypes.size(); i++){
        if(validTypes.get(i).equals(type)) return type;
      }
      System.out.println("That was not a valid course, try again!");
    }
  }
  
  private String getCourse(Scanner sc){
    System.out.println("What course is this recipe? i.e. Appetizer, Salad or Entree");
    String course;
    while(true){
      course = sc.nextLine();
      for(int i=0; i<validCourses.size(); i++){
        if(validCourses.get(i).equals(course)) return course;
      }
      System.out.println("That was not a valid course, try again!");
    }
  }
  
  private String getIngredients(String part, Scanner sc){
    if(part.equals("main")) System.out.println("What are the main ingredients?");
    else if(part.equals("addons")) System.out.println("What are the addons ingredients?");
    else if(part.equals("sides")) System.out.println("What are the sides ingredients?");
    String ingredients = sc.nextLine() + " ";
    ArrayList<String> allIngredients = new ArrayList<String>();
    int start = 0;
    for(int i=0; i<ingredients.length(); i++){
      if(ingredients.substring(i,i+1).compareTo(" ") == 0){
        String current = ingredients.substring(start,i);
        start = i+1;
        if(!current.equals("")){
          boolean valid = false;
          for(int j=0; j<validIngredients.size(); j++){
            if(validIngredients.get(j).equals(current)){
              valid = true;
              allIngredients.add(current);
              break;
            }
          }
          if(!valid){
            ruleBook.addIngredient(current);
            allIngredients.add(current);
          }
        }
      }
    }
    
    int size = allIngredients.size();
    String toReturn = "";
    for(int i=0; i<size; i++){
      toReturn = toReturn + allIngredients.get(i);
      if(i!=size-1) toReturn = toReturn + " ";
    }
    return toReturn;
  }
  
  private int getTime(String which, Scanner sc){
    if(which.equals("prep")) System.out.println("What is the prep time of the recipe");
    else if(which.equals("cook")) System.out.println("What is the cook time of the recipe");
    else if(which.equals("total")) System.out.println("What is the total time you are looking for in a recipe.");
    String line;
    int time=0;
    while(true){
      line = sc.nextLine();
      try{
        time = Integer.parseInt(line);
        break;
      }
      catch(java.lang.NumberFormatException e){
        System.out.println("That was not a valid integer time, try again");
      }
    }
    return time;
  }
  
  private void delete(){
    sc = new Scanner(System.in);
    String name = getName(sc,false);
    Recipe toDelete = masterDatabase.find(name);
    if(toDelete!=null){
      System.out.println("Are you sure you want to delete this recipe? y to delete, anything else to keep!");
      System.out.print(toDelete.getInfo());
      String answer = sc.nextLine();
      if(answer.equals("y")){
        masterDatabase.remove(toDelete);
        toDelete.delete();
      }
    }
    else{
      System.out.println("Sorry, I could not find the recipe named \"" + name + "\"!\n");
    }
  }
  
  private void find(){
    //find a recipe
    sc = new Scanner(System.in);
    int time = getTime("total",sc);
    ArrayList<String> include = getClusions(sc,"include");
    ArrayList<String> exclude = getClusions(sc,"exclude");
    String type = getType(sc,true);
    if(checkIfPossible(include,exclude)){
      Recipe answer = smartDatabase.find(time, include, exclude, type, false, "");
      if(answer == null) System.out.println("I'm sorry, I could not find find something that satisfies your conditions.");
      else System.out.println(answer.getInfo());
    }
    else{
      System.out.println("I'm sorry, I could not find find something that satisfies your conditions.");
    }
  }
  
  private ArrayList<String> getClusions(Scanner sc, String word){
    System.out.println("What would you like to " + word + "? If nothing, simply keep the field blank.");
    System.out.println("Some example options are: meat, seafood, shellfish, dairy, vegetarian or vegan");
    String answer = sc.nextLine() + " ";
    int start = 0;
    ArrayList<String> inclusions = new ArrayList<String>();
    if(!answer.equals("")){
      for(int i=0; i<answer.length(); i++){
        if(answer.substring(i,i+1).equals(" ")){
          String current = answer.substring(start,i);
          start = i+1;
          if(!current.equals("")){
            inclusions.add(current);
          }
        }
      }
    }
    return inclusions;
  }
  
  private boolean checkIfPossible(ArrayList<String> include, ArrayList<String> exclude){
    for(int i=0; i<include.size(); i++){
      String current = include.get(i);      
      for(int k=0; k<exclude.size(); k++){
        if(current.equals(exclude.get(k))) return false;
        ArrayList<String> subset = new ArrayList<String>();
        String currentExclusion = exclude.get(k);
        if(currentExclusion.equals("meat")) subset = ruleBook.getMeats();
        else if(currentExclusion.equals("seafood")) subset = ruleBook.getSeafood();
        else if(currentExclusion.equals("dairy")) subset = ruleBook.getDairy();
        else if(currentExclusion.equals("vegan")) subset = ruleBook.getVegan();
        else if(currentExclusion.equals("vegetarian")) subset = ruleBook.getVegetarian();
        else if(currentExclusion.equals("shellfish")) subset = ruleBook.getShellfish();
        for(int j=0; j<subset.size(); j++){
          if(current.equals(subset.get(j))) return false;
        }
      }
      boolean possible = false;
      for(int l=0; l<validIngredients.size(); l++){
        if(current.equals(validIngredients.get(l))) possible = true;
      }
      for(int l=0; l<validOptions.size(); l++){
        if(current.equals(validOptions.get(l))) possible = true;
      }
      if(!possible) return false;
    }
    return true;
  }
  
  private void plan(){
    //plan a meal
    sc = new Scanner(System.in);
    int time = getTime("total",sc);
    ArrayList<String> include = getClusions(sc,"include");
    ArrayList<String> exclude = getClusions(sc,"exclude");
    String type = getType(sc,true);
    if(checkIfPossible(include,exclude)){
      smartDatabase.plan(time, include, exclude, type);
    }
    else{
      System.out.println("I'm sorry, I could not find find something that satisfies your conditions.");
    }
  }
  
  private void quit(){
    //exit, things are writen data out to file in cookbook
  }
  
}