import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class DataHandler{
  
  private Scanner dataScanner;
  private PrintWriter dataWriter;
  
  public DataHandler(String inputFile, String outputFile){
    try{
      dataScanner = new Scanner(new File(inputFile));
      dataWriter = new PrintWriter(outputFile);
    }
    catch(FileNotFoundException e){
      System.out.println("\nFile error, the file you have chosen does not exist!\n");
    }
  }
  
  public void getData(){
    while(dataScanner.hasNextLine()){
      String name = dataScanner.nextLine();
      name = name.substring(6,name.length()-1);
      String course = dataScanner.nextLine();
      String type = dataScanner.nextLine();
      String main = dataScanner.nextLine();
      String addons = dataScanner.nextLine();
      String sides = dataScanner.nextLine();
      String prepTime = dataScanner.nextLine();
      String cookTime = dataScanner.nextLine();
      
      Recipe newRecipe = new Recipe(name, course, type, main, addons, sides, prepTime, cookTime);
      
      if(dataScanner.hasNextLine()) dataScanner.nextLine();
      else break;
    }
  }
  
  public void writeData(){
    Recipe tmp = new Recipe("","","","","","","","");
    dataWriter.println("name: " + tmp.getName());
    dataWriter.println("type: " + tmp.getCourse());
    dataWriter.println("cuisine: " + tmp.getType());
    dataWriter.println("main: " + tmp.getMain());
    dataWriter.println("addons: " + tmp.getAddons());
    dataWriter.println("sides: " + tmp.getSides());
    dataWriter.println("prep: " + tmp.getPrepTime());
    dataWriter.println("cook: " + tmp.getCookTime());
    
  }
  
}