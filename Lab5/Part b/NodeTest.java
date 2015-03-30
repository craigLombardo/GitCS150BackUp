import junit.framework.TestCase;

public class NodeTest extends TestCase {
  
  public void testGetValue(){
    Node<Integer> n1 = new Node<Integer>(5);
    assertTrue(n1.getValue() == 5);
    Node<Integer> n2 = new Node<Integer>(15);
    assertTrue(n2.getValue() == 15);
    Node<Integer> n3 = new Node<Integer>(0);
    assertTrue(n3.getValue() == 0);
    Node<Integer> n4 = new Node<Integer>(59);
    assertTrue(n4.getValue() == 59);
  }
  
  public void testGetNext(){
    Node<Integer> n1 = new Node<Integer>(5);
    Node<Integer> n2 = new Node<Integer>(15);
    n1.setNext(n2);
    assertTrue(n1.getNext().getValue() == 15);
    n2.setNext(n1);
    assertTrue(n2.getNext().getValue() == 5);
  }
  
  public void testSetNext(){
    Node<Integer> n1 = new Node<Integer>(5);
    Node<Integer> n2 = new Node<Integer>(15);
    n1.setNext(n2);
    assertTrue(n1.getNext() == n2);
    n2.setNext(n1);
    assertTrue(n2.getNext() == n1);
  }
  
}
