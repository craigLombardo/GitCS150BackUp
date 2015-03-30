import java.util.*;

/**
 * This class serves as the test environment. Through use of this class the user may test
 * the two types of linked lists, both MyLinkedList and the java LinkedList. The user
 * may also specify the number of iterations and how large the array will be.
 * @author Craig Lombardo
 */
public class ExperimentController{
  
  /**
   * This method will be used to return the total amount of time taken for the computer to find the second
   * largest number in MyLinkedList.
   * @param numberOfItems This is an integer value of how many items will be added to the front of the array before the search is conducted.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken,in ms, to find the second largest
   * integer in the ArrayList.
   */
  public long myTimeFindSecond(int numberOfItems, int seed){
    MyListIntContainer myCont = new MyListIntContainer();
    Wheel myWheel = new Wheel(seed, numberOfItems);
    
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      myCont.addToFront(randomNumber);
    }
    
    long startTime = System.currentTimeMillis();
    myCont.findSecondLargest();
    long stopTime = System.currentTimeMillis();

    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method myTimeFindSecond a specified number of times. The program increments the number 
   * of added elements by 50000 each time. This method averages five runs of the returned values for myTimeFindSecond.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  
  public String runMyFindSecond(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 50000*i;
      long total=0;
      for(int j = 0; j<5; j++){
        long time=myTimeFindSecond(numberOfItems,157);
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
      linkedCont.addToFront(randomNumber);
    }
    
    long startTime = System.currentTimeMillis();
    linkedCont.findSecondLargest();
    long stopTime = System.currentTimeMillis();
    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method linkedTimeFindSecond a specified number of times. The program increments the number 
   * of added elements by 50000 each time. This method averages five runs of the returned values for linkedTimeFindSecond.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  public String runLinkedFindSecond(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = (50000*i);
      long total=0;
      for(int j = 0; j<5; j++){
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
   * @param args Argument 1 (args[0]) is the test type, either "mine" or "linked" in all lowercase.
   * Argument 1 (args[1]) is the number passed into the appropriate run second test. It is important
   * to note that responses other than "array" or "linked" in all lowercase for the first argument, or
   * a valid number for the second argument will not lead to desired results.
   */
  public static void main(String[] args){
      if(args[0].equals("mine")){
        ExperimentController testOne = new ExperimentController();
        System.out.println("myTimeFindSecond test,");
        System.out.println("Number Of,Average Time(ms),");
        testOne.runMyFindSecond(Integer.parseInt(args[1]));
      }
      else if(args[0].equals("linked")){
        ExperimentController testThree = new ExperimentController();
        System.out.println("linkedTimeFindSecond test,");
        System.out.println("Number Of,Average Time(ms),");
        testThree.runLinkedFindSecond(Integer.parseInt(args[1]));
      }
  }
}