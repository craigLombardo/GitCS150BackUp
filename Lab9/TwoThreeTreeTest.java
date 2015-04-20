import junit.framework.TestCase;
import java.util.ArrayList;
public class TwoThreeTreeTest extends TestCase {
  
  public void testAdd(){
    TwoThreeTree<Integer,Integer> cont = new TwoThreeTree<Integer,Integer>();
    
    assert(cont.add(1,1));
    assert(cont.add(6,6));
    assert(cont.add(12,12));
    assert(cont.add(99,99));
    assert(!cont.add(1,1));
    assert(cont.add(-18923,-18923));
    assert(cont.add(345,345));
  }
  
  public void testClear(){
    TwoThreeTree<Integer,Integer> cont = new TwoThreeTree<Integer,Integer>();
    
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
    TwoThreeTree<Integer,Integer> cont = new TwoThreeTree<Integer,Integer>();
    
    cont.add(1,1);
    cont.add(6,6);
    cont.add(12,12);
    cont.add(345,345);
    cont.add(7,7);
    cont.add(99,99);
    cont.add(12673,12673);
    cont.add(-18923,-18923);
    
    assert(cont.contains(-18923));
    assert(!cont.contains(0));
  }
  
  public void testFirst(){
    TwoThreeTree<Integer,Integer> cont = new TwoThreeTree<Integer,Integer>();
    
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
    TwoThreeTree<Integer,Integer> cont = new TwoThreeTree<Integer,Integer>();
    
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
    TwoThreeTree<Integer,Integer> cont = new TwoThreeTree<Integer,Integer>();
    
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
    TwoThreeTree<Integer,Integer> cont = new TwoThreeTree<Integer,Integer>();
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
      assert(mine.get(i).equals(arr.get(i)));
    }
    
  }
  
}