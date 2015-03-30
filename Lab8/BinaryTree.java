import java.lang.Number;
import java.lang.Comparable;
import java.util.ArrayList;

/**
 * This class serves as a BinaryTree. It will store information, an element, based
 * on a comparable Number (it's key). 
 * @author Craig Lombardo
 */
public class BinaryTree<K extends Number & Comparable<K>, E>{
  
  private BinaryTreeNode root;
  private int total=0;
  /**
   * This constructor creates an instance of a BinaryTree with a null root.
   */
  public BinaryTree(){
    root = null;
  }
  
  /**
   * This method adds a specified key/element to the BinaryTree if it is not already there. If the
   * key is not present then the new element will be added and the method will return true, if it
   * @param key The comparable Number that serves as the elements key.
   * @param element The information stored in the node.
   * @return<ul>
   * <li>true - if the key/element were added.</li>
   * <li>false - if the key was already present.</li>
   * </ul>
   */
  public boolean add(K key, E element){
    if(root == null){
      root = new BinaryTreeNode(key,element);
      total++;
      return true;
    }
    else{
      return findSpot(key,element,root);
    }
  }
  
  private boolean findSpot(K key, E element, BinaryTreeNode current){
    if(key.compareTo(current.getKey()) == 0) return false;
    else{
      boolean left = key.compareTo(current.getKey()) < 0;
      BinaryTreeNode nextNode = left ? current.getLeftNode() : current.getRightNode();
      if(nextNode == null){
        if(left) current.setLeftNode(new BinaryTreeNode(key,element));
        else current.setRightNode(new BinaryTreeNode(key,element));
        total++;
        return true;
      }
      else{
        return findSpot(key,element,nextNode);
      }
    }
  }
  
  /**
   * This method removes all of the keys and elements from the BinaryTree.
   */
  public void clear(){
    total=0;
    root = null;
  }
  
  /**
   * This method determines whether or not the BinaryTree contains the key.
   * @param key The key value you would like to find.
   * @return <ul>
   * <li>true - if the key was found in the BinaryTree.</li>
   * <li>false - if the key was not founf in the BinaryTree.</li>
   * </ul>
   */
  public boolean contains(K key){
    return findKey(key,root) != null;
  }
  
  private BinaryTreeNode findKey(K key, BinaryTreeNode current){
    if(current == null) return null;
    else if(current.getKey().compareTo(key) == 0) return current;
    else{
      boolean left = key.compareTo(current.getKey()) < 0;
      BinaryTreeNode nextNode = left ? current.getLeftNode() : current.getRightNode();
      return findKey(key, nextNode);
    }
  }
  
  /**
   * This method returns the first element in this BinaryTree (lowest key value).
   * @return <ul>
   * <li>The first element in the BinaryTree.</li>
   * </ul>
   */
  public E first(){
    if(root == null) return null;
    else return findFirst(root).getElement();
  }
  
  private BinaryTreeNode findFirst(BinaryTreeNode current){
    BinaryTreeNode next = current.getLeftNode();
    if(next == null) return current;
    else return findFirst(next);
  }
  
  /**
   * This method returns the last element in the BinaryTree (highest key).
   * @return <ul>
   * <li>The last element in the BinaryTree.</li>
   * </ul>
   */
  public E last(){ //-- Returns the last element (highest key) currently in this set.
    if(root == null) return null;
    return findLast(root).getElement();
  }
  
  private BinaryTreeNode findLast(BinaryTreeNode current){
    BinaryTreeNode next = current.getRightNode();
    if(next == null) return current;
    else return findLast(next);
  }
  
  /**
   * This method removes the node with the key value passed in, if it is in the BinaryTree.
   * @param key The key associated with the element we are deleting.
   * @return <ul>
   * <li>true - if the key/element were present/removed successfully.</li>
   * <li>false - if the key/element were not present or not removed successfully.</li>
   * </ul>
   */
  public boolean remove(K key){
    if(contains(key)){
      removeNode(key,root);
      total--;
      return true;
    }
    else{
      return false;
    }
  }
  
  private void removeNode(K key, BinaryTreeNode current){
    boolean left = key.compareTo(current.getKey()) < 0;
    BinaryTreeNode nextNode = left ? current.getLeftNode() : current.getRightNode();
    if(current.getKey().compareTo(key) == 0){
      BinaryTreeNode rightNode = current.getRightNode();
      BinaryTreeNode leftNode = current.getLeftNode();
      if(rightNode!=null){
        BinaryTreeNode first = popFirst(findFirst(rightNode).getKey(),rightNode);
        if(first == rightNode){
          current.setInfoTo(first);
          current.setRightNode(rightNode.getRightNode());
        }
        else current.setRightNode(first);
      }
      else if(leftNode!=null){
        BinaryTreeNode nextRightNode = leftNode.getRightNode();
        if(nextRightNode != null){
          BinaryTreeNode first = popFirst(findFirst(nextRightNode).getKey(),nextRightNode);
        if(first == nextRightNode){
          current.setInfoTo(first);
          current.setRightNode(nextRightNode.getRightNode());
          leftNode.setRightNode(null);
        }
        else current.setRightNode(first);
        }
        else{
          current.setInfoTo(leftNode);
          current.setLeftNode(leftNode.getLeftNode());
        }
      }
      else{
        root = null;
      }
    }
    else if(nextNode.getKey().compareTo(key) == 0 && nextNode.getLeftNode() == null && nextNode.getRightNode() == null){
      if(left) current.setLeftNode(null);
      else current.setRightNode(null);
    }
    else removeNode(key,nextNode);
  }
  
  private BinaryTreeNode popFirst(K first, BinaryTreeNode current){
    BinaryTreeNode next = current.getLeftNode();
    if(current.getKey().compareTo(first) == 0) return current;
    //if(next == null) return current;
    else if(next.getKey().compareTo(first) == 0){
      current.setLeftNode(null);
      return next;
    }
    else return findFirst(next);
  
  }
  
  /**
   * This method returns the number of elements in the BinaryTree.
   * @return <ul>
   * <li>An integer corresponding to the number of elements in the BinaryTree.</li>
   * </ul>
   */
  public int size(){
    return total;
  }
  
  /**
   * This method returns an ArrayList of the elements from least to greatest key value.
   * @return <ul>
   * <li>An ArrayList containing all elements in the BinaryTree in ascending order, according
   * to the key values.</li>
   * </ul>
   */
  public ArrayList<E> toArray(){
    ArrayList<E> arr = getPartArray(root);
    return arr != null ? arr : new ArrayList<E>();
  }
  
  private ArrayList<E> getPartArray(BinaryTreeNode current){
    if(current != null){
      ArrayList<E> leftPart = getPartArray(current.getLeftNode());
      ArrayList<E> rightPart = getPartArray(current.getRightNode());
      ArrayList<E> total = new ArrayList<E>();
      if(leftPart != null) for(int i=0; i<leftPart.size(); i++) total.add(leftPart.get(i));
      total.add(current.getElement());
      if(rightPart != null) for(int i=0; i<rightPart.size(); i++) total.add(rightPart.get(i));
      return total;
    }
    else{
      return null;
    }
  }
  
  /**
   * This class acts as the nodes for the BinaryTree. Each node has a key and element,
   * as well as a pointer as to which node, or null, is to it's left or right.
   */
  private class BinaryTreeNode{
    
    private K myKey;
    private E myElement;
    private BinaryTreeNode leftNode = null;
    private BinaryTreeNode rightNode = null;
    
    /**
     * The constructor method creates a node with the specified key and element.
     * @param key The key value of the node.
     * @param element The element of the node.
     */
    private BinaryTreeNode(K key, E element){
      myKey = key;
      myElement = element;
    }
    
    /**
     * This method sets the left node to the given parameter.
     * @param node The node you want to be left of the current node.
     */
    private void setLeftNode(BinaryTreeNode node){
      leftNode = node;
    }
    
    /**
     * This method sets the right node to the given parameter.
     * @param node The node you want to be right of the current node.
     */
    private void setRightNode(BinaryTreeNode node){
      rightNode = node;
    }
    
    /**
     * This method gets the node to the left of the current node.
     * @return The node to the left of the current node.
     */
    private BinaryTreeNode getLeftNode(){
      return leftNode;
    }
    
    /**
     * This method gets the node to the right of the current node.
     * @return The node to the right of the current node.
     */
    private BinaryTreeNode getRightNode(){
      return rightNode;
    }
    
    /**
     * This method returns the key value of the node.
     * @return K The key value of the node.
     */
    private K getKey(){
      return myKey;
    }
    
    /**
     * This method returns the element of the node.
     * @return E The node element value.
     */
    private E getElement(){
      return myElement;
    }
    
    /**
     * This method sets the information of this node to the info of another (key and element).
     * @param other The other node to set the current node information to.
     */
    private void setInfoTo(BinaryTreeNode other){
      myKey = other.getKey();
      myElement = other.getElement();
    }
    
  } 
  
}