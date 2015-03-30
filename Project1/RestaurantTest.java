import junit.framework.TestCase;
import java.util.ArrayList;

public class RestaurantTest extends TestCase {
  
  public void testTableRemoveSeatedGroup(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);
      
    Customer c1 = new SmallGroup(1,5);
    Customer c2 = new SmallGroup(1,6);
    Customer c3 = new SmallGroup(1,7);
    Customer c4 = new SmallGroup(1,8);
    
    assertTrue(test.canWeSeat(c1));
    assertTrue(test.canWeSeat(c2));
    assertTrue(test.canWeSeat(c3));
    assertTrue(test.canWeSeat(c4));
    
    Seating table = c1.getTable();
    
    test.removeSeatedGroup(c1);
    
    assertTrue(table.availableSeating.get(0)==null);
    
    for(int i=0; i< table.availableSeating.size(); i++) assertTrue(table.availableSeating.get(i)!=c1);
    
  }
  
  public void testOvalRemoveSeatedGroup(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);
    
    Customer c1 = new LargeGroup(8,5);
    Customer c2 = new LargeGroup(8,6);
    Customer c3 = new LargeGroup(8,7);
    Customer c4 = new SmallGroup(4,8);
    
    assertTrue(test.canWeSeat(c1));
    assertTrue(test.canWeSeat(c2));
    assertTrue(test.canWeSeat(c3));
    assertTrue(test.canWeSeat(c4));
    
    Seating table = c1.getTable();
    
    test.removeSeatedGroup(c1);
    
    for(int i=0; i<c1.getSize(); i++) assertTrue(table.availableSeating.get(i)==null);
    
    for(int i=0; i< table.availableSeating.size(); i++) assertTrue(table.availableSeating.get(i)!=c1);
    
  }
  
  public void testBarRemoveSeatedGroup(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);
    
    Customer c1 = new LargeGroup(8,5);
    Customer c2 = new LargeGroup(6,6);
    Customer c3 = new SmallGroup(3,7);
    Customer c4 = new SmallGroup(3,8);
    
    assertTrue(test.canWeSeat(c1));
    assertTrue(test.canWeSeat(c2));
    assertTrue(test.canWeSeat(c3));
    assertTrue(test.canWeSeat(c4));
    
    Seating table = c1.getTable();
    
    test.removeSeatedGroup(c1);
    
    for(int i=0; i<c1.getSize(); i++) assertTrue(table.availableSeating.get(i)==null);
    
    for(int i=0; i< table.availableSeating.size(); i++) assertTrue(table.availableSeating.get(i)!=c1);
    
  }
  
  public void testBoothRemoveSeatedGroup(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);
    
    Customer c1 = new SmallGroup(2,5);
    Customer c2 = new SmallGroup(2,6);
    Customer c3 = new SmallGroup(2,7);
    Customer c4 = new SmallGroup(2,8);
    
    assertTrue(test.canWeSeat(c1));
    assertTrue(test.canWeSeat(c2));
    assertTrue(test.canWeSeat(c3));
    assertTrue(test.canWeSeat(c4));
    
    Seating table = c1.getTable();
    
    test.removeSeatedGroup(c1);
    
    for(int i=0; i<c1.getSize(); i++) assertTrue(table.availableSeating.get(i)==null);
    
    for(int i=0; i< table.availableSeating.size(); i++) assertTrue(table.availableSeating.get(i)!=c1);
    
  }

  public void testWaitingOrder1(){
    Restaurant test =  new Restaurant();
    test.setCustomerHandling(1,1);
    //Fill Tables
    Customer c1 = new SmallGroup(4,1);
    Customer c2 = new SmallGroup(4,2);
    Customer c3 = new SmallGroup(4,3);
    Customer c4 = new SmallGroup(4,4);
    Customer c5 = new SmallGroup(4,5);
    
    //Fill Booths
    Customer c6 = new LargeGroup(8,6);
    Customer c7 = new LargeGroup(8,7);
    Customer c8 = new LargeGroup(8,8);
    Customer c9 = new LargeGroup(8,9);
    Customer c10 = new LargeGroup(8,10);
    
    //Fill Oval
    Customer c11 = new LargeGroup(8,11);
    Customer c12 = new LargeGroup(8,12);
    Customer c13 = new LargeGroup(8,13);
    Customer c14 = new LargeGroup(6,14);

    //Fill Bar
    Customer c15 = new LargeGroup(8,15);
    Customer c16 = new LargeGroup(8,16);
    Customer c17 = new SmallGroup(4,17);
    
    test.canWeSeat(c1);
    test.canWeSeat(c2);
    test.canWeSeat(c3);
    test.canWeSeat(c4);
    test.canWeSeat(c5);
    test.canWeSeat(c6);
    test.canWeSeat(c7);
    test.canWeSeat(c8);
    test.canWeSeat(c9);
    test.canWeSeat(c10);
    test.canWeSeat(c11);
    test.canWeSeat(c12);
    test.canWeSeat(c13);
    test.canWeSeat(c14);
    test.canWeSeat(c15);
    test.canWeSeat(c16);
    test.canWeSeat(c17);
    
    assertTrue(test.getWaitingList().size()==0);
    
    Customer waiter = new SmallGroup(3,9);
    test.canWeSeat(waiter);

    assertTrue(test.getWaitingList().size()==1);
    
    test.waitingOrder1();
    
    test.removeSeatedGroup(c17);
    
    test.waitingOrder1();
  }
  
    public void testWaitingOrder2(){
    Restaurant test =  new Restaurant();
    test.setCustomerHandling(1,2);
    //Fill Tables
    Customer c1 = new SmallGroup(4,1);
    Customer c2 = new SmallGroup(4,2);
    Customer c3 = new SmallGroup(4,3);
    Customer c4 = new SmallGroup(4,4);
    Customer c5 = new SmallGroup(4,5);
    
    //Fill Booths
    Customer c6 = new LargeGroup(8,6);
    Customer c7 = new LargeGroup(8,7);
    Customer c8 = new LargeGroup(8,8);
    Customer c9 = new LargeGroup(8,9);
    Customer c10 = new LargeGroup(8,10);
    
    //Fill Oval
    Customer c11 = new LargeGroup(8,11);
    Customer c12 = new LargeGroup(8,12);
    Customer c13 = new LargeGroup(8,13);
    Customer c14 = new LargeGroup(6,14);

    //Fill Bar
    Customer c15 = new LargeGroup(8,15);
    Customer c16 = new LargeGroup(8,16);
    Customer c17 = new SmallGroup(4,17);
    
    test.canWeSeat(c1);
    test.canWeSeat(c2);
    test.canWeSeat(c3);
    test.canWeSeat(c4);
    test.canWeSeat(c5);
    test.canWeSeat(c6);
    test.canWeSeat(c7);
    test.canWeSeat(c8);
    test.canWeSeat(c9);
    test.canWeSeat(c10);
    test.canWeSeat(c11);
    test.canWeSeat(c12);
    test.canWeSeat(c13);
    test.canWeSeat(c14);
    test.canWeSeat(c15);
    test.canWeSeat(c16);
    test.canWeSeat(c17);
    
    assertTrue(test.getWaitingList().size()==0);
    
    Customer waiter = new SmallGroup(3,9);
    test.canWeSeat(waiter);

    assertTrue(test.getWaitingList().size()==1);
    
    test.waitingOrder1();
    
    test.removeSeatedGroup(c17);
    
    test.waitingOrder2();
  }
  
   public void testAddToWaitingList(){
   Restaurant test = new Restaurant();
   test.setCustomerHandling(1,1);
   
   Customer waiter1 = new SmallGroup(3,4);
   Customer waiter2 = new LargeGroup(7,7);
   
     test.addToWaitingList(waiter1);
     test.addToWaitingList(waiter2);
     
     ArrayList<Customer> testWaitList = test.getWaitingList();
     assertTrue(testWaitList.size()==2);
     
     assertTrue(testWaitList.get(0)==waiter1);
     assertTrue(testWaitList.get(1)==waiter2);
   }
  
   public void testTryToSitNextWaitingCustomer(){
     Restaurant test = new Restaurant();
     test.setCustomerHandling(1,1);
   
     Customer waiter1 = new SmallGroup(3,4);
     test.addToWaitingList(waiter1);
     ArrayList<Customer> testWaitList = test.getWaitingList();
     
     test.tryToSitNextWaitingCustomer();
     
     testWaitList = test.getWaitingList();
     assertTrue(testWaitList.size()==0);
   }
   
   public void testCanWeSeat(){
   Restaurant test =  new Restaurant();
   test.setCustomerHandling(1,1);
    //Fill Tables
    Customer c1 = new SmallGroup(4,1);
    Customer c2 = new SmallGroup(4,2);
    Customer c3 = new SmallGroup(4,3);
    Customer c4 = new SmallGroup(4,4);
    Customer c5 = new SmallGroup(4,5);
    
    //Fill Booths
    Customer c6 = new LargeGroup(8,6);
    Customer c7 = new LargeGroup(8,7);
    Customer c8 = new LargeGroup(8,8);
    Customer c9 = new LargeGroup(8,9);
    Customer c10 = new LargeGroup(8,10);
    
    //Fill Oval
    Customer c11 = new LargeGroup(8,11);
    Customer c12 = new LargeGroup(8,12);
    Customer c13 = new LargeGroup(8,13);
    Customer c14 = new LargeGroup(6,14);

    //Fill Bar
    Customer c15 = new LargeGroup(8,15);
    Customer c16 = new LargeGroup(8,16);
    Customer c17 = new SmallGroup(4,17);
    
    assertTrue(test.canWeSeat(c1));
    assertTrue(test.canWeSeat(c2));
    assertTrue(test.canWeSeat(c3));
    assertTrue(test.canWeSeat(c4));
    assertTrue(test.canWeSeat(c5));
    assertTrue(test.canWeSeat(c6));
    assertTrue(test.canWeSeat(c7));
    assertTrue(test.canWeSeat(c8));
    assertTrue(test.canWeSeat(c9));
    assertTrue(test.canWeSeat(c10));
    assertTrue(test.canWeSeat(c11));
    assertTrue(test.canWeSeat(c12));
    assertTrue(test.canWeSeat(c13));
    assertTrue(test.canWeSeat(c14));
    assertTrue(test.canWeSeat(c15));
    assertTrue(test.canWeSeat(c16));
    assertTrue(test.canWeSeat(c17));
    
    Customer waiter = new SmallGroup(3,9);
    assertFalse(test.canWeSeat(waiter));
   }
   
   public void testOpenRestaurant(){
     Restaurant test =  new Restaurant();
     test.setCustomerHandling(1,1);
     test.openRestaurant(100);
     //will only be hit if there are no errors, all methods 
     //included in this method are already tested for correctness
     assertTrue(true);
   }
  
}
