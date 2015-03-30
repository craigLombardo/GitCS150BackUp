import java.util.AbstractList;
import java.util.ArrayList;

public class ShellSortData implements SortedList{
  
  protected AbstractList<Integer> list;
  
  /**
   * This method will implement a shell sort, sorting a list called list. 
   * Code adapted from http://rosettacode.org/wiki/Sorting_algorithms/Shell_sort
   */
  public void shellSort(){
    int increment = list.size() / 2;
    while (increment > 0) {
      for (int i = increment; i < list.size(); i++) {
        int j = i;
        int temp = list.get(i);
        while (j >= increment && list.get(j - increment) > temp) {
          list.set(j, list.get(j - increment));
          j = j - increment;
        }
        list.set(j, temp);
      }
      if (increment == 2) {
        increment = 1;
      } else {
        increment *= (5.0 / 11);
      }
    }
  }
  
  /**
   * This method adds an element to the end of the list.
   * @param e The Integer to be added to the end of the list.
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
   * This method returns the size of the list.
   * @return int The size of the list
   */
  public int size(){
    return list.size();
  }
  
  /**
   * This method returns an element at a specified point in the list
   * @return Integer The element at the specified index
   * @param index The index of the element you want to retrieve.
   */
  public Integer get(int index){
    return list.get(index);
  }
  
  /**
   * This method compares the value at an index to a value to see if they are equivalenet. 
   * This is done to keep the information within private.
   * @param index The index to compare.
   * @param value The value to compare the index value to.
   */
  public boolean compareTo(int index, int value){
    return list.get(index)==value;
  }

}