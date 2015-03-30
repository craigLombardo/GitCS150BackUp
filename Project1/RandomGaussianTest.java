import junit.framework.TestCase;

public final class RandomGaussianTest extends TestCase{

  public void testGetNext(){
    RandomGaussian test1 = new RandomGaussian(15,7);
    
    for(int i=0; i<1000000; i++){
      int num = test1.getNext();
      assertTrue(num>=1 && num<100);
    }
  }
}