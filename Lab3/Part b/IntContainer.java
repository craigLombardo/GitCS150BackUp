import java.util.*;

/**
 * This class is the parent class for ArrayListIntContainer and LinkedListIntContainer.
 * The methods contained in this class can easily be used in both child classes.
 * @author Craig Lombardo
 */
public class IntContainer{
  
  /** This creates a protected AbstractList which can be made as either an ArrayList, or Linked List.*/
  protected AbstractList<Integer> data;
  
  /**
   * This constructor creates the parent class.
   */
  public IntContainer(){
  }
 
  /**
   * This method does as implies and adds an element to the front of a list.
   * @param element An Integer to add to the front of the data array.
   */
  public void addFromFront(Integer element){
    data.add(0,element);
  }
  
  /**
   * This method traverses the whole array and returns the second largest, non-unique, integer value.
   * @return int The second largest number in the array
   */
  public int findSecondLargest(){
    int first=0;
    int second = 0;
    for(int i = 0; i < data.size(); i++){
      int val = data.get(i);
      if(val > second){
        
        if(val > first){
          second = first;
          first = val;
        }
        else second = val;
      }
    }
    return second;
  }
}