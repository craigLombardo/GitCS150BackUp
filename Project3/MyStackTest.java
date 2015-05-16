import junit.framework.TestCase;

public class MyStackTest extends TestCase {

  public void testAdd(){
    MyStack<Integer> test = new MyStack<Integer>();
    assert(test.size()==0);
    test.add(1);
    test.add(2);
    test.add(3);
    assert(test.size()==3);
  }
  public void testGetLast(){
    MyStack<Integer> test = new MyStack<Integer>();
    assert(test.size()==0);
    assert(test.getLast()==null);
    test.add(1);
    test.add(2);
    test.add(3);
    assert(test.size()==3);
    assert(test.getLast()==3);
  }
  public void testSize(){
    MyStack<Integer> test = new MyStack<Integer>();
    assert(test.size()==0);
    test.add(1);
    test.add(2);
    test.add(3);
    assert(test.size()==3);
  }
  
}
