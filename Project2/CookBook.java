public class CookBook{
  
  private FoodRules ruleBook;
  private DataHandler data;
  private InputReader input;
  private MasterDatabase master;
  private SmartDatabase smart;
  
  public CookBook(String inputFile, String outputFile){
    ruleBook = new FoodRules();
    master = new MasterDatabase();
    smart = new SmartDatabase(ruleBook);
    data = new DataHandler(inputFile, outputFile, smart, master);
    input = new InputReader(smart, master, ruleBook);
  }
  
  public void activate(){
    data.getData();
    input.getCommand();
    data.writeData();
  }
  
  public static void main(String[] args){
    //"exampleRecipe/recipeDB/recipe_60000a.txt"
    //"recipe_10.txt"
    CookBook test = new CookBook("recipe_10.txt","tmptmptmpsample.txt");
    test.activate();
  }
}