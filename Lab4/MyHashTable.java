import java.util.LinkedList;
import java.util.ArrayList;

/**
 * This class creates a hash table MyHashTable which will be used experimentally in order to determine the best performance 
 * of a hash table in relationship to size and number of elements.
 * @author Craig Lombardo
 */
public class MyHashTable{
  
  protected LinkedList<Entry>[] buckets;
  private int bucketSize,numElements=0;
  private ArrayList<Integer> numInLL;
  
  /**
   * This constructor method creates a hash table of size n. It also instantiates an ArrayList which
   * will be used to determine how many elements are at a given index.
   * @param n The size of the hash table / ArrayList.
   */
  public MyHashTable(int n){
    buckets = new LinkedList[n];
    numInLL = new ArrayList<Integer>(n);
    
    for(int i=0; i<n; i++) numInLL.add(0);
    
    bucketSize = buckets.length;
    numElements=0;
  }
  
  /**
   * This method inserts an Entry into the hash table.
   * @param key The key of the given entry.
   * @param value The value of the given entry.
   * @return boolean Returns true if the element was inserted cleanly, false if there was a problem.
   */
  public boolean insert(Integer key, Integer value){
    
    try{
      int index = hash(key);
      
      if(buckets[index] == null) buckets[index] = new LinkedList<Entry>();
      
      buckets[index].add(0,new Entry(key, value));
      numInLL.set(index,numInLL.get(index)+1);
      numElements+=1;
      return true;
    }
    catch(Exception e){ 
      return false;
    }
  }
  
  /**
   * This method returns the Entry which corresponds to a given key, should it exist.
   * @param key The key of an Entry we are looking for
   * @return Entry The Entry with this given key value, if there is no Entry with this key then it returns null 
   */
  public Entry find(int key){
    int index = hash(key);
    LinkedList<Entry> listToSearch = buckets[index];
    
    if(listToSearch!=null){
      for(int i=0; i<listToSearch.size(); i++){
        Entry thisEntry = listToSearch.get(i);
        if(thisEntry.getKey()==key) return thisEntry;
      }
    }
    return null;
  }
  
  /**
   * This method hashes the key for use in the hash table.
   * @param keyVal The key we want to hash.
   * @return int The integer value corresponding to the hashed data.
   */
  public int hash(int keyVal){
    int returnVal = keyVal%bucketSize >= 0 ? keyVal%bucketSize : (keyVal%bucketSize) + bucketSize;
    return returnVal;
  }
  
  /**
   * This method returns a percentage corresponding to the load factor of the table.
   * @return double The load factor in percentage form.
   */
  public double getLoadFactor(){
    return (numElements*100.0)/bucketSize;
  }
  
  /**
   * This method returns the number of elements in the table.
   * @return int The number of elements in the array
   */
  public int getNumElements(){
    return numElements;
  }
  
  /**
   * This method searches through all indexes of the ArrayList numInLL to determine the maximum number of elements at a given index (max  of all).
   * @return int The maximum number of elements at an index.
   */
  public int returnMaxNumInLL(){
    int max = 0;
    for(int i=0; i<numInLL.size(); i++) if(numInLL.get(i) > max) max = numInLL.get(i);
    return max;
  }
  
}