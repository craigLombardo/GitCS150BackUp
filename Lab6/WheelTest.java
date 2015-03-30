import junit.framework.TestCase;

public class WheelTest extends TestCase {
  
  public void testWheelSpin(){
    Wheel testWheel = new Wheel(45968,51263);
    int number;
    for(int i=0; i<300; i++){
      number = testWheel.spin();
      assertTrue( number >=1 && number <= 51263);
    }
  }
}