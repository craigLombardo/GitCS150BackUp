import junit.framework.TestCase;
import java.util.ArrayList;

public class BarTest extends TestCase{
  
  /**
   * This method wraps the arraylist for continuity at the bar table and small tables
   */
  public void testWrap(){
    Restaurant test = new Restaurant();
    Seating bar = new Bar(test);
    ArrayList<Customer> correctArr;
    for(int l=1; l<=8; l++){
      correctArr = new ArrayList<Customer>();
      int groupSize = l;
      for(int j=0; j< bar.availableSeating.size(); j++){
        correctArr.add(bar.availableSeating.get(j));
      }
      for(int i=0; i < groupSize - 1; i++){
        correctArr.add(bar.availableSeating.get(i));
      }
      ArrayList<Customer> testArr = bar.wrap(l);
      assertTrue(correctArr.size()==testArr.size());
    }
  }
  
  public void testCheckForSize(){
    Restaurant test = new Restaurant();
    Seating bar = new Bar(test);
    
    for(int j=0; j<bar.getNumberOfSeatsAvailable(); j++){
      assertTrue(bar.availableSeating.get(j)==null);
    }
    
    for(int j=0; j<bar.getNumberOfSeatsAvailable(); j++){
      bar.availableSeating.set(j,new SmallGroup(1,1));
    }
    bar.checkGroupAvailability(); 
    
    for(int j=0; j<8; j++){
      try{
        bar.seatingIndexes.get(j).get(0);
      }
      catch(Exception e){
        assertTrue(true);
      }
    }
  }
  
  public void testCheckGroupAvailability(){
    Restaurant test = new Restaurant();
    Seating bar = new Bar(test);
    try{
      bar.checkGroupAvailability();
      assertTrue(true);
    }
    catch(Exception e){
      assertTrue(false);
    }
  }
  
  public void testRemoveGroup(){
    Restaurant test = new Restaurant();
    Seating bar = new Bar(test);
    
    for(int j=0; j<bar.getNumberOfSeatsAvailable(); j++){
      bar.availableSeating.set(j,new SmallGroup(1,1));
    }
    
    bar.removeGroup(bar.availableSeating.get(0));
    
    for(int i = 0; i < bar.getNumberOfSeatsAvailable(); i++){
      if(i==0){
        try{
          bar.availableSeating.get(0);
        }
        catch(Exception e){
          assertTrue(true);
        }
      }
      else{
        assertTrue(bar.availableSeating.get(i)!=null);
      }
    }
  }
  
  
  
  public void testPrintSeats(){
    Restaurant test = new Restaurant();
    Seating bar = new Bar(test);
    try{
      bar.printSeats();
      assertTrue(true);
    }
    catch(Exception e){
    }
  }
  
  
  public void testGetNextCustomerToDepart(){
    Restaurant test = new Restaurant();
    Seating bar = new Bar(test);
    Customer c1 = new SmallGroup(1,1);
    Customer c2 = new LargeGroup(7,0);
    Customer c3 = new SmallGroup(1,10);
    
    assertTrue(bar.getNextCustomerToDepart() == null);
    
    bar.tryToSeatGroup(c1);
    bar.tryToSeatGroup(c2);
    bar.tryToSeatGroup(c3);
    
    c1.setDepartTime(1);
    c2.setDepartTime(12);
    c3.setDepartTime(123);

    assertTrue(bar.getNextCustomerToDepart() == c1);
  }
  
  public void testTryToSeatCustomers(){
    Restaurant test = new Restaurant();
    Seating bar = new Bar(test);
    Customer c1 = new LargeGroup(8,1);
    Customer c2 = new LargeGroup(8,2);
    Customer c3 = new SmallGroup(4,4);
    Customer c4 = new SmallGroup(2,5);

    
    assertTrue(bar.tryToSeatGroup(c1)==true);
    assertTrue(bar.tryToSeatGroup(c2)==true);
    assertTrue(bar.tryToSeatGroup(c3)==true);
    assertTrue(bar.tryToSeatGroup(c4)==false);
    
    for(int i=0; i< bar.getNumberOfSeatsAvailable(); i++) assertTrue(bar.availableSeating.get(i)!=null);
    
    ArrayList<Customer> seated = test.getSeatedList();
    
    for(int j=0; j < seated.size(); j++) assertTrue(seated.get(j) != c4);
  }
  
}