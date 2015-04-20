import java.util.ArrayList;

/**
 * This class serves as an implementation of a 2-3 Tree. 
 * @author Craig Lombardo
 */
public class TwoThreeTree<K extends Number & Comparable<K>, E> extends AbstractTree<K,E>{
  
  private TwoThreeTreeNode root;
  private int size = 0;
  /**
   * This constructor creates a 2-3 Tree with a null root node.
   */
  public TwoThreeTree(){
    root = null;
  }
  
  /** This method adds the specified key/element to this set if it is not already present.
    * @param k The key of the element you are trying to add.
    * @param e The element you would like to add.
    * @return true if it was added, false if it already existed.
    */
  public boolean add(K k, E e){
    if(root == null){
      root = new TwoThreeTreeNode();
      root.setLeftInfo(k,e);
      size++;
      return true;
    }
    else{
      if(root.find(k,true)==null){
        root.find(k,false).add(k,e);
        size++;
        System.out.println("Inserting: " + k);
        root.printTree();
        ArrayList<E> ok = toArray();
        for(int i=0; i<ok.size(); i++) System.out.print(ok.get(i)+" ");
        System.out.println("\n");
        return true;
      }
      else return false;
    }
  }
  
  /**
   * This method removes all of the keys and elements from this set.
   */
  public void clear(){
    root = null;
    size =0;
  }
  
  /**
   * This method determines if the key is already present in the Tree.
   * @param k The key you are looking for.
   * @return true if this set contains the specified Key, false if not.
   */
  public boolean contains(K k){
    if(root == null) return false;
    else{
      return root.find(k, true) != null;
    }
  }
  
  /**
   * This method returns the first element (lowest key) currently in this set.
   * @return The first element in the set.
   */
  public E first(){
    if(root == null) return null;
    else{
      return root.getFirst();
    }
  }
  
  /**
   * This method returns the last element (highest key) currently in this set.
   * @return The last element in the set.
   */
  public E last(){
    if(root == null) return null;
    else{
      return root.getLast();
    }
  }
  
  /**
   * This method returns the number of elements in this set (its cardinality).
   * @return the number of elements in the set.
   */
  public int size(){
    return size;
  }
  
  /**
   * This method returns an ArrayList of elements in the order from least to greatest key.
   * @return The corresponding array in ascending order.
   */
  public ArrayList<E> toArray(){
    ArrayList<E> arr = getPartArray(root);
    return arr != null ? arr : new ArrayList<E>();
  }
  
  private ArrayList<E> getPartArray(TwoThreeTreeNode current){
    if(current != null){
      ArrayList<E> leftPart = getPartArray(current.getLeftNode());
      ArrayList<E> middlePart = getPartArray(current.getMiddleNode());
      ArrayList<E> rightPart = getPartArray(current.getRightNode());
      ArrayList<E> total = new ArrayList<E>();
      if(leftPart != null) for(int i=0; i<leftPart.size(); i++) total.add(leftPart.get(i));
      total.add(current.getLeftElement());
      if(middlePart != null) for(int i=0; i<middlePart.size(); i++) total.add(middlePart.get(i));
      if(current.getRightElement()!=null) total.add(current.getRightElement());
      if(rightPart != null) for(int i=0; i<rightPart.size(); i++) total.add(rightPart.get(i));
      return total;
    }
    else{
      return null;
    }
  }
  
  private class TwoThreeTreeNode{
    
    private TwoThreeTreeNode leftNode;
    private TwoThreeTreeNode rightNode;
    private TwoThreeTreeNode middleNode;
    private TwoThreeTreeNode tmpMiddleNode;
    
    private TwoThreeTreeNode parent;
    
    private K leftKey;
    private K rightKey;
    
    private E leftElement;
    private E rightElement;
    
    private TwoThreeTreeNode(){
      leftNode = null;
      rightNode = null;
      middleNode = null;
      tmpMiddleNode = null;
      
      parent = null;
      
      leftKey = null;
      rightKey = null;
      
      leftElement = null;
      rightElement = null;
    }
    
    private void add(K key, E data){
      //checks if there is only one key at this node
      //if so we simply add
      if(rightKey == null){
        if(leftKey.compareTo(key)<0){
          setRightInfo(key,data);
        }
        else{
          setRightInfo(leftKey, leftElement);
          setLeftInfo(key,data);
        }
      }
      //if not then we must figure out the proper action
      //from here on means that we could not just add the value
      else{
        K middleKey = key;
        E middleElement = data;
        //this shuffles the data to find a middle element and moves the other
        //values accordingly if need be
        if(key.compareTo(leftKey)<0){
          middleKey = leftKey;
          middleElement = leftElement;
          setLeftInfo(key,data);
        }
        else if(key.compareTo(rightKey)>0){
          middleKey = rightKey;
          middleElement = rightElement;
          setRightInfo(key,data);
        }
        
        //This is a check at the beginning of any add as we check if there is a restructure needed
        //i.e. there is a node with 4 children
        if(tmpMiddleNode != null){
          //split the current and push the middle up as the new root
          if(parent == null){
            parent = new TwoThreeTreeNode();
            parent.setLeftInfo(middleKey,middleElement);
            
            TwoThreeTreeNode newPRight = new TwoThreeTreeNode();
            newPRight.setLeftInfo(rightKey,rightElement);
            
            newPRight.setLeftNode(middleNode);
            newPRight.setRightNode(rightNode);
            
            middleKey = null;
            middleElement = null;
            
            setRightInfo(null,null); 
            
            rightNode = tmpMiddleNode;
            middleNode = null;
            tmpMiddleNode = null;
            
            parent.setLeftNode(this);
            parent.setRightNode(newPRight);
            root = parent;
          }
          //if it is not filled then things are, potentially, a bit easier.
          else{
            //if there is not currently a middle node then we can give it one upon aplitting
            if(parent.middleNode == null){
              TwoThreeTreeNode newNode = new TwoThreeTreeNode();
              newNode.setLeftInfo(rightKey,rightElement);
              if(rightKey.compareTo(parent.leftNode.getLeftKey())<0){
                parent.setMiddleNode(leftNode);
                leftNode.setParent(parent);
                parent.setLeftNode(newNode);
              }
              else if(rightKey.compareTo(parent.rightNode.getLeftKey())>0){
                parent.setMiddleNode(rightNode);
                rightNode.setParent(parent);
                parent.setRightNode(newNode);
              }
              else{
                parent.setMiddleNode(newNode);
                newNode.setParent(parent);
              }
              setRightInfo(null,null);
              parent.add(middleKey,middleElement);
            }
            else{
              //this method sets the temporary node on the parent by shifting, if
              //necessary, the parents children
              parent.addTmpNode(rightKey,rightElement);
              setRightInfo(null,null);
              parent.add(middleKey,middleElement);
            }
          }
        }
        //no restructure and no parent
        else if(parent == null){
          resetRoot(middleKey, middleElement);
        }
        //no restructure
        else{
          if(parent.middleNode == null){
            TwoThreeTreeNode newNode = new TwoThreeTreeNode();
            newNode.setLeftInfo(rightKey,rightElement);
            if(rightKey.compareTo(parent.rightNode.getLeftKey())>0){
              parent.setMiddleNode(parent.rightNode);

              parent.setRightNode(newNode);
            }
            else{
              parent.setMiddleNode(newNode);
            }
            newNode.setParent(parent);
            setRightInfo(null,null);
            parent.add(middleKey,middleElement);
          }
          else{
            //set the tmp node
            parent.addTmpNode(rightKey,rightElement);
            setRightInfo(null,null);
            parent.add(middleKey,middleElement);
          }
        }
      }
    }
    
    private void addTmpNode(K key, E element){
      if(key.compareTo(leftNode.getLeftKey())<0){
        tmpMiddleNode = leftNode;
        leftNode = new TwoThreeTreeNode();
        leftNode.setLeftInfo(key,element);
      }
      else if(key.compareTo(middleNode.getLeftKey())<0){
        tmpMiddleNode = new TwoThreeTreeNode();
        tmpMiddleNode.setLeftInfo(key,element);
      }
      else if(key.compareTo(rightNode.getLeftKey())<0){
        tmpMiddleNode = middleNode;
        middleNode = new TwoThreeTreeNode();
        middleNode.setLeftInfo(key,element);
      }
      else{
        tmpMiddleNode = middleNode;
        middleNode = rightNode;
        rightNode = new TwoThreeTreeNode();
        rightNode.setLeftInfo(key,element);
      }
    }
    
    private void resetRoot(K middleKey, E middleElement){
      parent = new TwoThreeTreeNode();
      parent.setLeftInfo(middleKey,middleElement);
      parent.setLeftNode(this);
      
      TwoThreeTreeNode newNode = new TwoThreeTreeNode();
      newNode.setLeftInfo(rightKey,rightElement);
      parent.setRightNode(newNode);
      newNode.setParent(parent);
      
      setRightInfo(null,null);
      
      root = parent;
    }
    
    private TwoThreeTreeNode find(K key, boolean find){
      if(find){
        if(leftKey.equals(key)) return this;
        else if(rightKey!=null && rightKey.equals(key)) return this;
      }
      boolean right = key.compareTo(leftKey)>0;
      boolean middle = right && rightKey!=null? key.compareTo(rightKey)<0 : false;
      
      int direction = 0;
      if(right) direction++;
      if(middle) direction++;
      if(direction == 0){
        if(leftNode != null) return leftNode.find(key, find);
        else return find ? null : this;
      }
      else if(direction == 1){
        if(rightNode != null) return rightNode.find(key, find);
        else return find ? null : this;
      }
      else{
        if(middleNode != null) return middleNode.find(key, find);
        else return find ? null : this;
      }
      
    }
    
    private TwoThreeTreeNode getLeftNode(){
      return leftNode;
    }
    
    private TwoThreeTreeNode getRightNode(){
      return rightNode;
    }
    
    private TwoThreeTreeNode getMiddleNode(){
      return middleNode;
    }
    
    private void setLeftNode(TwoThreeTreeNode other){
      leftNode = other;
    }
    
    private void setRightNode(TwoThreeTreeNode other){
      rightNode = other;
    }
    
    private void setMiddleNode(TwoThreeTreeNode other){
      middleNode = other;
    }
    
    private TwoThreeTreeNode getParent(){
      return parent;
    }
    
    private void setParent(TwoThreeTreeNode other){
      parent = other;
    }
    
    private void setLeftInfo(K key, E data){
      leftKey = key;
      leftElement = data;
    }
    
    private void setRightInfo(K key, E data){
      rightKey = key;
      rightElement = data;
    }
    
    private E getLeftElement(){
      return leftElement;
    }
    
    private E getRightElement(){
      return rightElement;
    }
    
    private K getLeftKey(){
      return leftKey;
    }
    
    private K getRightKey(){
      return rightKey;
    }
    
    private E getFirst(){
      if(leftNode == null) return leftElement;
      else return leftNode.getFirst();
    }
    
    private E getLast(){
      if(rightNode == null){
        if(rightElement!=null) return rightElement;
        else return leftElement;
      }
      else return rightNode.getLast();
    }
    
    private void printTree(){
      System.out.println(this.getPart("  "));
    }
    
    private String getPart(String current){
      String total = "";
      total = total + current + leftKey + "  " + rightKey+"\n" ;
      String leftPart = leftNode != null ? leftNode.getPart(current + current) : "";
      String middlePart = middleNode != null ? middleNode.getPart(current + current) : "";
      String rightPart = rightNode != null ? rightNode.getPart(current + current) : "";
      total = total + leftPart + middlePart + rightPart;
      return total;
    }
    
  }
  
  public static void main(String[] args){
    TwoThreeTree<Integer,Integer> test = new TwoThreeTree<Integer,Integer>();
    test.add(20,20);
    test.add(17,17);
    test.add(5,5);
    test.add(12,12);
    test.add(15,15);
    test.add(11,11);
    test.add(10,10);
    test.add(2,2);
    test.add(3,3);
    test.add(4,4);
    test.add(1,1);
  }
  
}