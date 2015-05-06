/**
 * This class serves as a Restaurant.
 * @author Craig Lombardo
 */
public class Restaurant{
  
  private String myName;
  
  /**
   * This constructor creates a new Restaurant with a given name.
   * @param name The name of the new Restaurant.
   */
  public Restaurant(String name){
    myName = name;
  }
  
  /**
   * This method returns the name of the Restaurant.
   * @return The name of the Restaurant.
   */
  public String getName(){
    return myName;
  }
  
}