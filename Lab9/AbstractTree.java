import java.util.ArrayList;

/**
 * This abstract class serves as a means of setting a list of necessary methods for different trees.
 * @author Craig Lombardo
 */
public abstract class AbstractTree<K, E>{
  
  /** This method adds the specified key/element to this set if it is not already present.
    * @param k The key of the element you are trying to add.
    * @param e The element you would like to add.
    * @return true if it was added, false if it already existed.
    */
  abstract boolean add(K k, E e);
  
  /**
   * This method removes all of the keys and elements from this set.
   */
  abstract void clear();
  
  /**
   * This method determines if the key is already present in the Tree.
   * @param k The key you are looking for.
   * @return true if this set contains the specified Key, false if not.
   */
  abstract boolean contains(K k);
  
  /**
   * This method returns the first element (lowest key) currently in this set.
   * @return The first element in the set.
   */
  abstract E first();
  
  /**
   * This method returns the last element (highest key) currently in this set.
   * @return The last element in the set.
   */
  abstract E last();
  
  /**
   * This method returns the number of elements in this set (its cardinality).
   * @return the number of elements in the set.
   */
  abstract int size();
  
  /**
   * This method returns an ArrayList of elements in the order from least to greatest key.
   * @return The corresponding array in ascending order.
   */
  abstract ArrayList<E> toArray();
  
}