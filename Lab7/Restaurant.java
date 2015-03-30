/**
 * This class creates a piece of data that will store information about a given
 * Restaurant. Through this class we can create instances of data that represent
 * different restaurants and allow for the comparison of multiple restaurants.
 * @author Craig Lombardo
 */
public class Restaurant{
  
  private String type;
  private String openingTime;
  private String closingTime;
  private String restName;
  private String city;
  private String dateOpened;
  
  /**
   * This constructor method creates an instance of Data that represents a Restaurant
   * and contains pertinant information about the Restaurant.
   * @param name The name of the Restaurant.
   * @param myCity The city the Restaurant is located in.
   * @param restType The type of Restaurant.
   * @param myDateOpened The date the Restaurant opened for business.
   * @param open The time the Restaurant opens.
   * @param close The time the Restaurant closes.
   */
  public Restaurant(String name, String myCity, String restType, String myDateOpened, String open, String close){
    type = restType;
    openingTime = open;
    closingTime = close;
    restName = name;
    city = myCity;
    dateOpened = myDateOpened;
  }
  
  /**
   * This method returns the type of the Restaurant.
   * @return String The type of the Restaurant.
   */
  public String getType(){
    return type;
  }
  
  /**
   * This method returns the opening time of the Restaurant.
   * @return String The opening time of the Restaurant.
   */
  public String getOpeningTime(){
    return openingTime;
  }
  
  /**
   * This method returns the closing time of the Restaurant.
   * @return String The closing time of the Restaurant.
   */
  public String getClosingTime(){
    return closingTime;
  }
  
  /**
   * This method returns the name of the Restaurant.
   * @return String The name of the Restaurant.
   */
  public String getName(){
    return restName;
  }
  
  /**
   * This method returns the city of the Restaurant.
   * @return String The city of the Restaurant.
   */
  public String getCity(){
    return city;
  }
 
  /**
   * This method returns the date the Restaurant opened.
   * @return String The date the Restaurant opened.
   */
  public String getDateOpened(){
    return dateOpened;
  }
}