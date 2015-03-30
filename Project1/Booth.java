import java.util.ArrayList;

/**
 * This class will create an instance of the Bar which has the full functionality of Seating
 */
public class Booth extends Seating{

  /**
   * This constructor takes a parameter of what restaurant it is in, it sets the tableType,
   * numberOfSeatsAvailable = 8, and instantiates the array which controls what customers are seated where
   * @param where The Restaurant the seating option is in.
   */
  public Booth(Restaurant where){
    numberOfSeatsAvailable = 8;
    tableType = "booth";
    myRest = where;
    availableSeating = new ArrayList<Customer>(numberOfSeatsAvailable);
    for(int j=0; j < numberOfSeatsAvailable; j++){
      availableSeating.add(null);
    }
  }

}