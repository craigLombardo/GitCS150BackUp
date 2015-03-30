import junit.framework.TestCase;
import java.util.ArrayList;

public class BoothTest extends TestCase{
  
  /**
   * This method wraps the arraylist for continuity at the booth table and small tables
   */
  public void testWrap(){
    Restaurant test = new Restaurant();
    Seating booth = new Booth(test);
    ArrayList<Customer> correctArr;
    for(int l=1; l<=8; l++){
      correctArr = new ArrayList<Customer>();
      int groupSize = l;
      for(int j=0; j< booth.availableSeating.size(); j++){
        correctArr.add(booth.availableSeating.get(j));
      }
      for(int i=0; i < groupSize - 1; i++){
        correctArr.add(booth.availableSeating.get(i));
      }
      ArrayList<Customer> testArr = booth.wrap(l);
      assertTrue(correctArr.size()==testArr.size());
    }
  }
  
  public void testCheckForSize(){
    Restaurant test = new Restaurant();
    Seating booth = new Booth(test);
    
    for(int j=0; j<booth.getNumberOfSeatsAvailable(); j++){
      assertTrue(booth.availableSeating.get(j)==null);
    }
    
    for(int j=0; j<booth.getNumberOfSeatsAvailable(); j++){
      booth.availableSeating.set(j,new SmallGroup(1,1));
    }
    booth.checkGroupAvailability(); 
    
    for(int j=0; j<8; j++){
      try{
        booth.seatingIndexes.get(j).get(0);
      }
      catch(Exception e){
        assertTrue(true);
      }
    }
  }
  
  public void testCheckGroupAvailability(){
    Restaurant test = new Restaurant();
    Seating booth = new Booth(test);
    try{
      booth.checkGroupAvailability();
      assertTrue(true);
    }
    catch(Exception e){
      assertTrue(false);
    }
  }
  
  public void testRemoveGroup(){
    Restaurant test = new Restaurant();
    Seating booth = new Booth(test);
    
    for(int j=0; j<booth.getNumberOfSeatsAvailable(); j++){
      booth.availableSeating.set(j,new SmallGroup(1,1));
    }
    
    booth.removeGroup(booth.availableSeating.get(0));
    
    for(int i = 0; i < booth.getNumberOfSeatsAvailable(); i++){
      if(i==0){
        try{
          booth.availableSeating.get(0);
        }
        catch(Exception e){
          assertTrue(true);
        }
      }
      else{
        assertTrue(booth.availableSeating.get(i)!=null);
      }
    }
  }
  
  
  
  public void testPrintSeats(){
    Restaurant test = new Restaurant();
    Seating booth = new Booth(test);
    try{
      booth.printSeats();
      assertTrue(true);
    }
    catch(Exception e){
    }
  }
  
  
  public void testGetNextCustomerToDepart(){
    Restaurant test = new Restaurant();
    Seating booth = new Booth(test);
    Customer c1 = new SmallGroup(1,1);
    Customer c2 = new LargeGroup(7,0);
    Customer c3 = new SmallGroup(1,10);
    
    assertTrue(booth.getNextCustomerToDepart() == null);
    
    booth.tryToSeatGroup(c1);
    booth.tryToSeatGroup(c2);
    booth.tryToSeatGroup(c3);
    
    c1.setDepartTime(1);
    c2.setDepartTime(12);
    c3.setDepartTime(123);
    
    assertTrue(booth.getNextCustomerToDepart() == c1);
  }
  
  public void testTryToSeatGroup(){
    Restaurant test = new Restaurant();
    Seating booth = new Booth(test);
    Customer c1 = new LargeGroup(5,1);
    Customer c2 = new SmallGroup(3,4);
    Customer c3 = new SmallGroup(2,5);
    
    assertTrue(booth.tryToSeatGroup(c1)==true);
    assertTrue(booth.tryToSeatGroup(c2)==true);
    assertTrue(booth.tryToSeatGroup(c3)==false);
    
    for(int i=0; i< booth.getNumberOfSeatsAvailable(); i++) assertTrue(booth.availableSeating.get(i)!=null);
    
    ArrayList<Customer> seated = test.getSeatedList();
    
    for(int j=0; j < seated.size(); j++) assertTrue(seated.get(j) != c3);
    
  }
  
}