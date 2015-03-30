import junit.framework.TestCase;

/**
 * This class is used to test the methods within the Customer class.
 * @author Craig Lombardo
 */
public class CustomerTest extends TestCase{

  public void testGetArrivalTime(){
    Customer test = new Customer("Craig Lombardo",68912);
    assertTrue(test.getArrivalTime()==68912);
    
    test = new Customer("Craig Lombardo",0);
    assertTrue(test.getArrivalTime()==0);
    
    test = new Customer("Greg Lombardo",162803512);
    assertTrue(test.getArrivalTime()==162803512);
    
    test = new Customer("Joe Lombardo",1);
    assertTrue(test.getArrivalTime()==1);
  
  }

}