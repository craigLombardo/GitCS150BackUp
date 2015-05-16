import java.util.Scanner;
import java.io.File;

/**
 * This method will pull in all of the data from a specified text file and put it into the data structures
 * for use in searching, planning etc. The class will also receive an output file which it will write out to
 * upon completion.
 * @author Craig Lombardo
 */
public class DataHandler{
  
  private Scanner dataScanner;
  private SmartDatabase smartDatabase;
  private MasterDatabase masterDatabase;
  private String output;
  
  /**
   * This constructor creates a DataHandler with the given input and output files as well as the two databases it will
   * be adding to.
   * @param inputFile The input file to read from.
   * @param outputFile The output file to write to.
   * @param smart The SmartDatabase to add information to.
   * @param master The MasterDatabase to add information to
   */
  public DataHandler(String inputFile, String outputFile, SmartDatabase smart, MasterDatabase master){
    output = outputFile;
    try{
      dataScanner = new Scanner(new File(inputFile));
    }
    catch(java.io.FileNotFoundException e){
      System.out.println("\nFile error, the file you have chosen does not exist!\n");
    }
    smartDatabase = smart;
    masterDatabase = master;
  }
  
  /**
   * This method collects all of the data from the input file and places it in the two databases.
   */
  public void getData(){
    while(dataScanner.hasNextLine()){
      try{
        String name = dataScanner.nextLine().substring(6);
        String course = dataScanner.nextLine().substring(6);
        String type = dataScanner.nextLine().substring(9);
        String main = dataScanner.nextLine().substring(6);
        String addons = dataScanner.nextLine().substring(8);
        String sides = dataScanner.nextLine().substring(7);
        int prepTime = Integer.parseInt(dataScanner.nextLine().substring(6));
        int cookTime = Integer.parseInt(dataScanner.nextLine().substring(6));
        
        Recipe newR = new Recipe(name, course, type, main, addons, sides, prepTime, cookTime);
        newR.getInfo();
        masterDatabase.add(newR);
        smartDatabase.add(newR);
        if(dataScanner.hasNextLine()) dataScanner.nextLine();
      }
      catch(Exception e){
        break;
      }
    }
  }
  /**
   * This method writes out the data from the databases to the output file.
   */
  public void writeData(){
    masterDatabase.printOut(output);
  }
}