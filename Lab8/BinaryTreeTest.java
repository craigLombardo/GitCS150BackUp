import junit.framework.TestCase;
import java.util.ArrayList;

public class BinaryTreeTest extends TestCase {
  
  public void testAdd(){
    BinaryTree<Integer,String> test = new BinaryTree<Integer,String>();
    assert(test.add(3,"hello"));
    assert(test.add(0,"world"));
    assert(test.add(-162371293,"huh?"));
    assert(test.add(631674231,"what?"));
    assert(test.add(3672,"please....."));
    assert(!test.add(631674231,"Im already in there!"));
    
    test.clear();
    assert(test.add(631674231,"This time I'm root!"));
  }
  
  public void testClear(){
    BinaryTree<Integer,String> test = new BinaryTree<Integer,String>();
    assert(test.add(3,"hello"));
    assert(test.add(0,"world"));
    assert(test.add(-162371293,"huh?"));
    assert(test.add(631674231,"what?"));
    assert(test.add(3672,"please....."));
    assert(test.size()==5);
    test.clear();
    assert(test.size()==0);
  }
  
  public void testContains(){
    BinaryTree<Integer,String> test = new BinaryTree<Integer,String>();
    assert(test.add(3,"hello"));
    assert(test.add(0,"world"));
    assert(test.add(-162371293,"huh?"));
    assert(test.add(631674231,"what?"));
    assert(test.add(3672,"please....."));
    assert(test.contains(3672));
    assert(test.contains(631674231));
    assert(!test.contains(22));
    test.clear();
    assert(!test.contains(3672));
  }
  
  public void testFirst(){
    BinaryTree<Integer,String> test = new BinaryTree<Integer,String>();
    
    assert(test.first() == null);
    
    assert(test.add(3,"hello"));
    assert(test.add(0,"world"));
    assert(test.add(-162371293,"huh?"));
    assert(test.add(631674231,"what?"));
    assert(test.add(3672,"please....."));
    
    assert(test.first().equals("huh?"));
    
    test.clear();
    assert(test.first() == null);
    
  }
  
  public void testLast(){
    BinaryTree<Integer,String> test = new BinaryTree<Integer,String>();
    
    assert(test.last() == null);
    
    assert(test.add(3,"hello"));
    assert(test.add(0,"world"));
    assert(test.add(-162371293,"huh?"));
    assert(test.add(631674231,"what?"));
    assert(test.add(3672,"please....."));
    
    assert(test.last().equals("what?"));
    
    test.clear();
    assert(test.last() == null);
    
  }
  
  public void testRemove(){
   BinaryTree<Integer,String> test = new BinaryTree<Integer,String>();
    test.add(30,"30");
    test.add(9,"9");
    test.add(47,"47");
    test.add(1,"1");
    test.add(20,"20");
    test.add(17,"17");
    test.add(26,"26");
    test.add(29,"29");
    test.add(15,"15");
    test.add(19,"19");
    test.add(55,"55");
    test.add(48,"48");
    test.add(56,"56");
    
    assert(test.size()==13);
    
    assert(test.remove(20));
    assert(test.remove(26));
    assert(test.remove(29));
    assert(test.remove(15));
    assert(test.remove(17));
    assert(test.remove(19));
    assert(!test.remove(19));
    
    assert(test.size()==7);

    assert(!test.contains(29));
    assert(!test.contains(26));
    assert(!test.contains(15));
    
    assert(test.remove(1));
    assert(test.remove(9));
    assert(test.remove(30));
    assert(test.remove(48));
    assert(test.remove(56));
    assert(test.remove(55));
    
    assert(test.size() == 1);
    
    assert(test.remove(47));
    
    assert(test.size() == 0);
    
    assert(!test.remove(9));
    assert(!test.remove(1792673));
    assert(!test.remove(47));
    
  }
  
  public void testSize(){
    BinaryTree<Integer,String> test = new BinaryTree<Integer,String>();
    assert(test.size()==0);
    assert(test.add(3,"hello"));
    assert(test.add(0,"world"));
    assert(test.add(-162371293,"huh?"));
    assert(test.add(631674231,"what?"));
    assert(test.add(3672,"please....."));
    assert(test.size()==5);
    test.clear();
    assert(test.size()==0);
  }
  
  public void testToArray(){
    BinaryTree<Integer,String> test = new BinaryTree<Integer,String>();
    ArrayList<String> answer = new ArrayList<String>();
    
    assert(test.toArray().size() == 0);
    
    assert(test.add(3,"hello"));
    assert(test.add(0,"world"));
    assert(test.add(-162371293,"huh?"));
    assert(test.add(631674231,"what?"));
    assert(test.add(3672,"please....."));
    
    answer.add("huh?");
    answer.add("world");
    answer.add("hello");
    answer.add("please.....");
    answer.add("what?");

    test.clear();
    
    assert(test.toArray().size() == 0);

  }
  
}
