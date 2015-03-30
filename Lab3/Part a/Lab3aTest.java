import junit.framework.TestCase;
import java.util.ArrayList;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 * @author Craig Lombardo
 */
public class Lab3aTest extends TestCase{
  
  public void testAddFromFront(){
    ArrayListIntContainer testCont1 = new ArrayListIntContainer();
    LinkedListIntContainer testCont2 = new LinkedListIntContainer();
    
    ArrayList<Integer> correctArray = new ArrayList<Integer>();
    
    for(int i=0; i<100; i++){
      correctArray.add(0,i);
      testCont1.addFromFront(i);
      testCont2.addFromFront(i);
    }
    
    for(int i=0; i<100; i++){
      assertTrue(correctArray.get(i)==testCont1.data.get(i));
      assertTrue(correctArray.get(i)==testCont2.data.get(i));
    }
  }
  
  public void testAddSorted(){
    ArrayListIntContainer testCont1 = new ArrayListIntContainer();
    LinkedListIntContainer testCont2 = new LinkedListIntContainer();
    
    ArrayList<Integer> correctArray = new ArrayList<Integer>();
    
    testCont1.addSorted(11);
    testCont1.addSorted(34);
    testCont1.addSorted(19);
    testCont1.addSorted(89);
    testCont1.addSorted(7);
    testCont1.addSorted(1);
    
    testCont2.addSorted(11);
    testCont2.addSorted(34);
    testCont2.addSorted(19);
    testCont2.addSorted(89);
    testCont2.addSorted(7);
    testCont2.addSorted(1);
    
    correctArray.add(1);
    correctArray.add(7);
    correctArray.add(11);
    correctArray.add(19);
    correctArray.add(34);
    correctArray.add(89);
    
    for(int i=0; i<correctArray.size(); i++){
      assertTrue(correctArray.get(i)==testCont1.data.get(i));
      assertTrue(correctArray.get(i)==testCont2.data.get(i));
    }
  }
  
  public void testInsertionSort(){
    ArrayListIntContainer testCont1 = new ArrayListIntContainer();
    LinkedListIntContainer testCont2 = new LinkedListIntContainer();
    
    ArrayList<Integer> correctArray = new ArrayList<Integer>();
    
    testCont1.addFromFront(11);
    testCont1.addFromFront(34);
    testCont1.addFromFront(19);
    testCont1.addFromFront(89);
    testCont1.addFromFront(7);
    testCont1.addFromFront(1);
    
    testCont2.addFromFront(11);
    testCont2.addFromFront(34);
    testCont2.addFromFront(19);
    testCont2.addFromFront(89);
    testCont2.addFromFront(7);
    testCont2.addFromFront(1);
    
    testCont1.insertionSort();
    testCont2.insertionSort();
    
    correctArray.add(1);
    correctArray.add(7);
    correctArray.add(11);
    correctArray.add(19);
    correctArray.add(34);
    correctArray.add(89);
    
    for(int i=0; i<correctArray.size(); i++){
      assertTrue(correctArray.get(i)==testCont1.data.get(i));
      assertTrue(correctArray.get(i)==testCont2.data.get(i));
    }
    
  }
  
  public void testWheelSpin(){
    Wheel testWheel = new Wheel(629017,178901);
    int number;
    for(int i=0; i<300; i++){
      number = testWheel.spin();
      assertTrue( number >=1 && number <= 178901);
    }
  }
  
  public void testArrayTimeAddFromFront(){
    ListExperimentController arrayFrontTime = new ListExperimentController();
    assertTrue(arrayFrontTime.arrayTimeAddFromFront(100,127983) >= 0);
  }
  
  public void testArrayTimeAddSorted(){
    ListExperimentController arraySortedTime = new ListExperimentController();
    assertTrue(arraySortedTime.arrayTimeAddSorted(100,89) >= 0);
  }
  
  public void testLinkedTimeAddFromFront(){
    ListExperimentController linkedFrontTime = new ListExperimentController();
    assertTrue(linkedFrontTime.linkedTimeAddFromFront(100,1283) >= 0);
  }
  
  public void testLinkedTimeAddSorted(){
    ListExperimentController linkedSortedTime = new ListExperimentController();
    assertTrue(linkedSortedTime.linkedTimeAddSorted(100,812989) >= 0);
  }
  
  public void testRunArrayFrontTest(){
    ListExperimentController arrayFrontTest = new ListExperimentController();
    int runs = 10;
    String test = arrayFrontTest.runArrayFrontTest(runs);
    String[] splitTest = test.split("\n");
    assertTrue(splitTest.length==runs);
  }
  
  public void testRunArraySortedTest(){
    ListExperimentController arraySortedTest = new ListExperimentController();
    int runs = 3;
    String test = arraySortedTest.runArraySortedTest(runs);
    String[] splitTest = test.split("\n");
    assertTrue(splitTest.length==runs);
  }
  
  public void testRunLinkedFrontTest(){
    ListExperimentController linkedFrontTest = new ListExperimentController();
    int runs = 10;
    String test = linkedFrontTest.runLinkedFrontTest(runs);
    String[] splitTest = test.split("\n");
    assertTrue(splitTest.length==runs);
  }
  
  public void testRunLinkedSortedTest(){
    ListExperimentController linkedSortedTest = new ListExperimentController();
    int runs = 3;
    String test = linkedSortedTest.runLinkedSortedTest(runs);
    String[] splitTest = test.split("\n");
    assertTrue(splitTest.length==runs);
  }
}
