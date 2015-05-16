import junit.framework.TestCase;

public class RecipeTest extends TestCase {
  
  public void testCompareTo(){
    Recipe recipe1 = new Recipe("Larger", "course", "type", "main", "addons", "sides", 92, 13);
    Recipe recipe2 = new Recipe("Smaller", "course", "type", "main", "addons", "sides", 5, 1);
    assert(recipe2.compareTo(recipe1)<0);
    
    recipe1 = new Recipe("Smaller", "course", "type", "main", "addons", "sides", 92, 13);
    recipe2 = new Recipe("Larger", "course", "type", "main", "addons", "sides", 15, 1232);
    assert(recipe2.compareTo(recipe1)>0);
    
    recipe1 = new Recipe("Larger", "course", "type", "main", "addons", "sides", 92, 13);
    recipe2 = new Recipe("Smaller", "course", "type", "main", "addons", "sides", 100, 5);
    assert(recipe2.compareTo(recipe1)==0);
  }
}