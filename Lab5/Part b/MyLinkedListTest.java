import junit.framework.TestCase;

public class MyLinkedListTest extends TestCase{
  
  public void testAddToFront(){
    MyLinkedList<Integer> test = new MyLinkedList<Integer>();
    test.addToFront(11);
    test.addToFront(1);
    test.addToFront(0);
    test.addToFront(24323612);
    test.addToFront(25834231);
    
    assertTrue(test.get(0) == 25834231);
  }
  
  public void testSize(){
    MyLinkedList<Integer> test = new MyLinkedList<Integer>();
    assertTrue(test.size()==0);
    test.addToFront(11);
    test.addToFront(1);
    test.addToFront(0);
    test.addToFront(7834121);
    test.addToFront(25834231);
    assertTrue(test.size()==5);
  }
  
  public void testGet(){
    MyLinkedList<Integer> test = new MyLinkedList<Integer>();
    try{
      test.get(3);
    }
    catch(ArrayIndexOutOfBoundsException e){
      assertTrue(true);
    }
    
    test.addToFront(11);
    test.addToFront(1);
    test.addToFront(0);
    test.addToFront(7834121);
    test.addToFront(25834231);
    
    assertTrue(test.get(3)==1);
    
    try{
      test.get(8);
    }
    catch(ArrayIndexOutOfBoundsException e){
      assertTrue(true);
    }
  }
  
  public void testFindSecondLargest(){
    MyLinkedList<Integer> test = new MyLinkedList<Integer>();
    test.addToFront(11);
    test.addToFront(1);
    test.addToFront(0);
    test.addToFront(24323612);
    test.addToFront(25834231);
    assertTrue(test.findSecondLargest() == 24323612);
  }
  
  public void testAdd(){
    MyLinkedList<Integer> test = new MyLinkedList<Integer>();
    test.add(0,11);
    test.add(0,1);
    test.add(0,0);
    test.add(0,24323612);
    test.add(0,25834231);
    
    assertTrue(test.get(0) == 25834231);
  }
  
}