import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.io.File;

public class DataHandler{
  
  private Scanner dataScanner;
  private SmartDatabase smartDatabase;
  private MasterDatabase masterDatabase;
  
  public DataHandler(String inputFile, String outputFile, SmartDatabase smart, MasterDatabase master){
    try{
      dataScanner = new Scanner(new File(inputFile));
    }
    catch(java.io.FileNotFoundException e){
      System.out.println("\nFile error, the file you have chosen does not exist!\n");
    }
    
    smartDatabase = smart;
    masterDatabase = master;
  }
  
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
  
  public void writeData(){
    
  }
 
  public static void main(String[] args){
    FoodRules ruleBook = new FoodRules();
    DataHandler test = new DataHandler("recipe_10.txt","test.txt",new SmartDatabase(ruleBook), new MasterDatabase());
    test.getData();
    test.writeData();
  }
  
}