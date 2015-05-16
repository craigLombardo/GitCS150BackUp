/**
 * This class serves as the overarching class that calls upon the input reader and the 
 * data handler. This class ensures that all data structures have a single reference point,
 * the one in this class.
 * @author Craig Lombardo
 */
public class Optimizer{
  
  private FoodRules ruleBook;
  private DataHandler data;
  private InputReader input;
  private SmartDatabase smart;
  private Database map;
  
  /**
   * This constructor creates an optimizer with a map and other important info.
   * @param recipeFile The recipe input file to read from.
   * @param connectivityFile The connectivity input file to read from.
   * @param farmFile The farm input file to read from.
   * @param restFile The restaurant input file to read from.
   */
  public Optimizer(String recipeFile, String connectivityFile, String farmFile, String restFile){
    ruleBook = new FoodRules();
    smart = new SmartDatabase(ruleBook);
    data = new DataHandler(recipeFile, "CookBookOutputInformation.txt", smart);
    map = new Database(connectivityFile,farmFile,restFile);
    input = new InputReader(smart, ruleBook, map);
  }
  
  /**
   * This method starts the prompts from the InputReader.
   */
  public void activate(){
    data.getData();
    input.getCommand();
  }
  
  /**
   * Through the main method the user will be able to specify the input files they would like to use
   * @param args <br> args[0] = recipeFile The recipe input file to read from.
   * <br> args[1] = connectivityFile The connectivity input file to read from.
   * <br> args[2] = farmFile The farm input file to read from.
   * <br> args[3] = restFile The restaurant input file to read from.
   */
  public static void main(String[] args){
    //"exampleData/connectivity.txt","exampleData/farms.txt","exampleData/restaurants.txt"
    try{
      Optimizer test = new Optimizer(args[0],args[1],args[2],args[3]);
      test.activate();
    }
    catch(java.lang.NullPointerException e){
      
    }
  }
}