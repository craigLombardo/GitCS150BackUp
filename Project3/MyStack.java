import java.util.LinkedList;

/**
 * This class acts as a stack which will implement LIFO.
 * @author Craig Lombardo
 */
public class MyStack<E>{
  
  private LinkedList<E> stack;
  
  /**
   * This constructor creates a new instance of MyStack.
   */
  public MyStack(){
    stack = new LinkedList<E>();
  }
  
  /**
   * This method adds an element to the top of the stack.
   * @param element The element to add to the top of the stack.
   */
  public void add(E element){
    stack.add(element);
  }
  
  /**
   * This method returns and removes the top element from the stack
   * @return The last element on the stack.
   */
  public E getLast(){
    return stack.pollLast();
  }
  
  /**
   * This method returns the current size of the stack.
   * @return The size of the stack.
   */
  public int size(){
    return stack.size();
  }
}