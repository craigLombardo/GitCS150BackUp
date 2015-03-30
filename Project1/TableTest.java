import junit.framework.TestCase;
import java.util.ArrayList;

public class TableTest extends TestCase{
  
  /**
   * This method wraps the arraylist for continuity at the table table and small tables
   */
  public void testWrap(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating table = new Table(test);
    ArrayList<Customer> correctArr;
    for(int l=1; l<=8; l++){
      correctArr = new ArrayList<Customer>();
      int groupSize = l;
      for(int j=0; j< table.availableSeating.size(); j++){
        correctArr.add(table.availableSeating.get(j));
      }
      for(int i=0; i < groupSize - 1 && groupSize <= 4; i++){
        correctArr.add(table.availableSeating.get(i));
      }
      
      if(groupSize<=4){ 
        ArrayList<Customer> testArr = table.wrap(l);
        assertTrue(correctArr.size()==testArr.size());
      }
      else{
        try{
          table.wrap(l);
        }
        catch(Exception e){
          assertTrue(true);
        }
      }
    }
  }
  public void testCheckForSize(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating table = new Table(test);
    
    for(int j=0; j<table.getNumberOfSeatsAvailable(); j++){
      assertTrue(table.availableSeating.get(j)==null);
    }
    
    for(int j=0; j<table.getNumberOfSeatsAvailable(); j++){
      table.availableSeating.set(j,new SmallGroup(1,1));
    }
    table.checkGroupAvailability(); 
    
    for(int j=0; j<8; j++){
      try{
        table.seatingIndexes.get(j).get(0);
      }
      catch(Exception e){
        assertTrue(true);
      }
    }
  }
  
  public void testCheckGroupAvailability(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating table = new Table(test);
    try{
      table.checkGroupAvailability();
      assertTrue(true);
    }
    catch(Exception e){
      assertTrue(false);
    }
  }
  
  public void testRemoveGroup(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating table = new Table(test);
    
    for(int j=0; j<table.getNumberOfSeatsAvailable(); j++){
      table.availableSeating.set(j,new SmallGroup(1,1));
    }
    
    table.removeGroup(table.availableSeating.get(0));
    
    for(int i = 0; i < table.getNumberOfSeatsAvailable(); i++){
      if(i==0){
        try{
          table.availableSeating.get(0);
        }
        catch(Exception e){
          assertTrue(true);
        }
      }
      else{
        assertTrue(table.availableSeating.get(i)!=null);
      }
    }
  }
  
  
  
  public void testPrintSeats(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating table = new Table(test);
    try{
      table.printSeats();
      assertTrue(true);
    }
    catch(Exception e){
    }
  }
  
  
  public void testGetNextCustomerToDepart(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating table = new Table(test);
    Customer c1 = new SmallGroup(1,1);
    Customer c2 = new LargeGroup(7,0);
    Customer c3 = new SmallGroup(1,10);
    
    assertTrue(table.getNextCustomerToDepart() == null);
    
    table.tryToSeatGroup(c1);
    table.tryToSeatGroup(c2);
    table.tryToSeatGroup(c3);
    
    c1.setDepartTime(1);
    c2.setDepartTime(12);
    c3.setDepartTime(123);
    
    assertTrue(table.getNextCustomerToDepart() == c1);
  }
  
  public void testTryToSeatGroup(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating table = new Table(test);
    Customer c1 = new LargeGroup(5,1);
    Customer c2 = new SmallGroup(3,4);
    Customer c3 = new SmallGroup(2,5);
    Customer c4 = new SmallGroup(1,6);
    
    assertTrue(table.tryToSeatGroup(c1)==false);
    assertTrue(table.tryToSeatGroup(c2)==true);
    assertTrue(table.tryToSeatGroup(c3)==false);
    assertTrue(table.tryToSeatGroup(c4)==true);
    
    for(int i=0; i< table.getNumberOfSeatsAvailable(); i++) assertTrue(table.availableSeating.get(i)!=null);
    
    ArrayList<Customer> seated = test.getSeatedList();
    
    for(int j=0; j < seated.size(); j++) assertTrue(seated.get(j) != c1 && seated.get(j) != c3);
    
  }
  
}