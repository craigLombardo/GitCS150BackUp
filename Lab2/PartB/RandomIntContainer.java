import java.util.*;

public class RandomIntContainer{
  
  private ArrayList<Integer> myArrayList;
  
  public RandomIntContainer(int size){
    myArrayList = new ArrayList<Integer>(size);
  }
  
  public void addFromFront(Integer element){
    myArrayList.add(0,element);
  }
  
  public void addFromEnd(Integer element){
    myArrayList.add(element);
  }
  
  public void addSorted(Integer element){
    myArrayList.add(element);
    insertionSort();
  }
  
  //Adapted from http://www.mycstutorials.com/articles/sorting/insertionsort
  public void insertionSort(){
    int temp, pos;
    
    for (int i = 1; i < myArrayList.size(); i++){
      temp = myArrayList.get(i);
      pos = i - 1;
      
      while ((pos >= 0) && (temp < myArrayList.get(pos))){
        myArrayList.set(pos + 1,myArrayList.get(pos));
        pos--;
      }
      myArrayList.set(pos + 1,temp);
    }
  }  
  
  public ArrayList<Integer> returnMyArrayList(){
    return myArrayList;
  }
  
}