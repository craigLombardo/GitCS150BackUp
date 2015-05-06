import junit.framework.TestCase;
import java.util.ArrayList;

public class FarmTest extends TestCase{
  
  public void testHasWhichIngredients(){
    ArrayList<Item> stock = new ArrayList<Item>();
    
    Item one = new Item("one",1);
    Item two = new Item("two",2);
    Item three = new Item("three",3);
    Item four = new Item("four",4);
    
    stock.add(one);
    stock.add(two);
    stock.add(three);
    stock.add(four);
    
    Farm test = new Farm("Test Farm",stock);
    
    ArrayList<String> input = new ArrayList<String>();
    
    input.add("one");
    input.add("two");
    input.add("three");
    input.add("four");
    input.add("five");
    
    ArrayList<String> output = test.hasWhichIngredients(input);
    
    ArrayList<String> ans = new ArrayList<String>();
    
    ans.add("one");
    ans.add("two");
    ans.add("three");
    ans.add("four");
    
    for(int i=0; i<ans.size(); i++){
      assert(ans.get(i).equals(output.get(i)));
    }
  }
  
  public void testGetCost(){
    ArrayList<Item> stock = new ArrayList<Item>();
    
    Item one = new Item("one",1);
    Item two = new Item("two",2);
    Item three = new Item("three",3);
    Item four = new Item("four",4);
    
    stock.add(one);
    stock.add(two);
    stock.add(three);
    stock.add(four);
    
    Farm test = new Farm("Test Farm",stock);
    
    ArrayList<String> input = new ArrayList<String>();
    
    input.add("one");
    input.add("two");
    input.add("three");
    input.add("four");
    input.add("five");
    
    double cost = test.getCost(input);
    assert(cost==10);
    
    input.remove("three");
    input.remove("five");
    
    cost = test.getCost(input);
    assert(cost==7);
  }
}