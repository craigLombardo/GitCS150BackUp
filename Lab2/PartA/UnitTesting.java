import java.util.*;
import java.io.*;

public class UnitTesting{
  private int totalIntVal=0;
  private double totalDoubleVal=0.0;
  private String totalString="";
  
  public static void main(String[] args){
    try{
      UnitTesting labOne = new UnitTesting();
      labOne.run(args[0], args[1]);
    }
    catch(Exception e){
      System.out.println("Oops, an I/O error has occurred, try again!");
    }
  }
  
  public void run(String inputFile, String outputFile){
    if(checkInputFile(inputFile)){
      try{
        //creates a scanner associated with the user defined file
        Scanner sc = new Scanner(new File(inputFile));
        Writer opWriter = new FileWriter(outputFile);
        
        //creates all necessary variables
        int itemCount=0;
        
        //as long as there is another line in the file we will execute
        while(sc.hasNext()){
          itemCount++;
          if (sc.hasNextInt()) addInt(sc.nextInt());
          else if(sc.hasNextDouble()) addDouble(sc.nextDouble());
          else addString(sc.next());        
        }
        
        sc.close();
        
        totalString = totalString.substring(0,totalString.length()-1);
        opWriter.write("The collected words are \"" + totalString + "\"\n");
        opWriter.write("The integer total is " + totalIntVal + "\n");
        opWriter.write("The double total is " + totalDoubleVal + "\n");
        opWriter.close();
      }
      catch(Exception n){
        System.out.println("Oops, an I/O error has occurred, try again!");
      } 
    }
    else System.out.println("That input file does not exist in your current directory!");
  }
  
  public void addInt(int number){
    totalIntVal+=number;
  }
  
  public void addDouble(double number){
    totalDoubleVal+=number;
  }
  
  public void addString(String stringToAdd){
    if(!stringToAdd.equals("")) totalString += stringToAdd + " ";
  }
  
  public int getIntTotal(){
    return totalIntVal;
  }
  
  public double getDoubleTotal(){
    return totalDoubleVal;
  }
  
  public String getString(){
    return totalString;
  }
  
  public boolean checkInputFile(String inputFile){
    try{
      Scanner test = new Scanner(new File(inputFile));
      return true;
    }
    catch(Exception e){
      return false;
    }
  }
  
}