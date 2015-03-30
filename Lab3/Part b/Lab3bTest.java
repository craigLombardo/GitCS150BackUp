import junit.framework.TestCase;
import java.util.ArrayList;

public class Lab3bTest extends TestCase {
  
  public void testWheelSpin(){
    Wheel testWheel = new Wheel(632817,172938);
    int number;
    for(int i=0; i<300; i++){
      number = testWheel.spin();
      assertTrue( number >=1 && number <= 172938);
    }
  }
  
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
  
  public void testFindSecondLargest(){
    ArrayListIntContainer testCont1 = new ArrayListIntContainer();
    LinkedListIntContainer testCont2 = new LinkedListIntContainer();
    Wheel randomNums = new Wheel(1234321,100);
    
    testCont1.addFromFront(101);
    testCont2.addFromFront(104);
    
    int number;
    
    for(int i=0; i<100; i++){
      number = randomNums.spin();
      testCont1.addFromFront(number);
      testCont2.addFromFront(number);
    }
    
    testCont1.addFromFront(198);
    testCont2.addFromFront(167);
    
    assertTrue(testCont1.findSecondLargest() == 101);
    assertTrue(testCont2.findSecondLargest() == 104);
  }
  
  
  public void testArrayTimeFindSecond(){
    ListExperimentController arraySecondTime = new ListExperimentController();
    assertTrue(arraySecondTime.arrayTimeFindSecond(100,8189) >= 0);
  }
  
  public void testRunArrayFindSecond(){
    ListExperimentController arraySecondTest = new ListExperimentController();
    int runs = 5;
    String test = arraySecondTest.runArrayFindSecond(runs);
    String[] splitTest = test.split("\n");
    assertTrue(splitTest.length==runs);
  }
  
    public void testLinkedTimeFindSecond(){
    ListExperimentController linkedSecondTime = new ListExperimentController();
    assertTrue(linkedSecondTime.linkedTimeFindSecond(100,8189) >= 0);
  }
  
  public void testRunLinkedFindSecond(){
    ListExperimentController linkedSecondTest = new ListExperimentController();
    int runs = 5;
    String test = linkedSecondTest.runLinkedFindSecond(runs);
    String[] splitTest = test.split("\n");
    assertTrue(splitTest.length==runs);
  }
  
}
