import junit.framework.TestCase;

public class EntryTest extends TestCase{
  
  public void testGetKey(){
    Wheel testWheel = new Wheel(361823,619162538);
    for(int i=0; i< 10; i++){
      int number = testWheel.spin();
      Entry testEntry = new Entry(number,testWheel.spin());
      assertTrue(testEntry.getKey()==number);
    }
    Entry testEntry = new Entry(0,98);
      assertTrue(testEntry.getKey()==0);
  }
  
}