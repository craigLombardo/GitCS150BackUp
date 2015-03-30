import java.util.*;

/**
 * This class serves as the test environment. Through this class all other classes will be called, they will run,
 * and  then data such as run time will be printed. Through use of this class the user may also specify the number of
 * iterations and how large the array will be.
 * @author Craig Lombardo
 */
public class ListExperimentController{
  
  /**
   * This method will be used to return the total amount of time taken for the computer to add a certain number
   * of elements to the front of an ArrayListIntContainer.
   * @param numberOfItems This is an integer value of how many items will be added to the front of the array.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken, in ms, to add the specified
   * number of elements to the ArrayList.
   */
  public long arrayTimeAddFromFront(int numberOfItems, int seed){
    ArrayListIntContainer arrayCont = new ArrayListIntContainer();
    Wheel myWheel = new Wheel(seed, 100);
    
    long startTime = System.currentTimeMillis();
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      arrayCont.addFromFront(randomNumber);
    }
    long stopTime = System.currentTimeMillis();
    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method arrayTimeAddFromFront a specified number of times. The program starts at 5500 elements,
   * and increases by 2500 each time. This method averages ten runs of the returned values for arrayTimeAddFromFront.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  public String runArrayFrontTest(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 3000+(2500*i);
      long total=0;
      for(int j = 0; j<10; j++){
        long time=arrayTimeAddFromFront(numberOfItems,157);
        total+=time;
      }
      finalString= finalString + numberOfItems+","+ (total/10)+",";
      if(i!=number) finalString = finalString +"\n";
      System.out.println(numberOfItems+","+ (total/10)+",");
    }
    return finalString;
  }
  
  /**
   * This method will be used to return the total amount of time taken for the computer to add a certain number
   * of sorted elements to an ArrayListIntContainer.
   * @param numberOfItems This is an integer value of how many items will be added to the array.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken, in ms, to add the specified
   * number of elements to the ArrayList.
   */
  public long arrayTimeAddSorted(int numberOfItems, int seed){
    ArrayListIntContainer arrayCont = new ArrayListIntContainer();
    Wheel myWheel = new Wheel(seed, 100);
    
    long startTime = System.currentTimeMillis();
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      arrayCont.addSorted(randomNumber);
    }
    long stopTime = System.currentTimeMillis();
    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method arrayTimeAddSorted a specified number of times. The program starts at 5500 elements,
   * and increases by 2500 each time. This method averages ten runs of the returned values for arrayTimeAddSorted.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  public String runArraySortedTest(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 3000+(2500*i);
      long total=0;
      for(int j = 0; j<10; j++){
        long time=arrayTimeAddSorted(numberOfItems,157);
        total+=time;
      }
      finalString= finalString + numberOfItems+","+ (total/10)+",";
      if(i!=number) finalString = finalString +"\n";
      System.out.println(numberOfItems+","+ (total/10)+",");
    }
    return finalString;
  }
  
  /**
   * This method will be used to return the total amount of time taken for the computer to add a certain number
   * of elements to the front of a LinkedListIntContainer.
   * @param numberOfItems This is an integer value of how many items will be added to the front of the array.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken, in ms, to add the specified
   * number of elements to the LinkedList.
   */
  public long linkedTimeAddFromFront(int numberOfItems, int seed){
    LinkedListIntContainer linkedCont = new LinkedListIntContainer();
    Wheel myWheel = new Wheel(seed, 100);
    
    long startTime = System.currentTimeMillis();
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      linkedCont.addFromFront(randomNumber);
    }
    long stopTime = System.currentTimeMillis();
    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method linkedTimeAddFromFront a specified number of times. The program increments at 50000 
   * elements each time. This method averages ten runs of the returned values for linkedTimeAddFromFront.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  public String runLinkedFrontTest(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = (50000*i);
      long total=0;
      for(int j = 0; j<10; j++){
        long time=linkedTimeAddFromFront(numberOfItems,157);
        total+=time;
      }
      finalString= finalString + numberOfItems+","+ (total/10)+",";
      if(i!=number) finalString = finalString +"\n";
      System.out.println(numberOfItems+","+ (total/10)+",");
    }
    return finalString;
  }

  /**
   * This method will be used to return the total amount of time taken for the computer to add a certain number
   * of sorted elements to a LinkedListIntContainer.
   * @param numberOfItems This is an integer value of how many items will be added to the array.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken, in ms, to add the specified
   * number of elements to the LinkedList.
   */
  public long linkedTimeAddSorted(int numberOfItems, int seed){
    LinkedListIntContainer linkedCont = new LinkedListIntContainer();
    Wheel myWheel = new Wheel(seed, 100);
    
    long startTime = System.currentTimeMillis();
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      linkedCont.addSorted(randomNumber);
    }
    long stopTime = System.currentTimeMillis();
    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method linkedTimeAddSorted a specified number of times. The program increments at 1000 
   * elements each time. This method averages ten runs of the returned values for linkedTimeAddSorted.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  public String runLinkedSortedTest(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = (1000*i);
      long total=0;
      for(int j = 0; j<10; j++){
        long time=linkedTimeAddSorted(numberOfItems,157);
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
   * @param args Argument 1 (args[0]) is the test type, either "frontarray", "sortedarray", "frontlinked" or 
   * "sortedlinked" in all lowercase.
   * Argument 1 (args[1]) is the number passed into the appropriate timed test. It is important
   * to note that responses other than "frontarray", "sortedarray", "frontlinked" or "sortedlinked" in all 
   * lowercase for the first argument, or a valid number for the second argument will not lead to desired results.
   */
  public static void main(String[] args){
    if(args[0].equals("frontarray")){
      ListExperimentController testOne = new ListExperimentController();
      System.out.println("arrayTimeAddFromFront test,");
      System.out.println("Number Of,Average Time(ms),");
      testOne.runArrayFrontTest(Integer.parseInt(args[1]));
    }
    else if(args[0].equals("sortedarray")){
      ListExperimentController testTwo = new ListExperimentController();
      System.out.println("arrayTimeAddSorted test,");
      System.out.println("Number Of,Average Time(ms),");
      testTwo.runArraySortedTest(Integer.parseInt(args[1]));
    }
    else if(args[0].equals("frontlinked")){
      ListExperimentController testThree = new ListExperimentController();
      System.out.println("linkedTimeAddFromFront test,");
      System.out.println("Number Of,Average Time(ms),");
      testThree.runLinkedFrontTest(Integer.parseInt(args[1]));
    }
    else if(args[0].equals("sortedlinked")){
      ListExperimentController testFour = new ListExperimentController();
      System.out.println("linkedTimeAddSorted test,");
      System.out.println("Number Of,Average Time(ms),");
      testFour.runLinkedSortedTest(Integer.parseInt(args[1]));
    }
  }
}