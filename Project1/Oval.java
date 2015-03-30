import java.util.ArrayList;

/**
 * This class will create an instance of the Bar which has the full functionality of Seating
 */
public class Oval extends Seating{

  /**
   * This constructor takes a parameter of what restaurant it is in, it sets the tableType,
   * numberOfSeatsAvailable = 30, and instantiates the array which controls what customers are seated where
   * @param where The Restaurant the seating option is in.
   */
  public Oval(Restaurant where){
    numberOfSeatsAvailable = 30;
    tableType = "oval";
    myRest = where;
    availableSeating = new ArrayList<Customer>(numberOfSeatsAvailable);
    for(int j=0; j < numberOfSeatsAvailable; j++){
      availableSeating.add(null);
    }
  }

}