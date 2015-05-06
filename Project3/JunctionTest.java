import junit.framework.TestCase;

public class JunctionTest extends TestCase {
  
  public void testCompareTo(){
    Junction test1 = new Junction("larger",null, null);
    Junction test2 = new Junction("Smaller",null,null);
    assert(test1.compareTo(test2)>0);
    
    assert(test2.compareTo(test1)<0);
    
    test1 = new Junction("match",null,null);
    test2 = new Junction("match",null,null);
    
    assert(test1.compareTo(test2)==0);
  }
  
  public void testConnectTo(){
    Junction nill = new Junction("Junction",null,null);
    Junction farm = new Junction("Craig Farm",new Farm("Craig",null), null);
    Junction rest = new Junction("The Restaurant",null,new Restaurant("Maybe"));
    
    nill.connectTo(farm, 120);
    nill.connectTo(rest,129);
    
    assert(nill.getRoads().size()==2);
    assert(rest.getRoads().size()==1);
    assert(farm.getRoads().size()==1);
  }
  
  public void testComputePaths(){
  Junction nill = new Junction("Junction",null,null);
    Junction farm = new Junction("Craig Farm",new Farm("Craig",null), null);
    Junction rest = new Junction("The Restaurant",null,new Restaurant("Maybe"));
    
    nill.connectTo(farm, 120);
    nill.connectTo(rest,129);
  }
  
}
