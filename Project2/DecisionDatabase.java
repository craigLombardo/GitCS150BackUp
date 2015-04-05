import java.util.HashMap;
import java.util.ArrayList;

public class DecisionDatabase{
  
  private DecisionNode root;
  
  public DecisionDatabase(){
    root = new DecisionNode(null);
    root.makeDecisionTree(0,6);
  }
  
  //meat,seafood,dairy,vegan,vegetarian,shellfish 
    private HashMap<String,ArrayList<ArrayList<ArrayList<Recipe>>>> makeDecisions(boolean meat, boolean seafood, boolean dairy, boolean vegan, boolean vegetarian, boolean shellfish){
      DecisionNode current = root;
      current = meat ? current.getLeft() : current.getRight();
      current = seafood ? current.getLeft() : current.getRight();
      current = dairy ? current.getLeft() : current.getRight();
      current = vegan ? current.getLeft() : current.getRight();
      current = vegetarian ? current.getLeft() : current.getRight();
      current = shellfish ? current.getLeft() : current.getRight();
      return current.getMap();
    }
  
  //meat,seafood,dairy,vegan,vegetarian,shellfish 
  private class DecisionNode{
    
    private HashMap<String,ArrayList<ArrayList<ArrayList<Recipe>>>> myMap;
    private DecisionNode left, right;
    
    private DecisionNode(HashMap<String,ArrayList<ArrayList<ArrayList<Recipe>>>> map){
      myMap = map;
    }
    
    private void makeDecisionTree(int current, int max){
      if(current >= max-1){
        left = new DecisionNode(new HashMap<String,ArrayList<ArrayList<ArrayList<Recipe>>>>());
        right = new DecisionNode(new HashMap<String,ArrayList<ArrayList<ArrayList<Recipe>>>>());
        ArrayList<String> ingredients = new FoodRules().getIngredients();
        for(int i=0; i<ingredients.size(); i++){
          left.getMap().put(ingredients.get(i),new ArrayList<ArrayList<ArrayList<Recipe>>>());
          right.getMap().put(ingredients.get(i),new ArrayList<ArrayList<ArrayList<Recipe>>>());
        }
      }
      else{
        left = new DecisionNode(null);
        right = new DecisionNode(null);
        left.makeDecisionTree(current+1,max);   
        right.makeDecisionTree(current+1,max); 
      }
    }
    
    private DecisionNode getLeft(){
      return left;
    }
    
    private DecisionNode getRight(){
      return right;
    }
    
    private HashMap<String,ArrayList<ArrayList<ArrayList<Recipe>>>> getMap(){
      return myMap;
    }
  }
  
  public static void main(String[] args){
    DecisionDatabase test = new DecisionDatabase();
    System.out.println(test.makeDecisions(true,false,true,true,true,true));
  }
}