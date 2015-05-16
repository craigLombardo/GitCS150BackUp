import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class handles all of the user input and performs appropriate action based on the user input.
 * @author Craig Lombardo
 */
public class InputReader{
  
  private Scanner sc;
  private ArrayList<String> validCommands, validTypes, validIngredients, validOptions;
  private SmartDatabase smartDatabase;
  private FoodRules ruleBook;
  private Database map;
  
  /**
   * This constructor method creates an input reader with the two databases and a ruleset.
   * @param smart The SmartDatabase to be used.
   * @param rules The ruleset to be used by this reader.
   * @param theMap The map we want to read from/interact with
   */
  public InputReader(SmartDatabase smart, FoodRules rules, Database theMap){
    validCommands = new ArrayList<String>();
    validCommands.add("plan");
    validCommands.add("quit");
    
    ruleBook = rules;
    validTypes = ruleBook.getCuisineTypes();
    validIngredients = ruleBook.getIngredients();
    
    smartDatabase = smart;
    map = theMap;
    validOptions = ruleBook.getInclusions();
  }
  
  /**
   * This method gets the next command the user would like to do and then handles things
   * accordingly based on their response.
   */
  public void getCommand(){
    sc = new Scanner(System.in);
    boolean valid = false;
    System.out.println("What would you like to do? You can plan, or quit");
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
      if(command.equals("plan")) plan();
      else System.out.println("That was not a valid command, try again!");
      getCommand();
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
  
  private void plan(){
    //plan a meal
    sc = new Scanner(System.in);
    int time = (int) Double.POSITIVE_INFINITY;
    map.setGasPrice(getGasPrice(sc));
    map.setMealCount(getMealCount(sc));
    ArrayList<String> include = getClusions(sc,"include");
    ArrayList<String> exclude = getClusions(sc,"exclude");
    String type = getType(sc,true);
    if(checkIfPossible(include,exclude)){
      String plan = smartDatabase.plan(time, include, exclude, type);
      System.out.println(plan);
      map.calculate(plan);
    }
    else{
      System.out.println("I'm sorry, I could not find find something that satisfies your conditions.");
    }
  }
  
  private void quit(){
    //exit, things are writen data out to file in cookbook
  }
  
  private double getGasPrice(Scanner sc){
    System.out.println("What is the unit cost of gas?");
    String line;
    while(true){
      line = sc.nextLine();
      try{
        double cost = Double.parseDouble(line);
        return cost;
      }
      catch(Exception e){
        System.out.println("That was not a valid price, try again!");
      }
    }
  }
  
  private int getMealCount(Scanner sc){
    System.out.println("How many meals are you preparing?");
    String line;
    while(true){
      line = sc.nextLine();
      try{
        int count = Integer.parseInt(line);
        if(count<=0) throw new Exception();
        return count;
      }
      catch(Exception e){
        System.out.println("That was not a valid number, try again!");
      }
    }
  }
}