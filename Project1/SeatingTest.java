import junit.framework.TestCase;
import java.util.ArrayList;

public class SeatingTest extends TestCase {
  
  public void testTableWrap(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating table = new Table(test);
    
    for(int i=1; i<=3; i++){
      ArrayList<Customer> tableArr = table.wrap(i);
      assertTrue(tableArr.size()==table.availableSeating.size()+i-1);
    }
  }
  
  public void testBarWrap(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating bar = new Bar(test);
    
    for(int i=1; i<=8; i++){
      ArrayList<Customer> tableArr = bar.wrap(i);
      assertTrue(tableArr.size()==bar.availableSeating.size()+i-1);
    }
  }
  
  public void testBoothWrap(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating booth = new Booth(test);
    
    for(int i=1; i<=8; i++){
      ArrayList<Customer> tableArr = booth.wrap(i);
      assertTrue(tableArr.size()==booth.availableSeating.size()+i-1);
    }
  }
  
  public void testOvalWrap(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating oval = new Oval(test);
    
    for(int i=1; i<=8; i++){
      ArrayList<Customer> tableArr = oval.wrap(i);
      assertTrue(tableArr.size()==oval.availableSeating.size()+i-1);
    }
  }
  
  public void testTableCheckForSize(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating table = new Table(test);
    
    for(int i=0; i<table.seatingIndexes.size(); i++){
      try{
        System.out.println(table.seatingIndexes.get(i).get(0));
      }
      catch(Exception e){
        assertTrue(true);
      }
    }
    for(int i=1; i<= 8;i++) table.checkForSize(i);
    for(int i=0; i<4; i++){
      assertTrue(table.seatingIndexes.get(i).get(0)!=null);
    }
  }
  
  public void testBarCheckForSize(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating bar = new Bar(test);
    
    for(int i=0; i<bar.seatingIndexes.size(); i++){
      try{
        System.out.println(bar.seatingIndexes.get(i).get(0));
      }
      catch(Exception e){
        assertTrue(true);
      }
    }
    for(int i=1; i<= 8;i++) bar.checkForSize(i);
    for(int i=0; i<bar.seatingIndexes.size(); i++){
      assertTrue(bar.seatingIndexes.get(i).get(0)!=null);
    }
  }
  
  public void testBoothCheckForSize(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating booth = new Booth(test);
    
    for(int i=0; i<booth.seatingIndexes.size(); i++){
      try{
        System.out.println(booth.seatingIndexes.get(i).get(0));
      }
      catch(Exception e){
        assertTrue(true);
      }
    }
    for(int i=1; i<= 8;i++) booth.checkForSize(i);
    for(int i=0; i<booth.seatingIndexes.size(); i++){
      assertTrue(booth.seatingIndexes.get(i).get(0)!=null);
    }
  }
  
  public void testOvalCheckForSize(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating oval = new Oval(test);
    
    for(int i=0; i<oval.seatingIndexes.size(); i++){
      try{
        System.out.println(oval.seatingIndexes.get(i).get(0));
      }
      catch(Exception e){
        assertTrue(true);
      }
    }
    for(int i=1; i<= 8;i++) oval.checkForSize(i);
    for(int i=0; i<oval.seatingIndexes.size(); i++){
      assertTrue(oval.seatingIndexes.get(i).get(0)!=null);
    }
  }

   public void testTableCheckGroupAvailability(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating table = new Table(test);
    
    for(int i=0; i<table.seatingIndexes.size(); i++){
      try{
        System.out.println(table.seatingIndexes.get(i).get(0));
      }
      catch(Exception e){
        assertTrue(true);
      }
    }
    table.checkGroupAvailability();
    for(int i=0; i<4; i++){
      assertTrue(table.seatingIndexes.get(i).get(0)!=null);
    }
  }
  
  public void testBarCheckGroupAvailability(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating bar = new Bar(test);
    
    for(int i=0; i<bar.seatingIndexes.size(); i++){
      try{
        System.out.println(bar.seatingIndexes.get(i).get(0));
      }
      catch(Exception e){
        assertTrue(true);
      }
    }
    bar.checkGroupAvailability();
    for(int i=0; i<bar.seatingIndexes.size(); i++){
      assertTrue(bar.seatingIndexes.get(i).get(0)!=null);
    }
  }
  
  public void testBoothCheckGroupAvailability(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating booth = new Booth(test);
    
    for(int i=0; i<booth.seatingIndexes.size(); i++){
      try{
        System.out.println(booth.seatingIndexes.get(i).get(0));
      }
      catch(Exception e){
        assertTrue(true);
      }
    }
    booth.checkGroupAvailability();
    for(int i=0; i<booth.seatingIndexes.size(); i++){
      assertTrue(booth.seatingIndexes.get(i).get(0)!=null);
    }
  }
  
  public void testOvalCheckGroupAvailability(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating oval = new Oval(test);
    
    for(int i=0; i<oval.seatingIndexes.size(); i++){
      try{
        System.out.println(oval.seatingIndexes.get(i).get(0));
      }
      catch(Exception e){
        assertTrue(true);
      }
    }
    oval.checkGroupAvailability();
    for(int i=0; i<oval.seatingIndexes.size(); i++){
      assertTrue(oval.seatingIndexes.get(i).get(0)!=null);
    }
  }
  
  public void testTableRemoveGroup(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating table = new Table(test);
    
    Customer fill = new SmallGroup(4,2);
    table.tryToSeatGroup(fill);
    
    for(int i=0; i< table.availableSeating.size(); i++) assertTrue(table.availableSeating.get(i)==fill);
    table.removeGroup(fill);
    for(int i=0; i< table.availableSeating.size(); i++) assertTrue(table.availableSeating.get(i)==null);
  }
  
    public void testBoothRemoveGroup(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating booth = new Booth(test);
    
    Customer fill1 = new SmallGroup(4,2);
    Customer fill2 = new SmallGroup(4,2);
    
    booth.tryToSeatGroup(fill1);
    booth.tryToSeatGroup(fill2);
    
    for(int i=0; i< booth.availableSeating.size(); i++){
      Customer thisCust = booth.availableSeating.get(i);
      assertTrue(thisCust==fill1 || thisCust==fill2);
    }
    booth.removeGroup(fill1);
    booth.removeGroup(fill2);
    for(int i=0; i< booth.availableSeating.size(); i++) assertTrue(booth.availableSeating.get(i)==null);
  }
  
    public void testBarRemoveGroup(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating bar = new Bar(test);
    
    Customer fill1 = new SmallGroup(4,2);
    Customer fill2 = new SmallGroup(4,2);
    Customer fill3 = new SmallGroup(4,2);
    Customer fill4 = new LargeGroup(8,2);

    
    bar.tryToSeatGroup(fill1);
    bar.tryToSeatGroup(fill2);
    bar.tryToSeatGroup(fill3);
    bar.tryToSeatGroup(fill4);
    
    for(int i=0; i< bar.availableSeating.size(); i++){
      Customer thisCust = bar.availableSeating.get(i);
      assertTrue(thisCust==fill1 || thisCust==fill2 || thisCust==fill3 || thisCust==fill4);
    }
    bar.removeGroup(fill1);
    bar.removeGroup(fill2);
    bar.removeGroup(fill3);
    bar.removeGroup(fill4);
    for(int i=0; i< bar.availableSeating.size(); i++) assertTrue(bar.availableSeating.get(i)==null);
  }
  
    public void testOvalRemoveGroup(){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

    Seating oval = new Oval(test);
    
    Customer fill1 = new LargeGroup(8,2);
    Customer fill2 = new LargeGroup(8,2);
    Customer fill3 = new SmallGroup(4,2);
    Customer fill4 = new LargeGroup(8,2);
    Customer fill5 = new SmallGroup(2,2);
    
    oval.tryToSeatGroup(fill1);
    oval.tryToSeatGroup(fill2);
    oval.tryToSeatGroup(fill3);
    oval.tryToSeatGroup(fill4);
    oval.tryToSeatGroup(fill5);
    
    for(int i=0; i< oval.availableSeating.size(); i++){
      Customer thisCust = oval.availableSeating.get(i);
      assertTrue(thisCust==fill1 || thisCust==fill2 || thisCust==fill3 || thisCust==fill4 || thisCust==fill5);
    }
    oval.removeGroup(fill1);
    oval.removeGroup(fill2);
    oval.removeGroup(fill3);
    oval.removeGroup(fill4);
    oval.removeGroup(fill5);
    for(int i=0; i< oval.availableSeating.size(); i++) assertTrue(oval.availableSeating.get(i)==null);
  }
  
    public void testPrintMethod(){
      //As this is a void method, this test is merely to assert that none of the print commands
      //throw an error.
      Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

      Seating oval = new Oval(test);
      Seating booth = new Booth(test);
      Seating bar = new Bar(test);
      Seating table = new Table(test);
      
      oval.printSeats();
      booth.printSeats();
      bar.printSeats();
      table.printSeats();
    }
  
    public void testTableGetNextCustomerToDepart(){
      Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

      Seating table = new Table(test);
      
      Customer c1 = new SmallGroup(1,5);
      Customer c2 = new SmallGroup(1,6);
      Customer c3 = new SmallGroup(1,7);
      Customer c4 = new SmallGroup(1,8);
      
      table.tryToSeatGroup(c1);
      table.tryToSeatGroup(c2);
      table.tryToSeatGroup(c3);
      table.tryToSeatGroup(c4);
      
      c1.setDepartTime(10);
      c2.setDepartTime(11);
      c3.setDepartTime(12);
      c4.setDepartTime(13);
      
      assertTrue(table.getNextCustomerToDepart()==c1);
    }
    
    public void testOvalGetNextCustomerToDepart(){
      Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

      Seating oval = new Oval(test);
      
      Customer c1 = new SmallGroup(1,5);
      Customer c2 = new SmallGroup(1,6);
      Customer c3 = new SmallGroup(1,7);
      Customer c4 = new SmallGroup(1,8);
      
      oval.tryToSeatGroup(c1);
      oval.tryToSeatGroup(c2);
      oval.tryToSeatGroup(c3);
      oval.tryToSeatGroup(c4);
      
      c1.setDepartTime(10);
      c2.setDepartTime(11);
      c3.setDepartTime(12);
      c4.setDepartTime(13);
      
      assertTrue(oval.getNextCustomerToDepart()==c1);
    }
    
    public void testBoothGetNextCustomerToDepart(){
      Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

      Seating booth = new Booth(test);
      
      Customer c1 = new SmallGroup(1,5);
      Customer c2 = new SmallGroup(1,6);
      Customer c3 = new SmallGroup(1,7);
      Customer c4 = new SmallGroup(1,8);
      
      booth.tryToSeatGroup(c1);
      booth.tryToSeatGroup(c2);
      booth.tryToSeatGroup(c3);
      booth.tryToSeatGroup(c4);
      
      c1.setDepartTime(10);
      c2.setDepartTime(11);
      c3.setDepartTime(12);
      c4.setDepartTime(13);
      
      assertTrue(booth.getNextCustomerToDepart()==c1);
    }
    
    public void testBarGetNextCustomerToDepart(){
      Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

      Seating bar = new Bar(test);
      
      Customer c1 = new SmallGroup(1,5);
      Customer c2 = new SmallGroup(1,6);
      Customer c3 = new SmallGroup(1,7);
      Customer c4 = new SmallGroup(1,8);
      
      bar.tryToSeatGroup(c1);
      bar.tryToSeatGroup(c2);
      bar.tryToSeatGroup(c3);
      bar.tryToSeatGroup(c4);
      
      c1.setDepartTime(10);
      c2.setDepartTime(11);
      c3.setDepartTime(12);
      c4.setDepartTime(13);
      
      assertTrue(bar.getNextCustomerToDepart()==c1);
    }
    
    public void testTableTryToSeatGroup(){
      Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

      Seating table = new Table(test);
      
      Customer c1 = new SmallGroup(1,5);
      Customer c2 = new SmallGroup(1,6);
      Customer c3 = new SmallGroup(1,7);
      Customer c4 = new SmallGroup(1,8);
      Customer c5 = new SmallGroup(1,8);
      
      assertTrue(table.tryToSeatGroup(c1));
      assertTrue(table.tryToSeatGroup(c2));
      assertTrue(table.tryToSeatGroup(c3));
      assertTrue(table.tryToSeatGroup(c4));
      
      assertTrue(table.availableSeating.get(0)==c1);
      assertTrue(table.availableSeating.get(1)==c2);
      assertTrue(table.availableSeating.get(2)==c3);
      assertTrue(table.availableSeating.get(3)==c4);
      
      assertFalse(table.tryToSeatGroup(c5));
    }
    
    public void testBoothTryToSeatGroup(){
      Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

      Seating booth = new Booth(test);
      
      Customer c1 = new SmallGroup(2,5);
      Customer c2 = new SmallGroup(2,6);
      Customer c3 = new SmallGroup(2,7);
      Customer c4 = new SmallGroup(2,8);
      Customer c5 = new SmallGroup(4,8);
      
      assertTrue(booth.tryToSeatGroup(c1));
      assertTrue(booth.tryToSeatGroup(c2));
      assertTrue(booth.tryToSeatGroup(c3));
      assertTrue(booth.tryToSeatGroup(c4));
      
      assertTrue(booth.availableSeating.get(0)==c1);
      assertTrue(booth.availableSeating.get(2)==c2);
      assertTrue(booth.availableSeating.get(4)==c3);
      assertTrue(booth.availableSeating.get(6)==c4);
      
      assertFalse(booth.tryToSeatGroup(c5));
    }
    
    public void testBarTryToSeatGroup(){
      Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

      Seating bar = new Bar(test);
      
      Customer c1 = new LargeGroup(8,5);
      Customer c2 = new LargeGroup(6,6);
      Customer c3 = new SmallGroup(3,7);
      Customer c4 = new SmallGroup(3,8);
      Customer c5 = new SmallGroup(1,8);
      
      assertTrue(bar.tryToSeatGroup(c1));
      assertTrue(bar.tryToSeatGroup(c2));
      assertTrue(bar.tryToSeatGroup(c3));
      assertTrue(bar.tryToSeatGroup(c4));
      
      assertTrue(bar.availableSeating.get(0)==c1);
      assertTrue(bar.availableSeating.get(8)==c2);
      assertTrue(bar.availableSeating.get(14)==c3);
      assertTrue(bar.availableSeating.get(17)==c4);
      
      assertFalse(bar.tryToSeatGroup(c5));
    }
    
    public void testOvalTryToSeatGroup(){
      Restaurant test = new Restaurant();
    test.setCustomerHandling(1,1);

      Seating oval = new Oval(test);
      
      Customer c1 = new LargeGroup(8,5);
      Customer c2 = new LargeGroup(8,6);
      Customer c3 = new LargeGroup(8,7);
      Customer c4 = new SmallGroup(4,8);
      Customer c5 = new SmallGroup(4,8);
      
      assertTrue(oval.tryToSeatGroup(c1));
      assertTrue(oval.tryToSeatGroup(c2));
      assertTrue(oval.tryToSeatGroup(c3));
      assertTrue(oval.tryToSeatGroup(c4));
      
      assertTrue(oval.availableSeating.get(0)==c1);
      assertTrue(oval.availableSeating.get(8)==c2);
      assertTrue(oval.availableSeating.get(16)==c3);
      assertTrue(oval.availableSeating.get(24)==c4);
      
      assertFalse(oval.tryToSeatGroup(c5));
    }
  
}
