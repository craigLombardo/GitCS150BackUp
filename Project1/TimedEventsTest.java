import junit.framework.TestCase;
import java.util.ArrayList;

public class TimedEventsTest extends TestCase{
  
  public void testWhosDone(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    
    ArrayList<Integer> times = new ArrayList<Integer>();
    
    Customer sm1 = new SmallGroup(2,4);
    Customer sm2 = new LargeGroup(6,4);
    Customer sm3 = new LargeGroup(8,4);
    Customer sm4 = new SmallGroup(3,4);
    
    test.canWeSeat(sm1);
    test.canWeSeat(sm2);
    test.canWeSeat(sm3);
    test.canWeSeat(sm4);
    
    times.add(sm1.getDepartTime());
    times.add(sm2.getDepartTime());
    times.add(sm3.getDepartTime());
    times.add(sm4.getDepartTime());
    
    ArrayList<Customer> answer = test.getSeatedList();
    
    for(int i=0; i< times.size(); i++) test.getTimer().whosDone(times.get(i));
    
    assertTrue(answer.size()==0);
    
  }
  
  public void testIsSmallHere(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    for(int i=0; i< 100; i++){
      test.getTimer().isSmallHere(i);
    }
    assertTrue(test.getSeatedList().get(0)!=null);
  }
  
    public void testIsLargeHere(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    for(int i=0; i< 100; i++){
      test.getTimer().isLargeHere(i);
    }
    assertTrue(test.getSeatedList().get(0)!=null);
  } 
  
}