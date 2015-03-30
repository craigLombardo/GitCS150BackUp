import java.util.ArrayList;

/**
 * This child class has all of the methods of the InsertionSortData parent class.
 * Through use of this class, the list will be an ArrayList.
 * @author Craig Lombardo
 */
public class ArrayListInsertionSort extends InsertionSortData{
  
  /**
   * This constructor method instantiates the AbstractList list of the parent class
   * for use.
   */
  public ArrayListInsertionSort(){
    list = new ArrayList<Integer>();
  }
  
}