import junit.framework.TestCase;

public class ExperimentControllerTest extends TestCase{
  
  public void testMyTimeFindSecond(){
    MyListIntContainer myCont = new MyListIntContainer();
    Wheel myWheel = new Wheel(168237, 500);
    
    for(int i=0; i< 500; i++){
      int randomNumber = myWheel.spin();
      myCont.addToFront(randomNumber);
    }
    
    long startTime = System.currentTimeMillis();
    myCont.findSecondLargest();
    long stopTime = System.currentTimeMillis();

    assertTrue((stopTime - startTime)>0);
  }
  
  public void testRunMyFindSecond(){
    ExperimentController test = new ExperimentController();
    String answer = "";
    answer = test.runMyFindSecond(1);
    assertTrue(answer!="");
  }
  
  public void testLinkedTimeFindSecond(){
    LinkedListIntContainer linkedCont = new LinkedListIntContainer();
    Wheel myWheel = new Wheel(5196231, 500);
    
    for(int i=0; i< 500; i++){
      int randomNumber = myWheel.spin();
      linkedCont.addToFront(randomNumber);
    }
    
    long startTime = System.currentTimeMillis();
    linkedCont.findSecondLargest();
    long stopTime = System.currentTimeMillis();
    assertTrue((stopTime - startTime)>0);
  }

  public void testRunLinkedFindSecond(){
    ExperimentController test = new ExperimentController();
    String answer = "";
    answer = test.runMyFindSecond(1);
    assertTrue(answer!="");
  }

}