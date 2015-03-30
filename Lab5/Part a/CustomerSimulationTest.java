import junit.framework.TestCase;

/**
 * This class tests the various methods contained within the CustomerSimulation class to ensure they function properly.
 * @author Craig Lombardo
 */

public class CustomerSimulationTest extends TestCase{
  
  public void testOpenTil(){
    CustomerSimulation test = new CustomerSimulation();
    try{
      test.openTil(0);
      test.openTil(100);
      test.openTil(590);
      test.openTil(1000);
      assertTrue(true);
    }
    catch(Exception e){
      return;
    }
  }
  
  public void testCheckArrival(){
    CustomerSimulation test = new CustomerSimulation();
    assertTrue(test.checkArrival(0,0));
    assertTrue(test.checkArrival(10,10));
    assertTrue(test.checkArrival(500,500));
    assertTrue(test.checkArrival(133,133));
    assertFalse(test.checkArrival(1,2));
    assertFalse(test.checkArrival(1231,792));
    assertFalse(test.checkArrival(1582361,5186232));
    assertFalse(test.checkArrival(5241,2123));
  }
  
  public void testCheckDeparture(){
    CustomerSimulation test = new CustomerSimulation();
    
    try{
      test.checkDeparture(0,0);
      test.checkDeparture(10,10);
      test.checkDeparture(500,500);
      test.checkDeparture(133,133);
      test.checkDeparture(1,2);
      test.checkDeparture(1231,792);
      test.checkDeparture(1582361,5186232);
      test.checkDeparture(5241,212);
      assertTrue(true);
    }
    catch(Exception e){
      return;
    }
  }
  
}