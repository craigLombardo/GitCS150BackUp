import junit.framework.TestCase;

public class RestaurantComparatorTest extends TestCase {
  
  public void testCompare(){
    RestaurantComparator comparator = new RestaurantComparator();
    
    Restaurant test1 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    Restaurant test2 = new Restaurant("Lombardos", "Park Ridge", "French", "2/17/1986", "1100", "2300");
    
    assertTrue(comparator.compare(test1,test2) > 0);
    assertTrue(comparator.compare(test2,test1) < 0);
    
    Restaurant test3 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1900", "2300");
    Restaurant test4 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1200", "2300");
    
    assertTrue(comparator.compare(test3,test4) > 0);
    assertTrue(comparator.compare(test4,test3) < 0);
    
    Restaurant test5 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    Restaurant test6 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "1300");
    
    assertTrue(comparator.compare(test5,test6) > 0);
    assertTrue(comparator.compare(test6,test5) < 0);
    
    Restaurant test7 = new Restaurant("Lombardos Pizza", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    Restaurant test8 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    
    assertTrue(comparator.compare(test7,test8) > 0); 
    assertTrue(comparator.compare(test8,test7) < 0);
    
    Restaurant test9 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    Restaurant test10 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    
    assertTrue(comparator.compare(test9,test10) == 0);
    
  }
  
  public void testCompareType(){
    RestaurantComparator comparator = new RestaurantComparator();
    
    Restaurant test1 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    Restaurant test2 = new Restaurant("Lombardos", "Park Ridge", "French", "2/17/1986", "1100", "2300");
    
    assertTrue(comparator.compareType(test1,test2) > 0);
    
    Restaurant test3 = new Restaurant("Lombardos", "Park Ridge", "French", "2/17/1986", "1100", "2300");
    Restaurant test4 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    
    assertTrue(comparator.compareType(test3,test4) < 0);
    
    Restaurant test5 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    Restaurant test6 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    
    assertTrue(comparator.compareType(test5,test6) == 0);
  }
  
  
  public void testCompareOpeningTime(){
    RestaurantComparator comparator = new RestaurantComparator();
    
    Restaurant test1 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1400", "2300");
    Restaurant test2 = new Restaurant("Lombardos", "Park Ridge", "French", "2/17/1986", "0900", "2300");
    
    assertTrue(comparator.compareOpeningTime(test1,test2) > 0);
    
    Restaurant test3 = new Restaurant("Lombardos", "Park Ridge", "French", "2/17/1986", "1100", "2300");
    Restaurant test4 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1800", "2300");
    
    assertTrue(comparator.compareOpeningTime(test3,test4) < 0);
    
    Restaurant test5 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    Restaurant test6 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    
    assertTrue(comparator.compareOpeningTime(test5,test6) == 0);
  }
  
  public void testCompareClosingTime(){
    RestaurantComparator comparator = new RestaurantComparator();
    
    Restaurant test1 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2000");
    Restaurant test2 = new Restaurant("Lombardos", "Park Ridge", "French", "2/17/1986", "1100", "1500");
    
    assertTrue(comparator.compareClosingTime(test1,test2) > 0);
    
    Restaurant test3 = new Restaurant("Lombardos", "Park Ridge", "French", "2/17/1986", "1100", "2300");
    Restaurant test4 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2400");
    
    assertTrue(comparator.compareClosingTime(test3,test4) < 0);
    
    Restaurant test5 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    Restaurant test6 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    
    assertTrue(comparator.compareClosingTime(test5,test6) == 0);
  }
  
  public void testCompareNames(){
    RestaurantComparator comparator = new RestaurantComparator();
    
    Restaurant test1 = new Restaurant("Lombardos Family Pizza", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    Restaurant test2 = new Restaurant("Lombardos", "Park Ridge", "French", "2/17/1986", "1100", "2300");
    
    assertTrue(comparator.compareNames(test1,test2) > 0);
    
    Restaurant test3 = new Restaurant("Lombardos", "Park Ridge", "French", "2/17/1986", "1100", "2300");
    Restaurant test4 = new Restaurant("Lombardos Cucina", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    
    assertTrue(comparator.compareNames(test3,test4) < 0);
    
    Restaurant test5 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    Restaurant test6 = new Restaurant("Lombardos", "Park Ridge", "Italian", "2/17/1986", "1100", "2300");
    
    assertTrue(comparator.compareNames(test5,test6) == 0);
  }
  
}
