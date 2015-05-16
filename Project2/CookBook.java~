/**
   * This class serves as the overarching class that calls upon the input reader and the 
   * data handler. This class ensures that all data structures have a single reference point,
   * the one in this class.
   * @author Craig Lombardo
   */
public class CookBook{
  
  private FoodRules ruleBook;
  private DataHandler data;
  private InputReader input;
  private MasterDatabase master;
  private SmartDatabase smart;
  
  /**
   * This constructor creates a CookBook with a given input file, and writes out
   * to a file called "CookBookOutputInformation.txt" if it exists it will be overwritten
   * if it does not then it will be created.
   * @param inputFile the input file to read from.
   */
  public CookBook(String inputFile){
    ruleBook = new FoodRules();
    master = new MasterDatabase();
    smart = new SmartDatabase(ruleBook);
    data = new DataHandler(inputFile, "CookBookOutputInformation.txt", smart, master);
    input = new InputReader(smart, master, ruleBook);
  }
  
  /**
   * This method starts the prompts from the input reader.
   */
  public void activate(){
    data.getData();
    input.getCommand();
    data.writeData();
  }
  
  /**
   * Through the main method the user will be able to specify the input file they would like to use, args[0] is
   * the input file.
   * @param args The arguments passed in through the main method, args[0] is the input file.
   */
  public static void main(String[] args){
    try{
      CookBook test = new CookBook(args[0]);
      test.activate();
    }
    catch(java.lang.NullPointerException e){
      
    }
  }
}