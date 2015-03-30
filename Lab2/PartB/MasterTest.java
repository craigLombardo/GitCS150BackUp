import java.util.*;
import java.io.*;

import junit.framework.TestCase;

public class MasterTest extends TestCase {
  
  
  public void testAddFromFront(){
    RandomIntContainer frontTest = new RandomIntContainer(10);
    for(int i = 10; i > 0; i--) frontTest.addFromFront(i);
    
    ArrayList<Integer> compareOneTenArray = new ArrayList<Integer>(10);
    for(int j = 1; j<=10; j++) compareOneTenArray.add(j);
    
    ArrayList<Integer> frontArrayList = frontTest.returnMyArrayList();
    for(int k=0; k<10; k++) assertTrue(frontArrayList.get(k)==compareOneTenArray.get(k));
    
  }
  
  public void testAddFromEnd(){
    RandomIntContainer endTest = new RandomIntContainer(10);
    for(int i = 1; i <= 10; i++) endTest.addFromEnd(i);
    
    ArrayList<Integer> compareOneTenArray = new ArrayList<Integer>(10);
    for(int j = 1; j<=10; j++) compareOneTenArray.add(j);
    
    ArrayList<Integer> endArrayList = endTest.returnMyArrayList();
    for(int k=0; k<10; k++) assertTrue(endArrayList.get(k)==compareOneTenArray.get(k));
    
  }
  
  public void testAddSorted(){
    RandomIntContainer sortedTest = new RandomIntContainer(10);
    
    sortedTest.addSorted(11);
    sortedTest.addSorted(3);
    sortedTest.addSorted(67);
    sortedTest.addSorted(2);
    sortedTest.addSorted(1);
    sortedTest.addSorted(99);
    sortedTest.addSorted(13);
    sortedTest.addSorted(2);
    sortedTest.addSorted(3);
    sortedTest.addSorted(75);
    ArrayList<Integer> testArray = sortedTest.returnMyArrayList();
    
    
    ArrayList<Integer> sortedArray = new ArrayList<Integer>(10);
    sortedArray.add(1);
    sortedArray.add(2);
    sortedArray.add(2);
    sortedArray.add(3);
    sortedArray.add(3);
    sortedArray.add(11);
    sortedArray.add(13);
    sortedArray.add(67);
    sortedArray.add(75);
    sortedArray.add(99);
    
    for(int i=0; i<10; i++) assertTrue(testArray.get(i)==sortedArray.get(i));
    
  }
  
  public void testInsertionSort(){
    RandomIntContainer sortedTest = new RandomIntContainer(10);
    
    sortedTest.addFromFront(11);
    sortedTest.addFromFront(3);
    sortedTest.addFromFront(67);
    sortedTest.addFromFront(2);
    sortedTest.addFromFront(1);
    sortedTest.addFromFront(99);
    sortedTest.addFromFront(13);
    sortedTest.addFromFront(2);
    sortedTest.addFromFront(3);
    sortedTest.addFromFront(75);

    sortedTest.insertionSort();
    ArrayList<Integer> testArray = sortedTest.returnMyArrayList();
    
    ArrayList<Integer> sortedArray = new ArrayList<Integer>(10);
    sortedArray.add(1);
    sortedArray.add(2);
    sortedArray.add(2);
    sortedArray.add(3);
    sortedArray.add(3);
    sortedArray.add(11);
    sortedArray.add(13);
    sortedArray.add(67);
    sortedArray.add(75);
    sortedArray.add(99);
    
    for(int i=0; i<10; i++) assertTrue(testArray.get(i)==sortedArray.get(i));
  }

  public void testReturnArray(){
    RandomIntContainer returnTest = new RandomIntContainer(10);
    ArrayList<Integer> match = new ArrayList<Integer>(10);
    for(int i=0; i<10; i++){
      returnTest.addFromEnd(3*i);
      match.add(3*i);
    }
    
    ArrayList<Integer> returnedList = returnTest.returnMyArrayList();
    
    for(int i=0; i<10; i++) assertTrue(returnedList.get(i)==match.get(i));
  }
  
  public void testWheelSpin(){
    int upper = 10; 
    int firstSeed = 1234, secondSeed = -274;
    
    Wheel firstWheel = new Wheel(firstSeed,upper);
    ArrayList<Integer> firstSet = new ArrayList<Integer>();
    
    Wheel secondWheel = new Wheel(firstSeed, upper);
    ArrayList<Integer> secondSet = new ArrayList<Integer>();
    
    Wheel thirdWheel = new Wheel(secondSeed, upper);
    ArrayList<Integer> thirdSet = new ArrayList<Integer>();
    
    for(int i = 0; i<100; i++){
      int numberSetOne = firstWheel.spin();
      assertTrue(numberSetOne <= upper && numberSetOne >= 1);
      firstSet.add(numberSetOne);
      
      int numberSetTwo = secondWheel.spin();
      assertTrue(numberSetTwo <= upper && numberSetTwo >= 1);
      secondSet.add(numberSetTwo);
      
      int numberSetThree = thirdWheel.spin();
      assertTrue(numberSetThree <= upper && numberSetThree >= 1);
      thirdSet.add(numberSetThree);
    }
    
    for(int i = 0; i<firstSet.size();i++) assertTrue(firstSet.get(i)==secondSet.get(i));
    
    boolean sameArrays=true;
    for(int i = 0; i<firstSet.size() && sameArrays;i++){
      if(firstSet.get(i)!=thirdSet.get(i)) sameArrays=false;
    }
    assertFalse(sameArrays);
  }

  public void testTimeAddFromFront(){
    ExperimentController frontTime = new ExperimentController();
    assertTrue(frontTime.timeAddFromFront(100,123) >= 0);
  }

  public void testTimeAddFromEnd(){
    ExperimentController endTime = new ExperimentController();
    assertTrue(endTime.timeAddFromEnd(100,123) >= 0);
  }
  
  public void testTimeAddSorted(){
    ExperimentController sortedTime = new ExperimentController();
    assertTrue(sortedTime.timeAddSorted(100,123) >= 0);
  }


  //http://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
  public void testRunFrontTest(){
    ExperimentController frontTest = new ExperimentController();
    int runs = 13;
    String test = frontTest.runFrontTest(runs);
    String[] splitTest = test.split("\n");
    assertTrue(splitTest.length==runs);
  }

  public void testRunEndTest(){
    ExperimentController endTest = new ExperimentController();
    int runs = 15;
    String test = endTest.runEndTest(runs);
    String[] splitTest = test.split("\n");
    assertTrue(splitTest.length==runs);
  }
  
  public void testRunSortedTest(){
    ExperimentController sortedTest = new ExperimentController();
    int runs = 11;
    String test = sortedTest.runSortedTest(runs);
    String[] splitTest = test.split("\n");
    assertTrue(splitTest.length==runs);
  }

}