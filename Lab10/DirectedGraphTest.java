import junit.framework.TestCase;
import java.util.ArrayList;

public class DirectedGraphTest extends TestCase {
  
  public void testAddNode(){
    DirectedGraph<Integer,String> test = new DirectedGraph<Integer,String>(1,"Hello");
    assert(test.addNode(2,"World"));
    assert(test.addNode(7,"Woah"));
    assert(!test.addNode(2,"My key is in there already!"));
    assert(test.addNode(789,"Good!"));
  }
  
  public void testAddEdge(){
    DirectedGraph<Integer,String> test = new DirectedGraph<Integer,String>(1,"Hello");
    test.addNode(2,"World");
    test.addNode(7,"Woah");
    test.addNode(789,"Good!");
    test.addNode(59,"Hi!");
    
    assert(test.addEdge(2,7,19));
    assert(test.addEdge(7,59,16823123));
    assert(test.addEdge(59,789,1));
    assert(!test.addEdge(181,2123,100));
    assert(!test.addEdge(59,789,0));
  }
  
  public void testFindShortestPath(){
    DirectedGraph<Integer,String> test = new DirectedGraph<Integer,String>(1,"1");
    test.addNode(2,"2");
    test.addNode(7,"7");
    test.addNode(53,"53");
    test.addNode(18,"18");
    
    test.addEdge(1,2,5);
    test.addEdge(2,7,3);
    test.addEdge(7,53,501);
    test.addEdge(1,53,10);
    test.addEdge(7,18,501);
    
    ArrayList path = test.findShortestPath(1,53);
    assert(path.size() == 2);
    
    path = test.findShortestPath(1,18);
    assert(path.size() == 4);
  }
  
}
