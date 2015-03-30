import java.util.LinkedList;

/**
 * This child class has all of the methods of the ShellSortData parent class.
 * Through use of this class, the list will be a LinkedList.
 * @author Craig Lombardo
 */
public class LinkedListShellSort extends ShellSortData{
  
  /**
   * This constructor method instantiates the AbstractList list of the parent class
   * for use.
   */
  public LinkedListShellSort(){
    list = new LinkedList<Integer>();
  }
  
}