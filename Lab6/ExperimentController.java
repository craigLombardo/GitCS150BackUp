import java.util.*;

/**
 * This class serves as the test environment. Through use of this class the user may test
 * the two types of lists, and the two sorting types. The user may also specify the number 
 * of iterations and how large the array will be.
 * @author Craig Lombardo
 */
public class ExperimentController{
  
  /**
   * This method will be used to return the total amount of time taken for the computer to sort an
   * ArrayList using insertion sort.
   * @param numberOfItems This is an integer value of how many items will be added to the front of the list before sorting.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken,in ms, to sort the list.
   */
  public long timeArrayInsertion(int numberOfItems, int seed){
    ArrayListInsertionSort myList = new ArrayListInsertionSort();
    Wheel myWheel = new Wheel(seed, numberOfItems);
    
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      myList.addElement(randomNumber);
    }
    
    long startTime = System.currentTimeMillis();
    myList.insertionSort();
    long stopTime = System.currentTimeMillis();
    
    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method myTimeArrayInsertion a specified number of times. The program increments the number 
   * of added elements by 50000 each time. This method averages five runs of the returned values for myTimeArrayInsertion.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  public String runTimeArrayInsertion(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 50000*i;
      long total=0;
      for(int j = 0; j<5; j++){
        long time=timeArrayInsertion(numberOfItems,162837);
        total+=time;
      }
      finalString= finalString + numberOfItems+","+ (total/10)+",";
      if(i!=number) finalString = finalString +"\n";
      System.out.println(numberOfItems+","+ (total/10)+",");
    }
    return finalString;
  }
  
  
  /**
   * This method will be used to return the total amount of time taken for the computer to sort a
   * LinkedList using insertion sort.
   * @param numberOfItems This is an integer value of how many items will be added to the front of the list before sorting.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken,in ms, to sort the list.
   */
  public long timeLinkedInsertion(int numberOfItems, int seed){
    LinkedListInsertionSort myList = new LinkedListInsertionSort();
    Wheel myWheel = new Wheel(seed, numberOfItems);
    
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      myList.addElement(randomNumber);
    }
    
    long startTime = System.currentTimeMillis();
    myList.insertionSort();
    long stopTime = System.currentTimeMillis();
    
    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method timeLinkedInsertion a specified number of times. The program increments the number 
   * of added elements by 500 each time. This method averages five runs of the returned values for timeLinkedInsertion.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  public String runTimeLinkedInsertion(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 500*i;
      long total=0;
      for(int j = 0; j<5; j++){
        long time=timeLinkedInsertion(numberOfItems,2730429);
        total+=time;
      }
      finalString= finalString + numberOfItems+","+ (total/10)+",";
      if(i!=number) finalString = finalString +"\n";
      System.out.println(numberOfItems+","+ (total/10)+",");
    }
    return finalString;
  }
  
  /**
   * This method will be used to return the total amount of time taken for the computer to sort 
   * ArrayList using ShellSort.
   * @param numberOfItems This is an integer value of how many items will be added to the front of the list before sorting.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken,in ms, to sort the list.
   */
  public long timeArrayShell(int numberOfItems, int seed){
    ArrayListShellSort myList = new ArrayListShellSort();
    Wheel myWheel = new Wheel(seed, numberOfItems);
    
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      myList.addElement(randomNumber);
    }
    
    long startTime = System.currentTimeMillis();
    myList.shellSort();
    long stopTime = System.currentTimeMillis();
    
    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method timeArrayShell a specified number of times. The program increments the number 
   * of added elements by 1000000 each time. This method averages five runs of the returned values for timeArrayShell.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  public String runTimeArrayShell(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 2000000*i;
      long total=0;
      for(int j = 0; j<5; j++){
        long time=timeArrayShell(numberOfItems,63827839);
        total+=time;
      }
      finalString= finalString + numberOfItems+","+ (total/10)+",";
      if(i!=number) finalString = finalString +"\n";
      System.out.println(numberOfItems+","+ (total/10)+",");
    }
    return finalString;
  }
  
  /**
   * This method will be used to return the total amount of time taken for the computer to sort a
   * LinkedList using ShellSort.
   * @param numberOfItems This is an integer value of how many items will be added to the front of the list before sorting.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken,in ms, to sort the list.
   */
  public long timeLinkedShell(int numberOfItems, int seed){
    LinkedListShellSort myList = new LinkedListShellSort();
    Wheel myWheel = new Wheel(seed, numberOfItems);
    
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      myList.addElement(randomNumber);
    }
    
    long startTime = System.currentTimeMillis();
    myList.shellSort();
    long stopTime = System.currentTimeMillis();
    
    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method timeLinkedShell a specified number of times. The program increments the number 
   * of added elements by 5000 each time. This method averages five runs of the returned values for timeLinkedShell.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  public String runTimeLinkedShell(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 5000*i;
      long total=0;
      for(int j = 0; j<5; j++){
        long time=timeLinkedShell(numberOfItems,1627321);
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
   * @param args Argument 1 (args[0]) is the test type, either "insertArray", "insertLinked", "shellArray"
   * or "shellLinked" (no quatation marks).
   * It is important to note that responses other than "array" or "linked" in all lowercase for the first 
   * argument will not lead to desired results.
   */
  public static void main(String[] args){
    if(args[0].equals("insertArray")){
      ExperimentController testOne = new ExperimentController();
      System.out.println("insertArray test,");
      System.out.println("Number Of,Average Time(ms),");
      testOne.runTimeArrayInsertion(10);
    }
    else if(args[0].equals("insertLinked")){
      ExperimentController testOne = new ExperimentController();
      System.out.println("insertLinked test,");
      System.out.println("Number Of,Average Time(ms),");
      testOne.runTimeLinkedInsertion(10);
    }
    else if(args[0].equals("shellArray")){
      ExperimentController testOne = new ExperimentController();
      System.out.println("shellArray test,");
      System.out.println("Number Of,Average Time(ms),");
      testOne.runTimeArrayShell(10);
    }
    else if(args[0].equals("shellLinked")){
      ExperimentController testOne = new ExperimentController();
      System.out.println("shellLinked test,");
      System.out.println("Number Of,Average Time(ms),");
      testOne.runTimeLinkedShell(10);
    }
  }
}