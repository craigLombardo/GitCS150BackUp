import java.lang.ArrayIndexOutOfBoundsException;
import java.util.AbstractList;

/**
 * This class creates a custom made LinkedList that has only a tail pointer 
 * and is a singly linked circular list.
 * @author Craig Lombardo
 */
public class MyLinkedList<E> extends AbstractList<E>{
  
  private Node<E> tail;
  private int size;
  
  /**
   * This creates a LinkedList that is initially null with a size of zero
   */
  public MyLinkedList(){
    tail = null;
    size = 0;
  }
  
  /**
   * This method adds elements to the front of the linked list, ie tail.next.
   * @param element A Node to insert into the LinkedList
   */
  public void addToFront(E element){
    if(tail == null){
      tail = new Node<E>(element);
      tail.setNext(tail);
    }
    else{
      Node<E> tmp = tail.getNext();
      Node<E> newNode = new Node<E>(element);
      tail.setNext(newNode);
      newNode.setNext(tmp);
    }
    size++;
  }
  
  /**
   * This method returns the size of the LinkedList.
   * @return int The size of the LinkedList
   */
  public int size(){
    return size;
  }
  
  /**
   * This method returns an element E corresponding to the selected index. 
   * If the number is out of the range of the linked list it will throw an ArrayIndexOutOfBoundsException.
   * @param index The index of the you would like to access in the list.
   * @return E The element at the specified index.
   * @throws ArrayIndexOutOfBoundsException This occurs if the user enters a negative number or a number 
   * greater than or equal to the size of the array
   * as there is no index of such values in the LinkedList.
   */
  public E get(int index) throws ArrayIndexOutOfBoundsException{
    if(index >= size() || index < 0) throw new ArrayIndexOutOfBoundsException();
    else{
      Node<E> thisNode = tail.getNext();
      for(int i=0; i < index; i++){
        thisNode = thisNode.getNext();
      }
      return thisNode.getValue();
    }
  }
  
  /**
   * This method finds and returns the second largest number in the LinkedList
   * @return Integer The number corresponding to the second largest number in the LinkedList, or null if there are 0 or 1 element(s).
   */
  public Integer findSecondLargest(){
    try{
      if(size() >= 2 ){
      Integer largest = 0; 
      Integer secondLargest = null;
      for(int i = 0; i< size(); i++){
        Integer number = (Integer) get(i);
        if(number > largest){
          secondLargest = largest;
          largest = number;
        }
        else if(number > secondLargest) secondLargest = number;
      }
      return secondLargest;
    }
    else return null;
    }
    catch(NullPointerException e){
      return null;
    }
  }
  
  /**
   * This method adds an element of type E to the LinkedList, this becomes the new tail. there is a parameter to add at index; 
   * however, the functionality limits the user to only adding to the front.
   * @param index The index intended to add to (even though it only adds to the front).
   * @param element The element to add.
   */
  public void add(int index, E element){
      addToFront(element);
  }
  
}