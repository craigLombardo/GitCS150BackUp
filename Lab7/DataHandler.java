import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.NoSuchElementException;

/**
 * This class creates a DataHandler that can read a file in, create
 * instances of a Restaurant and put the Restaurants into a TreeSet
 * and then may output the sorted TreeSet data to a file.
 */
public class DataHandler{
  
  private Scanner dataScanner;
  private PrintWriter dataWriter;
  private TreeSet<Restaurant> myTree;
  
  /**
   * This constructor method creates an instance of DataHandler, which
   * can read in a file of unsorted Restaurants and write out the
   * sorted Restaurants to a file.
   * @param inputFile The input file to read from.
   * @param outputFile The output file to write to.
   */
  public DataHandler(String inputFile, String outputFile){
    myTree = new TreeSet<Restaurant>(new RestaurantComparator());
    try{
      dataScanner = new Scanner(new File(inputFile));
      dataWriter = new PrintWriter(outputFile);
    }
    catch(FileNotFoundException e){
      System.out.println("\nFile error, the file you have chosen does not exist!\n");
    }
  }
  
  /**
   * This method creates instances of Restaurants which will be stored in a TreeSet.
   * The method will read the input file line by line, taking in the restaurant name, then city, type, 
   * date opened, opening time, and finally closing time. If not all arguments are present (all of the 
   * required lines), then the programs output file may not be accurate.
   */
  public void getData(){
    //checks to see if we have reached the end of the file or not
    while(dataScanner.hasNextLine()){
      
      try{
        String restName = dataScanner.nextLine();
        String city = dataScanner.nextLine();
        String type = dataScanner.nextLine();
        String dateOpened = dataScanner.nextLine();
        String openingTime = dataScanner.nextLine();
        String closingTime = dataScanner.nextLine();
        
        Restaurant newRest = new Restaurant(restName, city, type, dateOpened, openingTime, closingTime);
        
        myTree.add(newRest);
      }
      catch(NoSuchElementException e){
        
      }
      
      if(dataScanner.hasNextLine()) dataScanner.nextLine();
    }
  }
  
  /**
   * This method writes the sorted Restaurants out to the output file. Each 
   * Restaurant will be printed out in the same order it was read in; name, city,
   * type, date opened, opening time, and then closing time.
   */
  public void exportData(){
    Iterator<Restaurant> iter = myTree.iterator();
    while(iter.hasNext()){
      Restaurant rest = iter.next();
      dataWriter.println("Name .......... " + rest.getName());
      dataWriter.println("City .......... " + rest.getCity());
      dataWriter.println("Type .......... " + rest.getType());
      dataWriter.println("Date Opened ... " + rest.getDateOpened());
      dataWriter.println("Open Time ..... " + rest.getOpeningTime());
      dataWriter.println("Closing Time .. " + rest.getClosingTime()+"\n");
    }
    dataWriter.close();
  }
  
  /**
   * The main method is used to read in a list of unsorted Restaurants from an input file, 
   * add them to a TreeSet which sorts them using the RestaurantComparator, 
   * and then write out the sorted Restaurant list to an output file. Both file foramts should
   * be .txt; should another file type be used, it is important to note that there is no error
   * checking for such actions.
   * @param args The arguments passed in when running this program. The first argument,
   * args[0], is the input file and the second argument, args[1], is the output file.
   */
  public static void main(String[] args){
    try{
      DataHandler data = new DataHandler(args[0],args[1]);
      
      data.getData();
      data.exportData();
    }
    catch(NullPointerException e){
    }
  }
  
}