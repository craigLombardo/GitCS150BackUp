import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * This class tests the various methods contained within the LineQueue class to ensure they function properly.
 * @author Craig Lombardo
 */
public class LineQueueTest extends TestCase{
  
  public void testPeek(){
    LineQueue<Customer> test = new LineQueue<Customer>();
    test.offer(new Customer("Craig",898));
    assertTrue(test.peek().getArrivalTime()==898);
    test.offer(new Customer("Greg",5372));
    assertTrue(test.peek().getArrivalTime()==898);
    test.offer(new Customer("Gabby",1));
    assertTrue(test.peek().getArrivalTime()==898);
    test.offer(new Customer("Austin",0));
    assertTrue(test.peek().getArrivalTime()==898);
    test.offer(new Customer("Kyle",6732));
    assertTrue(test.peek().getArrivalTime()==898);
    
  }
  
  public void testPoll(){
    LineQueue<Customer> test = new LineQueue<Customer>();
    
    assertTrue(test.poll()==null);
    
    test.offer(new Customer("Craig",898));
    test.offer(new Customer("Greg",5372));
    test.offer(new Customer("Gabby",1));
    test.offer(new Customer("Austin",0));
    test.offer(new Customer("Kyle",6732));
    
    ArrayList<Integer> times = new ArrayList<Integer>(5);
    times.add(898);
    times.add(5372);
    times.add(1);
    times.add(0);
    times.add(6732);
    
    for(int i = 0; i< 5; i++) assertTrue(test.poll().getArrivalTime() == times.get(i));
    
    assertTrue(test.poll()==null);
  }
  
  
  public void testRemove(){
    LineQueue<Customer> test = new LineQueue<Customer>();
    
    try{
      test.remove();
    }
    catch(NoSuchElementException e){
      assertTrue(true);
    }
    
    test.offer(new Customer("Craig",898));
    test.offer(new Customer("Greg",5372));
    test.offer(new Customer("Gabby",1));
    test.offer(new Customer("Austin",0));
    test.offer(new Customer("Kyle",6732));
    
    ArrayList<Integer> times = new ArrayList<Integer>(5);
    times.add(898);
    times.add(5372);
    times.add(1);
    times.add(0);
    times.add(6732);
    
    for(int i = 0; i< 5; i++) assertTrue(test.remove().getArrivalTime() == times.get(i));
    
    try{
      test.remove();
    }
    catch(NoSuchElementException e){
      assertTrue(true);
    }
    
  }
  
  
  public void testSize(){
    LineQueue<Customer> test = new LineQueue<Customer>();
    
    assertTrue(test.size()==0);
    
    test.offer(new Customer("Craig",898));
    test.offer(new Customer("Greg",5372));
    test.offer(new Customer("Gabby",1));
    test.offer(new Customer("Austin",0));
    test.offer(new Customer("Kyle",6732));
    
    ArrayList<Integer> times = new ArrayList<Integer>(5);
    times.add(898);
    times.add(5372);
    times.add(1);
    times.add(0);
    times.add(6732);
    
    assertTrue(test.size()==5);
    
    test.remove();
    assertTrue(test.size()==4);
  }
  
  public void testIterator(){
    LineQueue<Customer> test = new LineQueue<Customer>();
    
    test.offer(new Customer("Craig",898));
    test.offer(new Customer("Greg",5372));
    test.offer(new Customer("Gabby",1));
    test.offer(new Customer("Austin",0));
    test.offer(new Customer("Kyle",6732));
    
    Iterator<Customer> iter = test.iterator();
    
    String finalStr="";
    
    while(iter.hasNext()){
      finalStr = finalStr + iter.next().getArrivalTime()+",";
    }
    
    assertTrue(finalStr.equals("898,5372,1,0,6732,"));
  }
  
  public void testOffer(){
    LineQueue<Customer> test = new LineQueue<Customer>();
    ArrayList<Customer> goodArr = new ArrayList<Customer>(5);
    
    test.offer(new Customer("Craig",898));
    test.offer(new Customer("Greg",5372));
    test.offer(new Customer("Gabby",1));
    test.offer(new Customer("Austin",0));
    test.offer(new Customer("Kyle",6732));
    
    Iterator<Customer> iter = test.iterator();
        
    goodArr.add(new Customer("Craig",898));
    goodArr.add(new Customer("Greg",5372));
    goodArr.add(new Customer("Gabby",1));
    goodArr.add(new Customer("Austin",0));
    goodArr.add(new Customer("Kyle",6732));
    
    int i=0;
    
    while(iter.hasNext()){
    Customer tmp = (Customer) iter.next();
      assertTrue(tmp.getArrivalTime()==goodArr.get(i).getArrivalTime());
      i++;
    }
  }
  
}