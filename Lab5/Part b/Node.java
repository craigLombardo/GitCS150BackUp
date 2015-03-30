/**
 * This class will create a Node which will be used in MyLinkedList. 
 * Each node will have a value and will be assigned a Node to point to.
 * @author Craig Lombardo
 */

public class Node<E>{

  private Node<E> next;
  private E value;
  
  /**
   * This constructor method creates a Node with a specified value/bit of information.
   * @param value The information stored within the Node
   */
  public Node(E value){
    this.value = value;
  }
  
  /**
   * This method returns the value of the Node
   * @return E The information/value stored wihin the node
   */
  public E getValue(){
    return value;
  }
  
  /**
   * This method returns the next Node.
   * @return Node The next node (implemented for singly linked circular list fomat)
   */
  public Node<E> getNext(){
    return next;
  }
  
  /**
   * This method sets the next Node.
   * @param e The node to set as the next node.
   */
  public void setNext(Node<E> e){
    next = e;
  }
  
  /*
   *This method is used to compare values between Nodes; however, given it is unneccessary for the lab it was all commented out. 
   * 
   *public Integer compareNodes(Node other){
    String class1;
    String class2;
    try{
      class1 = this.getValue().getClass() + "";
      class2 = other.getValue().getClass() + "";
    }
    catch(NullPointerException e){
      return null;
    }
    Integer answer = null;
    if(class1.equals(class2)){
      if(class1.equals("class java.lang.Integer")){
        Integer val1 = (Integer) this.getValue();
        Integer val2 = (Integer) other.getValue();
        answer = val1 > val2 ? 1 : val1 < val2 ? -1 : 0;
      }
      else if(class1.equals("class java.lang.String")){
        String val1 = this.getValue() + "";
        String val2 = other.getValue() + "";
        answer = val1.compareTo(val2) > 0 ? 1 : val1.compareTo(val2) < 0 ? -1 : 0;
      }
    }
   return answer;
  }*/
  
}