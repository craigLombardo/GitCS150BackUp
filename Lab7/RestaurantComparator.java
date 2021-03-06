import java.util.Comparator;

/**
 * This class is intended to aid in comparing restaurants and 
 * their different data.
 * @author Craig Lombardo
 */
public class RestaurantComparator implements Comparator<Restaurant>{
  
  /**
   * This method compares restaurants with the highest priority being type,
   * then opening time, closing time, and finally Restaurant name. If rest1 should be sorted
   * after rest 2 then 1 is returned, if it should be sorted after then -1 is returned, if they
   * are the same then 0 is returned.
   * @param rest1 The first Restaurant to compare.
   * @param rest2 The second Restaurant to compare.
   * @return int The integer corresponding to it's sorting position.
   */
  public int compare(Restaurant rest1, Restaurant rest2){
    int typeAnswer = compareType(rest1, rest2);
    if(typeAnswer != 0) return typeAnswer > 0 ? 1 : -1;
    else{
      int openAnswer = compareOpeningTime(rest1, rest2);
      if(openAnswer != 0) return openAnswer > 0 ? 1 : -1;
      else{
        int closeAnswer = compareClosingTime(rest1, rest2);
        if(closeAnswer != 0) return closeAnswer > 0 ? 1 : -1;
        else{
          int nameAnswer = compareNames(rest1, rest2);
          if(nameAnswer == 0) return 0;
          else return nameAnswer > 0 ? 1 : -1;
        }
      }
    }
  }
  
  /**
   * This method compares restaurant types, if rest1 should be sorted
   * after rest 2 then an integer greater than 0 is returned, if it 
   * should be sorted before then a negative integer less than 0 is returned, 
   * if they are the same then 0 is returned. (Ascending order)
   * @param rest1 The first Restaurant to compare.
   * @param rest2 The second Restaurant to compare.
   * @return int The integer corresponding to it's sorting position.
   */
  public int compareType(Restaurant rest1, Restaurant rest2){
    String type1 = rest1.getType();
    String type2 = rest2.getType();
    
    return type1.compareTo(type2);
  }
  
  /**
   * This method compares restaurant opening times, if rest1 should be sorted
   * after rest 2 then an integer greater than 0 is returned, if it 
   * should be sorted before then a negative integer less than 0 is returned, 
   * if they are the same then 0 is returned. (Ascending order)
   * @param rest1 The first Restaurant to compare.
   * @param rest2 The second Restaurant to compare.
   * @return int The integer corresponding to it's sorting position.
   */
  public int compareOpeningTime(Restaurant rest1, Restaurant rest2){
    String open1 = rest1.getOpeningTime();
    String open2 = rest2.getOpeningTime();
    
    return open1.compareTo(open2);
  }
  
  /**
   * This method compares restaurant closing times, if rest1 should be sorted
   * after rest 2 then an integer greater than 0 is returned, if it 
   * should be sorted before then a negative integer less than 0 is returned, 
   * if they are the same then 0 is returned. (Ascending order)
   * @param rest1 The first Restaurant to compare.
   * @param rest2 The second Restaurant to compare.
   * @return int The integer corresponding to it's sorting position.
   */
  public int compareClosingTime(Restaurant rest1, Restaurant rest2){
    String close1 = rest1.getClosingTime();
    String close2 = rest2.getClosingTime();
    
    return close1.compareTo(close2);
  }
  
  /**
   * This method compares restaurant names, if rest1 should be sorted
   * after rest 2 then an integer greater than 0 is returned, if it 
   * should be sorted before then a negative integer less than 0 is returned, 
   * if they are the same then 0 is returned. (Ascending order)
   * @param rest1 The first Restaurant to compare.
   * @param rest2 The second Restaurant to compare.
   * @return int The integer corresponding to it's sorting position.
   */
  public int compareNames(Restaurant rest1, Restaurant rest2){
    String name1 = rest1.getName();
    String name2 = rest2.getName();
    
    return name1.compareTo(name2);
  }
  
}