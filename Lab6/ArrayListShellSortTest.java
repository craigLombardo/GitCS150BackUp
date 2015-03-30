import junit.framework.TestCase;
import java.util.ArrayList;

public class ArrayListShellSortTest extends TestCase{
  
  public void testShellSort(){
    ShellSortData test = new ArrayListShellSort();
    ArrayList<Integer> answer = new ArrayList<Integer>();
    
    assertTrue(answer.size()==0);
    test.shellSort();
    
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
    
    test.shellSort();
    
    for(int i=0; i< test.size(); i++) assertTrue(test.compareTo(i,answer.get(i)));
  }
  
  public void testAddElement(){
    
    ShellSortData test = new ArrayListShellSort();
    
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
    ShellSortData test = new ArrayListShellSort();
    test.printData();
    
    test.addElement(8);
    test.addElement(19);
    test.addElement(3);
    test.addElement(6);
    test.printData();
    
    test.shellSort();
    
    test.printData();
    assertTrue(true);
    
  }
  
  public void testCompareTo(){
    
    ShellSortData test = new ArrayListShellSort();
    
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