/**
 * This class is used to get experimental data of the class MyHashTable.
 * @author Craig Lombardo
 */
public class ExperimentController{
  
  MyHashTable testTable;
  /**
   * This method returns the time taken to insert a certain number of elements into a hash table.
   * @param numberOfItems The number of items to be passed into the hash table.
   * @param seed The seed used for pseudorandom number generation.
   * @param hashTableSize The size of the hash table that we will be adding to.
   * @return long The time in ns taken to complete this operation.
   */
  public long timeInsert(int numberOfItems, int seed, int hashTableSize){
    testTable = new MyHashTable(hashTableSize);
    Wheel myWheel = new Wheel(seed, hashTableSize*2);
    
    long startTime = System.nanoTime();
    
    for(int i=0; i< numberOfItems; i++){
      int randomNumber1 = myWheel.spin();
      int randomNumber2 = myWheel.spin();
      testTable.insert(randomNumber1,randomNumber2);
    }
    long stopTime = System.nanoTime();
    return (stopTime - startTime);
  }
    /**
   * This method returns a String containing all times taken to insert a certain number of elements into a hash table.
   * @param numberOfTimes The number of times we should increment the number of items added to the hash table. Each increment
   * has a step size of 1000000.
   * @param seed The seed used for pseudorandom number generation.
   * @return String A String containing all times in ns taken to complete this operation. Put in a form conducive to .csv files.
   */
  public String runTimeInsert(int numberOfTimes, int seed){
    System.out.println(",200.0,100.0,66.67,50.0,40.0,");
    String finalString=",200.0,100.0,66.67,50.0,40.0,";
    for(int i = 1; i<numberOfTimes+1; i++){
      int numberOfItems = 1000000*i;
      System.out.print(numberOfItems+",");
      finalString= finalString + numberOfItems +",";
      long total=0;
      for(int k=1; k<=5; k++){
        total=0;
        int hashSize = k*numberOfItems/2;
        for(int j = 0; j<10; j++){
          long time=timeInsert(numberOfItems,seed,hashSize);
          total+=time;
        }
        finalString = finalString + (total/10) + ",";
        System.out.print((total/10)+",");
      }
      System.out.println();
      if(i!=numberOfTimes) finalString = finalString +"\n";
    }
    return finalString;
  }
  
    /**
   * This method returns the time taken to find a certain key from a hash table.
   * @param key The key we are searching for
   * @return long The time in ns taken to complete this operation.
   */
  public long timeFind(int key){
    long startTime = System.nanoTime();
    testTable.find(key);
    long stopTime = System.nanoTime();
    return (stopTime - startTime);
  }
  
  /**
   * This method returns a String corresponding to the time taken to find a certain key in a hash table.
   * @param numberOfTimes The number of times we should increment the number of items added to the hash table. Each increment
   * has a step size of 1000000.
   * @param seed The seed used for pseudorandom number generation.
   * @param valid A boolean representing whether we want a valid number or not. If true then we insert a unique key, and then we 
   * insert the number of elements -1, and then search for the valid, unique, key. If false then we add positive numbers and search
   * for a negative number. 
   * @return String The times taken in ns to complete this operation, in a format conducive to .csv files.
   */
  public String runTimeFind(int numberOfTimes, int seed, boolean valid){
    int keyToFind= valid ? 0 : -1;
    System.out.println(",200.0,100.0,66.67,50.0,40.0,");
    String finalString=",200.0,100.0,66.67,50.0,40.0,";
    
    for(int i = 1; i<numberOfTimes+1; i++){
      int numberOfItems = valid ? 1000000*i-1 : 1000000*i;
      System.out.print(numberOfItems+",");
      finalString= finalString + numberOfItems +",";
      for(int k=1; k<=5; k++){
        long total=0;
        int hashSize = k*numberOfItems/2;
        Wheel random = new Wheel(seed, hashSize*2);
        testTable = new MyHashTable(hashSize);
        if(valid) testTable.insert(keyToFind,98);
        for(int l=0; l<numberOfItems; l++){
          int randomNumber1 = random.spin();
          int randomNumber2 = random.spin();
          testTable.insert(randomNumber1,randomNumber2);
        }
        long time=timeFind(keyToFind);
        finalString= finalString + (total/10) + ",";
        System.out.print((time)+",");
      }
      System.out.println();
      if(i!=numberOfTimes) finalString = finalString +"\n";
    }
    return finalString;
  }
  
  /**
   * This method returns a String which shows the max number of elements at an index in the hash table (takes the max or all indexes).
   * @param numberOfTimes The number of times we should increment the number of items added to the hash table. Each increment
   * has a step size of 1000000.
   * @param seed The seed used for pseudorandom number generation.
   * @return String The max number of elements at an index in the hash table, in a format conducive to .csv files.
   */
  
  public String runFindMax(int numberOfTimes, int seed){
    System.out.println(",200.0,100.0,66.67,50.0,40.0,");
    String finalString=",200.0,100.0,66.67,50.0,40.0,";
    
    for(int i = 1; i<numberOfTimes+1; i++){
      int numberOfItems = 1000000*i;
      System.out.print(numberOfItems+",");
      finalString= finalString + numberOfItems +",";
      for(int k=1; k<=5; k++){
        int hashSize = k*numberOfItems/2;
        Wheel random = new Wheel(seed, hashSize*2);
        testTable = new MyHashTable(hashSize);
        for(int l=0; l<numberOfItems; l++){
          int randomNumber1 = random.spin();
          int randomNumber2 = random.spin();
          testTable.insert(randomNumber1,randomNumber2);
        }
        int max=testTable.returnMaxNumInLL();
        finalString= finalString + (max) + ",";
        System.out.print((max)+",");
      }
      System.out.println();
      if(i!=numberOfTimes) finalString = finalString +"\n";
    }
    return finalString;
  }
  
  public static void main(String[] args){
    if(args[0].equals("insert")){
      ExperimentController test = new ExperimentController();
      test.runTimeInsert(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }
    else if(args[0].equals("find")){
      ExperimentController test = new ExperimentController();
      boolean valid = args[3] == "true" ? true : false;
      test.runTimeFind(Integer.parseInt(args[1]), Integer.parseInt(args[2]), valid);
    }
    else if(args[0].equals("max")){
      ExperimentController test = new ExperimentController();
      test.runFindMax(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }
    else System.out.println("fail");
  }
  
}