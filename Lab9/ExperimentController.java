/**
 * This class serves as the test environment. Through use of this class the user may test
 * the Java API TreeMap. The user may also specify the number of iterations and how large the map will be.
 * @author Craig Lombardo
 */
public class ExperimentController{
  
  /**
   * This method will be used to return the total amount of time taken for the computer to add
   * a number of elements to the tree.
   * @param numberOfItems This is an integer value of how many items will be added to the tree.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken,in ms, to add 
   * all of the elements.
   */
  public long timeAddTreeSet(int numberOfItems, int seed){
    TreeSetContainer<Integer,Integer> myCont = new TreeSetContainer<Integer,Integer>();
    Wheel myWheel = new Wheel(seed, numberOfItems);
    long totalTime = 0;
    for(int i=0; i< numberOfItems; i++){
      int randomNumber1 = myWheel.spin();
      int randomNumber2 = myWheel.spin();
      long startTime = System.currentTimeMillis();
      myCont.add(randomNumber1,randomNumber2);
      long stopTime = System.currentTimeMillis();
      totalTime = totalTime + (stopTime - startTime);
    }
    return totalTime;
  }
  
  /**
   * This method runs the method timeAddTreeSet a specified number of times. The program increments the number 
   * of added elements by 1000000 each time. This method averages five runs of the returned values for timeAddTreeSet.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  public String runTimeAddTreeSet(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 1000000*i;
      long total=0;
      for(int j = 0; j<5; j++){
        long time=timeAddTreeSet(numberOfItems,112332457);
        total+=time;
      }
      finalString= finalString + numberOfItems+","+ (total/10)+",";
      if(i!=number) finalString = finalString +"\n";
      System.out.println(numberOfItems+","+ (total/10)+",");
    }
    return finalString;
  }
 
  /**
   * This method will be used to return the total amount of time taken for the computer to find an element in the TreeMap.
   * @param numberOfItems This is an integer value of how many items will be added to Tree the search is conducted.
   * @param seed An integer value used to generate pseudorandom numbers.
   * @return long This method returns a long which corresponds to the time taken,in ns, to find an element in the Tree.
   */
  public long timeFindTreeSet(int numberOfItems, int seed){
    TreeSetContainer<Integer,Integer> myCont = new TreeSetContainer<Integer,Integer>();
    Wheel myWheel = new Wheel(seed, numberOfItems);
    for(int i=0; i< numberOfItems; i++){
      int randomNumber1 = myWheel.spin();
      int randomNumber2 = myWheel.spin();
      myCont.add(randomNumber1,randomNumber2);
    }
    int randomNumber3 = myWheel.spin();
    long startTime = System.nanoTime();
    myCont.contains(randomNumber3);
    long stopTime = System.nanoTime();
    return (stopTime - startTime);
  }
  
  /**
   * This method runs the method myTimeFindSecond a specified number of times. The program increments the number 
   * of added elements by 1000000 each time. This method averages five runs of the returned values for timeFindTreeSet.
   * @param number The number of trials to run.
   * @return String The average run times of the tests, put in a format that is beneficial for use with .csv files.
   */
  public String runTimeFindTreeSet(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 1000000*i;
      long total=0;
      for(int j = 0; j<5; j++){
        long time=timeFindTreeSet(numberOfItems,112332457);
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
   * @param args Argument 1 (args[0]) is the test type, either "addTree" or "findTree".
   * Argument 1 (args[1]) is the number passed into the appropriate run second test. It is important
   * to note that responses other than "addTree" or "findTree", or a valid number for the second 
   * argument will not lead to desired results.
   */
  public static void main(String[] args){
      if(args[0].equals("addTree")){
        ExperimentController testOne = new ExperimentController();
        System.out.println("timeAddTreeSet test,");
        System.out.println("Number Of,Average Time(ms),");
        testOne.runTimeAddTreeSet(Integer.parseInt(args[1]));
      }
      else if(args[0].equals("findTree")){
        ExperimentController testOne = new ExperimentController();
        System.out.println("timeFindTreeSet test,");
        System.out.println("Number Of,Average Time(ns),");
        testOne.runTimeFindTreeSet(Integer.parseInt(args[1]));
      }
  }
}