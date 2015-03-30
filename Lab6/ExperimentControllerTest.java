import junit.framework.TestCase;

public class ExperimentControllerTest extends TestCase{
  
  public void testTimeArrayInsertion(){
    ExperimentController test = new ExperimentController();
    assertTrue(test.timeArrayInsertion(1000,612379)>0);
  }
  
  public void testTimeLinkedInsertion(){
    ExperimentController test = new ExperimentController();
    assertTrue(test.timeLinkedInsertion(1000,612379)>0);
  }
  
  public void testTimeLinkedShell(){
    ExperimentController test = new ExperimentController();
    assertTrue(test.timeLinkedShell(1000,612379)>0);
  }
  
  public void testTimeArrayShell(){
    ExperimentController test = new ExperimentController();
    assertTrue(test.timeArrayShell(1000,612379)>0);
  }
  
  public void testRunTimeArrayInsertion(){
    ExperimentController test = new ExperimentController();
    String answer = "";
    answer = test.runTimeArrayInsertion(1);
    assertTrue(answer!="");
  }
  
  public void testRunTimeArrayShell(){
    ExperimentController test = new ExperimentController();
    String answer = "";
    answer = test.runTimeArrayShell(1);
    assertTrue(answer!="");
  }
  public void testRunTimeLinkedInsertion(){
    ExperimentController test = new ExperimentController();
    String answer = "";
    answer = test.runTimeLinkedInsertion(1);
    assertTrue(answer!="");
  }
  public void testRunTimeLinkedShell(){
    ExperimentController test = new ExperimentController();
    String answer = "";
    answer = test.runTimeLinkedShell(1);
    assertTrue(answer!="");
  }
  
}