import java.util.Comparator;

/**
 * This Comparator is used to impose a comparison of times on a given Recipe.
 * @author Craig Lombardo
 */
public class RecipeTreeTimeComparator implements Comparator<Recipe>{

  /**
   * This method compares two recipes based on their times.
   * @param one The first recipe.
   * @param two The second recipe.
   * @return A number less than zero if one is less than two, equal to zero if they
   * are the same, or greater than zero of one is greater than two. 
   */
  public int compare(Recipe one, Recipe two){
    return one.getName().compareTo(two.getName()) <=0 ? -1 : 1;
  }
  
}