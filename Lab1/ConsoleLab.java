import java.io.Console;

public class ConsoleLab{
  
  public static void main(String[] args){
    
    Console myConsole=null;
    int lineCount =1;
    String numberToPrint, textToPrint="";
    
    try{
      myConsole=System.console();
      
      if (myConsole != null){    
        while(true){
          try{
            numberToPrint=myConsole.readLine("How many lines are we reading?\n:");
            lineCount=Integer.parseInt(numberToPrint);
            break;
          }
          catch(NumberFormatException num){
            System.out.println("That was not a valid number, try again!");
          }
        }
      }
      
      for(int i=0; i < lineCount; i++){
        textToPrint=textToPrint+myConsole.readLine("")+"\n";
      }
      
      System.out.println("\nNumber of lines: " + lineCount);
      System.out.print(textToPrint);
    
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  
}