import java.util.LinkedList;

/**
 * This class is a child class of IntContainer. This class extends IntContainer
 * and may use all of it's methods.
 * @author Craig Lombardo
 */
public class LinkedListIntContainer extends IntContainer{
  
  /**
   * This constructor method creates an instance of the child class and instantiates
   * a LinkedList.
   */
  public LinkedListIntContainer(){
    data = new LinkedList<Integer>();
  }
  
}