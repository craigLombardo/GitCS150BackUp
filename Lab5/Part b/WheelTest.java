import junit.framework.TestCase;

public class WheelTest extends TestCase {
  
  public void testWheelSpin(){
    Wheel testWheel = new Wheel(632817,172938);
    int number;
    for(int i=0; i<300; i++){
      number = testWheel.spin();
      assertTrue( number >=1 && number <= 172938);
    }
  }
}