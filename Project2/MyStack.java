import java.util.LinkedList;

public class MyStack<E>{

  private LinkedList<E> stack;
  
  public MyStack(){
    stack = new LinkedList<E>();
  }
  
  public void add(E element){
    stack.add(element);
  }
  
  public E getLast(){
    return stack.peekLast();
  }
}