import java.util.ArrayList;

/**
 * This class is a child class of IntContainer. This class extends IntContainer
 * and may use all of it's methods.
 * @author Craig Lombardo
 */
public class ArrayListIntContainer extends IntContainer{

  /**
   * This constructor method creates an instance of the child class and instantiates
   * an ArrayList.
   */
  public ArrayListIntContainer(){
    data = new ArrayList<Integer>();
  }
  
}