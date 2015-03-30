import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class creates a LineQueue that will have first in first out functionality.
 * @author Craig Lombardo
 */
public class LineQueue<E> extends AbstractQueue<E>{
  
  private LinkedList<E> queue;
  private Iterator<E> iterator;
  
  /**
   * The constructor method instantiates a linked list of type E (E is the type of LineQueue)
   */
  public LineQueue(){
    queue = new LinkedList<E>();
  }
  
  /**
   * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
   * @return E The head of the queue.
   */
  public E peek(){
    try{
      return queue.get(0);
    }
    catch(Exception e){
      return null;
    }
  }
  
  /**
   * Retrieves and removes the head of this queue, or returns null if this queue is empty.
   * @return E The head of the queue.
   */
  public E poll(){
    try{
      E tmp = queue.get(0);
      queue.remove(0);
      return tmp;
    }
    catch(Exception e){
      return null;
    }
  }
  
  /**
   * Retrieves and removes the head of this queue. Throws an exception if this queue is empty.
   * @return E The head of the queue.
   * @throws NoSuchElementException Thrown if there are no elements in the queue.
   */
  public E remove() throws NoSuchElementException{
    try{
      E tmp = queue.get(0);
      queue.remove(0);
      return tmp;
    }
    catch(Exception e){
      throw new NoSuchElementException();
    }
  }
  
  /**
   * This method returns the size of the queue.
   * return int The size of the queue
   */
  public int size(){
    return queue.size();
  }
  
  /**
   * This method creates an iterator for the queue, order is not guaranteed.
   * @return Iterator An iterator for the queue.
   */
  public Iterator<E> iterator(){
    return queue.listIterator();
  }
  
  /**
   * This method adds the element to the end of the queue.
   * @param e The element to add to the queue.
   * @return boolean A boolean corresponding to whether or not it was completed successfully.
   */
  public boolean offer(E e){
    try{
      queue.add(e);
      return true;
    }
    catch(Exception k){
      return false;
    }
  }
  
}