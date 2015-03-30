import java.util.AbstractList;
import java.util.ArrayList;

/**
 * This class acts as the parent class for sorted lists that are sorted by insertion sort.
 * This class implements the SortedList interface.
 * @author Craig Lombardo
 */
public class InsertionSortData implements SortedList{
  
  protected AbstractList<Integer> list;
  
  /**
   * This method will implement insertion sort, sorting a list called list. 
   * Code adapted from http://java2novice.com/java-interview-programs/insertion-sort/
   */
  public void insertionSort(){
    int n = list.size();
    for (int j = 1; j < n; j++){
      Integer key = list.get(j);
      int i = j-1;
      while ((i > -1) && ((int) list.get(i)>key)){
        list.set(i+1,list.get(i));
        i--;
      }
      list.set(i+1,key);
    }
  }
  
  /**
   * This method adds an Integer to the end of the list.
   * @param e The Integer to add to the end of the list.
   */
  public void addElement(Integer e){
    list.add(e);
  }
  
  /**
   * This method iterates through the entire list printing each element on their own line.
   */
  public void printData(){
    for(int i=0; i<list.size(); i++){
      System.out.print(list.get(i) + " ");
    }
    System.out.println();
  }
  
  /**
   * This method returns the size of the list
   * @return int The size of the list
   */
  public int size(){
    return list.size();
  }
  
/**
 * This method compares the value at an index to a value to see if they are equivalenet. This is done to keep the information within private.
 * @param index The index to compare.
 * @param value The value to compare the index value to.
 */
  public boolean compareTo(int index, int value){
    return list.get(index)==value;
  }

}