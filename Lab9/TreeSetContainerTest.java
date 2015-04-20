import junit.framework.TestCase;
import java.util.ArrayList;

public class TreeSetContainerTest extends TestCase {
  
  public void testAdd(){
    TreeSetContainer<Integer,Integer> cont = new TreeSetContainer<Integer,Integer>();
    
    assert(cont.add(1,1));
    assert(cont.add(6,6));
    assert(cont.add(12,12));
    assert(cont.add(345,345));
    assert(cont.add(7,7));
    assert(cont.add(99,99));
    assert(cont.add(12673,12673));
    assert(!cont.add(1,1));
    assert(cont.add(-18923,-18923));
  }
  
  public void testClear(){
    TreeSetContainer<Integer,Integer> cont = new TreeSetContainer<Integer,Integer>();
    
    cont.add(1,1);
    cont.add(6,6);
    cont.add(12,12);
    cont.add(345,345);
    cont.add(7,7);
    cont.add(99,99);
    cont.add(12673,12673);
    cont.add(-18923,-18923);
    
    assert(cont.size()==8);
    
    cont.clear();
    
    assert(cont.size()==0);
  }
  
  public void testContains(){
    TreeSetContainer<Integer,Integer> cont = new TreeSetContainer<Integer,Integer>();
    
    cont.add(1,1);
    cont.add(6,6);
    cont.add(12,12);
    cont.add(345,345);
    cont.add(7,7);
    cont.add(99,99);
    cont.add(12673,12673);
    cont.add(-18923,-18923);
    
    assert(cont.contains(1));
    assert(cont.contains(-18923));
    assert(!cont.contains(0));
  }
  
  public void testFirst(){
    TreeSetContainer<Integer,Integer> cont = new TreeSetContainer<Integer,Integer>();
    
    cont.add(1,1);
    cont.add(6,6);
    cont.add(12,12);
    cont.add(345,345);
    cont.add(7,7);
    cont.add(99,99);
    cont.add(12673,12673);
    cont.add(-18923,-18923);
    
    assert(cont.first().equals(-18923));
  }
  
  public void testLast(){
    TreeSetContainer<Integer,Integer> cont = new TreeSetContainer<Integer,Integer>();
    
    cont.add(1,1);
    cont.add(6,6);
    cont.add(12,12);
    cont.add(345,345);
    cont.add(7,7);
    cont.add(99,99);
    cont.add(12673,12673);
    cont.add(-18923,-18923);
    
    assert(cont.last().equals(12673));
  }
  
  public void testSize(){
    TreeSetContainer<Integer,Integer> cont = new TreeSetContainer<Integer,Integer>();
    
    cont.add(1,1);
    cont.add(6,6);
    cont.add(12,12);
    cont.add(345,345);
    cont.add(7,7);
    cont.add(99,99);
    cont.add(12673,12673);
    cont.add(-18923,-18923);
    
    assert(cont.size()==8);
    
    cont.clear();
    
    assert(cont.size()==0);
  }
  
  
  public void testToArray(){
    TreeSetContainer<Integer,Integer> cont = new TreeSetContainer<Integer,Integer>();
    ArrayList<Integer> arr = new ArrayList<Integer>();
    
    cont.add(1,1);
    cont.add(6,6);
    cont.add(12,12);
    cont.add(345,345);
    cont.add(7,7);
    cont.add(99,99);
    cont.add(12673,12673);
    cont.add(-18923,-18923);
    
    arr.add(-18923);
    arr.add(1);
    arr.add(6);
    arr.add(7);
    arr.add(12);
    arr.add(99);
    arr.add(345);
    arr.add(12673);
    
    
    ArrayList<Integer> mine = cont.toArray();
    for(int i=0; i<mine.size(); i++){
      System.out.println(mine.get(i));
      assert(mine.get(i).equals(arr.get(i)));
    }
    
  }
  
}
