import java.util.*;

/**
 * This class serves as the test environment. Through this class all other classes will be called, they will run,
 * and  then data such as run time will be printed. Through use of this class the user may also specify the number of
 * iterations and how large the array will be.
 * @author Craig Lombardo
 */
public class ListExperimentController{
  
  /**
   * This method will be used to return the total amount of time taken for the computer to find the second
   * largest number in an ArrayListIntContainer.
   * @param numberOfItems This is an integer value of how many items will be added to the front of array before the search is conducted.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken,in ns, to find the second largest
   * integer in the ArrayList.
   */
  public long arrayTimeFindSecond(int numberOfItems, int seed){
    ArrayListIntContainer arrayCont = new ArrayListIntContainer();
    Wheel myWheel = new Wheel(seed, numberOfItems);
    
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      arrayCont.addFromFront(randomNumber);
    }
    
    long startTime = System.nanoTime();
    arrayCont.findSecondLargest();
    long stopTime = System.nanoTime();

    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method arrayTimeFindSecond a specified number of times. The program starts at 55000 elements,
   * and increases by 25000 each time. This method averages ten runs of the returned values for arrayTimeFindSecond.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  
  public String runArrayFindSecond(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 30000+(25000*i);
      long total=0;
      for(int j = 0; j<10; j++){
        long time=arrayTimeFindSecond(numberOfItems,157);
        total+=time;
      }
      finalString= finalString + numberOfItems+","+ (total/10)+",";
      if(i!=number) finalString = finalString +"\n";
      System.out.println(numberOfItems+","+ (total/10)+",");
    }
    return finalString;
  }
  
  /**
   * This method will be used to return the total amount of time taken for the computer to find the second
   * largest number in a LinkedListIntContainer.
   * @param numberOfItems This is an integer value of how many items will be added to the front of array before the search is conducted.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken,in ms, to find the second largest
   * integer in the LinkedList.
   */
  
  public long linkedTimeFindSecond(int numberOfItems, int seed){
    LinkedListIntContainer linkedCont = new LinkedListIntContainer();
    Wheel myWheel = new Wheel(seed, numberOfItems);
    
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      linkedCont.addFromFront(randomNumber);
    }
    
    long startTime = System.currentTimeMillis();
    linkedCont.findSecondLargest();
    long stopTime = System.currentTimeMillis();
    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method linkedTimeFindSecond a specified number of times. The program starts at 5000 elements,
   * and increases by 5000 each time. This method averages ten runs of the returned values for linkedTimeFindSecond.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  public String runLinkedFindSecond(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = (5000*i);
      long total=0;
      for(int j = 0; j<10; j++){
        long time=linkedTimeFindSecond(numberOfItems,157);
        total+=time;
      }
      finalString= finalString + numberOfItems+","+ (total/10)+",";
      if(i!=number) finalString = finalString +"\n";
      System.out.println(numberOfItems+","+ (total/10)+",");
    }
    return finalString;
  }
  
  /**
   * The main method is used so the program may be run through a console. This is beneficial as the 
   * output can easily be piped to a .csv file
   * @param args Argument 1 (args[0]) is the test type, either "array" or "linked" in all lowercase.
   * Argument 1 (args[1]) is the number passed into the appropriate run second test. It is important
   * to note that responses other than "array" or "linked" in all lowercase for the first argument, or
   * a valid number for the second argument will not lead to desired results.
   */
  public static void main(String[] args){
      if(args[0].equals("array")){
        ListExperimentController testOne = new ListExperimentController();
        System.out.println("arrayTimeFindSecond test,");
        System.out.println("Number Of,Average Time(ns),");
        testOne.runArrayFindSecond(Integer.parseInt(args[1]));
      }
      else if(args[0].equals("linked")){
        ListExperimentController testThree = new ListExperimentController();
        System.out.println("linkedTimeFindSecond test,");
        System.out.println("Number Of,Average Time(ms),");
        testThree.runLinkedFindSecond(Integer.parseInt(args[1]));
      }
  }
}