import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class TreeSetContainer<K,E> extends AbstractTree<K,E>{
  
  private TreeMap<K,E> cont;
  
  public TreeSetContainer(){
    cont = new TreeMap<K,E>();
  }
  
  /** This method adds the specified key/element to this set if it is not already present.
    * @param k The key of the element you are trying to add.
    * @param e The element you would like to add.
    * @return true if it was added, false if it already existed.
    */
  public boolean add(K k, E e){
    if(!cont.containsKey(k)){
      cont.put(k,e);
      return true;
    }
    return false;
  }
  
  /**
   * This method removes all of the keys and elements from this set.
   */
  public void clear(){
    cont.clear();
  }
  
  /**
   * This method determines if the key is already present in the Tree.
   * @return true if this set contains the specified Key, false if not.
   */
  public boolean contains(K k){
    return cont.containsKey(k);
  }
  
  /**
   * This method returns the first element (lowest key) currently in this set.
   * @return The first element in the set.
   */
  public E first(){
    return cont.get(cont.firstKey());
  }
  
  /**
   * This method returns the last element (highest key) currently in this set.
   * @return The last element in the set.
   */
  public E last(){
    return cont.get(cont.lastKey());
  }
  
  /**
   * This method returns the number of elements in this set (its cardinality).
   * @return the number of elements in the set.
   */
  public int size(){
    return cont.size();
  }
  
  /**
   * This method returns an ArrayList of elements in the order from least to greatest key.
   * @return The corresponding array in ascending order.
   */
  public ArrayList<E> toArray(){
    ArrayList<E> arr = new ArrayList<E>();
    Iterator<Map.Entry<K,E>> it = cont.entrySet().iterator();
    while (it.hasNext()){
      Map.Entry<K,E> pair = (Map.Entry<K,E>) it.next();
      E current = (E) pair.getValue();
      arr.add(current);
      it.remove();
    }
    return arr != null ? arr : new ArrayList<E>();
  }
  
}