import junit.framework.TestCase;
import java.util.ArrayList;

public class OvalTest extends TestCase{
  
  /**
   * This method wraps the arraylist for continuity at the oval table and small tables
   */
  public void testWrap(){
    Restaurant test = new Restaurant();
    Seating oval = new Oval(test);
    ArrayList<Customer> correctArr;
    for(int l=1; l<=8; l++){
      correctArr = new ArrayList<Customer>();
      int groupSize = l;
      for(int j=0; j< oval.availableSeating.size(); j++){
        correctArr.add(oval.availableSeating.get(j));
      }
      for(int i=0; i < groupSize - 1; i++){
        correctArr.add(oval.availableSeating.get(i));
      }
      ArrayList<Customer> testArr = oval.wrap(l);
      assertTrue(correctArr.size()==testArr.size());
    }
  }
  public void testCheckForSize(){
    Restaurant test = new Restaurant();
    Seating oval = new Oval(test);
    
    for(int j=0; j<oval.getNumberOfSeatsAvailable(); j++){
      assertTrue(oval.availableSeating.get(j)==null);
    }
    
    for(int j=0; j<oval.getNumberOfSeatsAvailable(); j++){
      oval.availableSeating.set(j,new SmallGroup(1,1));
    }
    oval.checkGroupAvailability(); 
    
    for(int j=0; j<8; j++){
      try{
         oval.seatingIndexes.get(j).get(0);
      }
      catch(Exception e){
        assertTrue(true);
      }
    }
  }
  
  public void testCheckGroupAvailability(){
    Restaurant test = new Restaurant();
    Seating oval = new Oval(test);
    try{
      oval.checkGroupAvailability();
      assertTrue(true);
    }
    catch(Exception e){
      assertTrue(false);
    }
  }
  
  public void testRemoveGroup(){
    Restaurant test = new Restaurant();
    Seating oval = new Oval(test);
    
    for(int j=0; j<oval.getNumberOfSeatsAvailable(); j++){
      oval.availableSeating.set(j,new SmallGroup(1,1));
    }
    
    oval.removeGroup(oval.availableSeating.get(0));
    
    for(int i = 0; i < oval.getNumberOfSeatsAvailable(); i++){
      if(i==0){
        try{
          oval.availableSeating.get(0);
        }
        catch(Exception e){
          assertTrue(true);
        }
      }
      else{
        assertTrue(oval.availableSeating.get(i)!=null);
      }
    }
  }
  
  
  
  public void testPrintSeats(){
    Restaurant test = new Restaurant();
    Seating oval = new Oval(test);
    try{
      oval.printSeats();
      assertTrue(true);
    }
    catch(Exception e){
    }
  }
  
  
  public void testGetNextCustomerToDepart(){
    Restaurant test = new Restaurant();
    Seating oval = new Oval(test);
    Customer c1 = new SmallGroup(1,1);
    Customer c2 = new LargeGroup(7,0);
    Customer c3 = new SmallGroup(1,10);

    assertTrue(oval.getNextCustomerToDepart() == null);
    
    oval.tryToSeatGroup(c1);
    oval.tryToSeatGroup(c2);
    oval.tryToSeatGroup(c3);
    
    c1.setDepartTime(1);
    c2.setDepartTime(12);
    c3.setDepartTime(123);
    
    assertTrue(oval.getNextCustomerToDepart() == c1);
  }
  
  public void testTryToSeatCustomers(){
    Restaurant test = new Restaurant();
    Seating oval = new Oval(test);
    Customer c1 = new LargeGroup(8,1);
    Customer c2 = new LargeGroup(8,2);
    Customer c3 = new LargeGroup(8,3);
    Customer c4 = new SmallGroup(4,4);
    Customer c5 = new SmallGroup(2,5);
    Customer c6 = new SmallGroup(3,6);
    
    assertTrue(oval.tryToSeatGroup(c1)==true);
    assertTrue(oval.tryToSeatGroup(c2)==true);
    assertTrue(oval.tryToSeatGroup(c3)==true);
    assertTrue(oval.tryToSeatGroup(c4)==true);
    assertTrue(oval.tryToSeatGroup(c5)==true);
    assertTrue(oval.tryToSeatGroup(c6)==false);
    
    for(int i=0; i< oval.getNumberOfSeatsAvailable(); i++) assertTrue(oval.availableSeating.get(i)!=null);
    
    ArrayList<Customer> seated = test.getSeatedList();
    
    for(int j=0; j < seated.size(); j++) assertTrue(seated.get(j) != c6);
  }
  
}