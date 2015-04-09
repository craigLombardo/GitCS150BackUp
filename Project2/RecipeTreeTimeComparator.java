import java.util.Comparator;

public class RecipeTreeTimeComparator implements Comparator<Recipe>{

  public int compare(Recipe one, Recipe two){
   int time1 = (one.getPrepTime() + one.getCookTime());
   int time2 = (two.getPrepTime() + two.getCookTime());
   if(time1 == time2) return (one.getName().compareTo(two.getName())) > 0 ? 1 : -1; 
   else return  time1 > time2 ? 1 : -1;
  }
  
}