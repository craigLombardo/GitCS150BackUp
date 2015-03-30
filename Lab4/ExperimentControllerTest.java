import junit.framework.TestCase;

public class ExperimentControllerTest extends TestCase{
  
  public void testTimeInsert(){
    ExperimentController testController = new ExperimentController();
    assertTrue(testController.timeInsert(100000,1237919,100000)>=0);
  }
  
  public void testRunTimeInsert(){
    ExperimentController testController = new ExperimentController();
    int runs = 3;
    String test = testController.runTimeInsert(runs,170238);
    String[] splitTest = test.split("\n");
    assertTrue(splitTest.length==runs);
  }
   
  public void testTimeFind(){
    ExperimentController testController = new ExperimentController();
    int number = 99;
    testController.testTable = new MyHashTable(number);
    testController.testTable.insert(100,123971);
    Wheel myWheel = new Wheel(19273,number);
    for(int i=0; i< number; i++){
      int randomNumber1 = myWheel.spin();
      int randomNumber2 = myWheel.spin();
      testController.testTable.insert(randomNumber1,randomNumber2);
    }
    assertTrue(testController.timeFind(100)>=0);
  }
  
  public void testRunTimeFind(){
    ExperimentController testController = new ExperimentController();
    int runs = 3;
    String test = testController.runTimeFind(runs,170238,true);
    String[] splitTest = test.split("\n");
    assertTrue(splitTest.length==runs);  
  }
  
}