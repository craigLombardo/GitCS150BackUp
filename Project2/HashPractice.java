import java.util.TreeSet;
import java.util.HashMap;

public class HashPractice{

  public static void main(String[] args){
    HashMap<String,String> test = new HashMap<String,String>();
    test.put("a","apple");
    test.put("boy", "bat");
    test.put("c","cow");
    
    System.out.println(test.get("boy"));
  }
}