import java.util.HashMap;
import java.util.TreeMap;

public class HashPractice{

  public static void main(String[] args){
    TreeMap<String,Recipe> test = new TreeMap<String,Recipe>();
    Recipe tmp = new Recipe("","","","","","",9,9);
    test.put("a",tmp);
    test.put("b",tmp);
    System.out.println(test);
    System.out.println(test.remove("a"));
  }
}