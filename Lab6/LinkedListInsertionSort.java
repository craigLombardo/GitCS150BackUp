import java.util.LinkedList;

/**
 * This child class has all of the methods of the InsertionSortData parent class.
 * Through use of this class, the list will be a LinkedList.
 * @author Craig Lombardo
 */
public class LinkedListInsertionSort extends InsertionSortData{
  
  /**
   * This constructor method instantiates the AbstractList list of the parent class
   * for use.
   */
  public LinkedListInsertionSort(){
    list = new LinkedList<Integer>();
  }
  
  
}