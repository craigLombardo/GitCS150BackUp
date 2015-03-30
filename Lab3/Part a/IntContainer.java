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
   * Adds an Integer to the beginning of the data array.
   * @param element The Integer value to be added to the front of the array.
   */
  public void addFromFront(Integer element){
    data.add(0,element);
  }
  
  /**
   * Adds an Integer into it's ascending order sorted position.
   * @param element The Integer to add into the array at it's sorted position.
   */
  public void addSorted(Integer element){
    data.add(element);
    insertionSort();
  }
  
  /** This method is called from within the addSorted method; it is used to sort the array.
    * Code adapted from http://www.mycstutorials.com/articles/sorting/insertionsort
    */
  public void insertionSort(){
    int temp, pos;
    
    for (int i = 1; i < data.size(); i++){
      temp = data.get(i);
      pos = i - 1;
      
      while ((pos >= 0) && (temp < data.get(pos))){
        data.set(pos + 1,data.get(pos));
        pos--;
      }
      data.set(pos + 1,temp);
    }
  }
  
}