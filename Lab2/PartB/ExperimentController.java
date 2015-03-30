//seed one = 168237
//seed two = 157

import java.util.*;
public class ExperimentController{
  
  public long timeAddFromFront(int numberOfItems, int seed){
    RandomIntContainer myRandCont = new RandomIntContainer(numberOfItems);
    Wheel myWheel = new Wheel(seed, 100);
    long startTime = System.currentTimeMillis();
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      myRandCont.addFromFront(randomNumber);
    }
    long stopTime = System.currentTimeMillis();
    return (stopTime - startTime);
  }
  
  public String runFrontTest(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 3000+(2500*i);
      long total=0;
      for(int j = 0; j<10; j++){
        long time=timeAddFromFront(numberOfItems,157);
        total+=time;
      }
      finalString= finalString + numberOfItems+","+ (total/10)+",";
      if(i!=number) finalString = finalString +"\n";
      System.out.println(numberOfItems+","+ (total/10)+",");
    }
    return finalString;
  }
  
  public long timeAddFromEnd(int numberOfItems, int seed){
    RandomIntContainer myRandCont = new RandomIntContainer(numberOfItems);
    Wheel myWheel = new Wheel(seed, 100);
    long startTime = System.currentTimeMillis();
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      myRandCont.addFromEnd(randomNumber);
    }
    long stopTime = System.currentTimeMillis();
    return (stopTime - startTime);
  }
  
  public String runEndTest(int number){
    String finalString= "";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 1000000*i;
      long total = 0;
      for(int j = 0; j<10; j++){
        long time=timeAddFromEnd(numberOfItems,157);
        total+=time;
      }
      finalString= finalString + numberOfItems+","+ (total/10)+",";
      if(i!=number) finalString = finalString +"\n";
      System.out.println(numberOfItems+ "," +(total/10)+",");
    }
    return finalString;
  }
  
  public long timeAddSorted(int numberOfItems, int seed){
    RandomIntContainer myRandCont = new RandomIntContainer(numberOfItems);
    Wheel myWheel = new Wheel(seed, 100);
    long startTime = System.currentTimeMillis();
    for(int i=0; i< numberOfItems; i++){
      int randomNumber = myWheel.spin();
      myRandCont.addSorted(randomNumber);
    }
    long stopTime = System.currentTimeMillis();
    return (stopTime - startTime);
  }
  
  public String runSortedTest(int number){
    String finalString="";
    for(int i = 1; i<number+1; i++){
      int numberOfItems = 1000+(1000*i);
      long total=0;
      for(int j = 0; j<10; j++){
        long time = timeAddSorted(numberOfItems,157);
        total+=time;
      }
      finalString= finalString + numberOfItems+","+ (total/10)+",";
      if(i!=number) finalString = finalString +"\n";
      System.out.println(numberOfItems+ "," +(total/10)+",");
    }
    return finalString;
  }
  
  public static void main(String[] args){
    if(args[0].equals("front")){
      ExperimentController testOne = new ExperimentController();
      System.out.println("timeAddFromFront test,");
      System.out.println("Number Of,Average Time(ms),");
      testOne.runFrontTest(Integer.parseInt(args[1]));
    }
    else if(args[0].equals("end")){
      ExperimentController testTwo = new ExperimentController();
      System.out.println("timeAddFromEnd test,");
      System.out.println("Number Of,Time(ms),");
      testTwo.runEndTest(Integer.parseInt(args[1]));
    }
    else if(args[0].equals("sort")){
      ExperimentController testThree = new ExperimentController();
      System.out.println("timeAddSorted test,");
      System.out.println("Number Of,Time(ms),");
      testThree.runSortedTest(Integer.parseInt(args[1]));
    }
    else System.out.println("\""+args[0]+"\"");
  }
}
  