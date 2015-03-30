import java.util.*;
import java.io.*;

public class Lab2aUnitTesting{
  
  public static void main(String[] args){
    try{
      LabOneScanner labOne = new LabOneScanner();
      labOne.run(args[0], args[1]);
    }
    catch(Exception e){
      System.out.println("Oops, an I/O error has occurred, try again!");
    }
  }
    
  public void run(String inputFile, String outputFile){
    
    try{
      //creates a scanner associated with the user defined file
      Scanner sc = new Scanner(new File(inputFile));
      Writer opWriter = new FileWriter(outputFile);
      
      //creates all necessary variables
      int itemCount=0;
      int totalIntVal=0;
      double totalDoubleVal=0;
      String totalString="";
      
      //as long as there is another line in the file we will execute
      while(sc.hasNext()){
        itemCount++;
        if (sc.hasNextInt()) totalIntVal=totalIntVal+sc.nextInt();
        else if(sc.hasNextDouble()) totalDoubleVal = totalDoubleVal + sc.nextDouble();
        else totalString=totalString+ sc.next() + " ";        
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
  
}