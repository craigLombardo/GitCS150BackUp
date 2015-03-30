import java.util.ArrayList;

/**
 * This child class has all of the methods of the ShellSortData parent class.
 * Through use of this class, the list will be an ArrayList.
 * @author Craig Lombardo
 */

public class ArrayListShellSort extends ShellSortData{
  
  /**
   * This constructor method instantiates the AbstractList list of the parent class
   * for use.
   */
  public ArrayListShellSort(){
    list = new ArrayList<Integer>();
  }
  
}