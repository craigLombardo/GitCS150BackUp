import java.util.ArrayList;

public class TestList{

  ArrayList<String> pleaseWork, two;
  ArrayList<ArrayList<String>> holder;
  
  public TestList(){
    holder = new ArrayList<ArrayList<String>>();
    pleaseWork = new ArrayList<String>();
    two = new ArrayList<String>();
    
    pleaseWork.add("testing");
    pleaseWork.add("staying here");
    two.add("Me too");
    holder.add(pleaseWork);
    holder.add(two);
    holder.get(0).add("test 3");
  }
  
  public void rem(){
    pleaseWork.remove("testing");
  }
  
  public static void main(String[] args){
    TestList test = new TestList();
    System.out.println(test.holder);
    test.rem();
    System.out.println(test.holder);
    
    for(int i=1; i<=20; i++) System.out.println(i);
  }
  
}