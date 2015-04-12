import java.util.Comparator;

public class RecipeTreeNameComparator implements Comparator<Recipe>{

  public int compare(Recipe one, Recipe two){
   return one.getName().compareTo(two.getName());
  }
  
}