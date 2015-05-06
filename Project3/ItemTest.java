import junit.framework.TestCase;

public class ItemTest extends TestCase {
  
  public void testCompareTo(){
    Item one = new Item("Smaller",1.0);
    Item two = new Item("larger",1.0);
    
    assert(one.compareTo(two)<0);
    assert(two.compareTo(one)>0);
      
    Item sameOne = new Item("match",1.0);
    Item sameTwo = new Item("match",2.0);
    
    assert(sameOne.compareTo(sameTwo)==0);
  }
  
}
