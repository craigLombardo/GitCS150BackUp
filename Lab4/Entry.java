/**
 * This class creates an entry which stores a key and value.
 * @author Craig Lombardo
 */
public class Entry{
  
  private Integer key;
  private Integer value;
  
  /**
   * This constructor method creates an Entry with the stored key and value.
   * @param key The key for the certain Entry.
   * @param value The value for the certain Entry.
   */
  public Entry(Integer key, Integer value){
    this.key=key;
    this.value=value;
  }
  
  /**
   * This method returns the key value of the Entry.
   * @return Integer An integer value corresponding to the key value of the Entry.
   */
  public Integer getKey(){
    return key;
  }
  
}