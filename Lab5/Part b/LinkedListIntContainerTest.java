import junit.framework.TestCase;

public class LinkedListIntContainerTest extends TestCase{
 
  public void testLinkedListIntContainer(){
    IntContainer test1 = new LinkedListIntContainer();
    IntContainer test2 = new MyListIntContainer();
    try{
      test1.addToFront(10);
      test1.addToFront(0);
      test1.addToFront(10123);
      test1.addToFront(532467);
      test1.addToFront(12793);
      
      test2.addToFront(10);
      test2.addToFront(0);
      test2.addToFront(10123);
      test2.addToFront(532467);
      test2.addToFront(12793);
      
      assertTrue(test1.findSecondLargest() == 12793);
      assertTrue(test2.findSecondLargest() == 12793);
    }
    catch(Exception e){
      
    }
  }
}