import java.util.AbstractList;

/**
 * This class is a child class of IntContainer. This class extends IntContainer
 * and may use all of it's methods.
 * @author Craig Lombardo
 */
public class MyListIntContainer extends IntContainer{

  private MyLinkedList myList;
  
  /**
   * This constructor method creates an instance of the child class and instantiates
   * an instance of myLinkedList.
   */
  public MyListIntContainer(){
    data = new MyLinkedList<Integer>();
  }
  
}