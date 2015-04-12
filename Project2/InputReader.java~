import java.util.Scanner;
import java.util.ArrayList;

public class InputReader{
  
  private Scanner sc;
  private ArrayList<String> validCommands, validTypes, validIngredients, validCourses;
  //private DecisionDatabase decisionDatabase;
  private MasterDatabase masterDatabase;
  private FoodRules ruleBook;
  
  
  public InputReader(/*DecisionDatabase decide, */MasterDatabase master, FoodRules rules){
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
    
    //decisionDatabase = decide;
    masterDatabase = master;
  }
  
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
    String name = getName(sc);
    String course = getCourse(sc);
    String type = getType(sc);
    String main = getIngredients("main",sc);
    String addons = getIngredients("addons",sc);
    String sides = getIngredients("sides",sc);
    int prep = getTime("prep",sc);
    int cook = getTime("cook",sc);
    Recipe newR = new Recipe(name, course, type, main, addons, sides, prep, cook);
    System.out.println("Are you sure you would like to add this Recipe? Type y to add, anything else to not add.\n");
    newR.getInfo();
    String answer = sc.nextLine();
    if(answer.equals("y")){
      System.out.println("adding");
    }
    //decisionDatabase.add(newR);
    masterDatabase.add(newR);
  }
  private String getName(Scanner sc){
    System.out.println("What is the name of the recipe?");
    return sc.nextLine();
  }
  
  private String getType(Scanner sc){
    System.out.println("What is the type of the recipe? i.e. Italian, Chinese, Greek, Turkish, Indian, Pakistan, French, or Korean");
    String type;
    while(true){
      type = sc.nextLine();
      for(int i=0; i<validTypes.size(); i++){
        if(validTypes.get(i).equals(type)) return type;
      }
      System.out.println("That was not a valid course, try again!");
    }
  }
  
  private String getCourse(Scanner sc){
    System.out.println("What course is this recipe? i.e. appetizer, salad or entree");
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
    String line;
    int time=0;
    while(true){
      line = sc.nextLine();
      try{
        time = Integer.parseInt(line);
        break;
      }
      catch(Exception e){
        System.out.println("That was not a valid integer time, try again");
      }
    }
    return time;
  }
  
  private void delete(){
    sc = new Scanner(System.in);
    String name = getName(sc);

    Recipe toDelete = masterDatabase.find(name);
    if(toDelete!=null){
      System.out.println("Are you sure you want to delete this recipe? y to delete, anything else to keep!");
      toDelete.getInfo();
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
  }
  
  private void plan(){
    //plan a meal
  }
  
  private void quit(){
    //write data out to file
  }
  
  public static void main(String[] args){
    FoodRules ruleBook = new FoodRules();
    InputReader test = new InputReader(/*new DecisionDatabase(ruleBook),*/ new MasterDatabase(), ruleBook);
    test.getCommand();
  }
  
}