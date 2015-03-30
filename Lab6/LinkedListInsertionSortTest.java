import junit.framework.TestCase;
import java.util.ArrayList;

public class LinkedListInsertionSortTest extends TestCase{
  
  public void testInsertionSort(){
    InsertionSortData test = new ArrayListInsertionSort();
    ArrayList<Integer> answer = new ArrayList<Integer>();
    
    assertTrue(answer.size()==0);
    test.insertionSort();
    
    test.addElement(8); 
    test.addElement(19);
    test.addElement(3);
    test.addElement(6);
    test.addElement(99);
    
    answer.add(3);
    answer.add(6);
    answer.add(8);
    answer.add(19);
    answer.add(99);
    
    test.insertionSort();
    
    for(int i=0; i< test.size(); i++) assertTrue(test.compareTo(i,answer.get(i)));
  }
  
  public void testAddElement(){
    
    InsertionSortData test = new ArrayListInsertionSort();
    
    ArrayList<Integer> answer = new ArrayList<Integer>();
    
    test.addElement(8);
    test.addElement(19);
    test.addElement(3);
    test.addElement(6);
    test.addElement(99);
    
    answer.add(8);
    answer.add(19);
    answer.add(3);
    answer.add(6);
    answer.add(99);
    
    for(int i=0; i< test.size(); i++) assertTrue(test.compareTo(i,answer.get(i)));
    
  }
  
  public void testPrintData(){
    //This test essentially ensures there were no null pointers as it is a void method
    InsertionSortData test = new ArrayListInsertionSort();
    test.printData();
    
    test.addElement(8);
    test.addElement(19);
    test.addElement(3);
    test.addElement(6);
    test.printData();
    
    test.insertionSort();
    
    test.printData();
    assertTrue(true);
    
  }
  
  public void testCompareTo(){
    
    InsertionSortData test = new LinkedListInsertionSort();
    
    ArrayList<Integer> answer = new ArrayList<Integer>();
    
    test.addElement(8);
    test.addElement(19);
    test.addElement(3);
    test.addElement(6);
    test.addElement(99);
    test.addElement(9);
    
    answer.add(8);
    answer.add(19);
    answer.add(3);
    answer.add(6);
    answer.add(99);
    answer.add(3);
    
    int sizeMinOne = test.size()-1;
    for(int i=0; i< sizeMinOne; i++) assertTrue(test.compareTo(i,answer.get(i)));
    assertFalse(test.compareTo(sizeMinOne,answer.get(sizeMinOne)));
    
  }
  
}