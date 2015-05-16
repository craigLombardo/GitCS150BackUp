import junit.framework.TestCase;
import java.util.ArrayList;

public class DatabaseTest extends TestCase {
  
  public void testaddJunction(){
    Database test = new Database("","","");
    Junction nill = new Junction("Junction",null,null);
    Junction farm = new Junction("Craig's Farm",new Farm("Craig",null), null);
    Junction rest = new Junction("The Restaurant",null,new Restaurant("Maybe"));
    Junction fail = new Junction("Craig's Farm",null,null);
    assert(test.addJunction(nill));
    assert(test.addJunction(farm));
    assert(test.addJunction(rest));
    assert(!test.addJunction(fail));
  }
  
  public void testConnect(){
    Database test = new Database("","","");
    Junction nill = new Junction("Junction",null,null);
    Junction farm = new Junction("Craig Farm",new Farm("Craig",null), null);
    Junction rest = new Junction("The Restaurant",null,new Restaurant("Maybe"));
    
    test.addJunction(nill);
    test.addJunction(farm);
    test.addJunction(rest);
    
    assert(test.connect("Junction","Craig Farm",20));
    assert(test.connect("Junction","The Restaurant",5));
    
    assert(!test.connect("Junction","fake",12));
  }
  
  public void testGetShortestPathTo(){
    Database test = new Database("","","");
    Junction nill = new Junction("Junction",null,null);
    Junction farm = new Junction("Craig Farm",new Farm("Craig",null), null);
    Junction rest = new Junction("The Restaurant",null,new Restaurant("Maybe"));
    
    test.addJunction(nill);
    test.addJunction(farm);
    test.addJunction(rest);
    
    test.connect("Junction","Craig Farm",20);
    test.connect("Junction","The Restaurant",5);
    test.connect("Craig Farm","Junction",10);
    
    String answer = "";
    ArrayList<Junction> path = test.getShortestPathTo(rest,farm);
    for(Junction j : path) answer = answer + j.getName() + " -> ";
    assert(answer.equals("The Restaurant -> Junction -> Craig Farm -> "));
    assert(test.getDistance(path)==15);
    
    answer = "";
    path = test.getShortestPathTo(nill,rest);
    for(Junction j : path) answer = answer + j.getName() + " -> ";
    assert(answer.equals("Junction -> The Restaurant -> "));
    assert(test.getDistance(path)==5);
    
    answer = "";
    path = test.getShortestPathTo(farm,rest);
    for(Junction j : path) answer = answer + j.getName() + " -> ";
    assert(answer.equals("Craig Farm -> Junction -> The Restaurant -> "));
    assert(test.getDistance(path)==15);
  }
}
