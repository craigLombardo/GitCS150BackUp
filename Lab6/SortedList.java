/**
 * This Interface is for sorted, or to be sorted lists. The required
 * methods entail a method to add elements, and a method to print the
 * data within the list.
 */
public interface SortedList{

  /**
   * This method adds elements to the end of the list.
   * @param element The Integer to add to the end of the list.
   */
  void addElement(Integer element);
  
  /**
   * This method iterates through the list and prints all of the data.
   */
  void printData();
  
  int size();
  
  boolean compareTo(int index, int value);
  
}