import junit.framework.TestCase;

public class WheelTest extends TestCase {
  
  public void testWheelSpin(){
    Wheel testWheel = new Wheel(632817,4);
    int number;
    for(int i=0; i<30000; i++){
      number = testWheel.spin();
      assertTrue( number >=1 && number <= 4);
    }
  }
}