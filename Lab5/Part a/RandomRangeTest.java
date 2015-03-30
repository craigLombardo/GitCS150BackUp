import junit.framework.TestCase;

/**
 * This class tests the RandomRange class to ensure that it produces nunmbers between the range 1-10 (inclusive).
 * @author Craig Lombardo
 */
  public class RandomRangeTest extends TestCase{
  
    public void testGetRandomTime(){
      //arrival
      RandomRange test1 =  new RandomRange(1,10);
      for(int i = 0; i<1000; i++){
        int number = test1.getRandomTime();
        assertTrue(number >= 1 && number <= 10);
      }
      //departure
      RandomRange test2 =  new RandomRange(5,15);
      for(int i = 0; i<1000; i++){
        int number = test2.getRandomTime();
        assertTrue(number >= 5 && number <= 15);
      }
    }

} 