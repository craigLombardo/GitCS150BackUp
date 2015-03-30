import java.util.ArrayList;

/**
 * This class will create an instance of the Bar which has the full functionality of Seating
 */
public class Bar extends Seating{

  /**
   * This constructor takes a parameter of what restaurant it is in, it sets the tableType, 
   * numberOfSeatsAvailable = 20, and instantiates the array which controls what customers are seated where.
   * @param where The Restaurant the Bar is in.
   */
  public Bar(Restaurant where){
    numberOfSeatsAvailable = 20;
    tableType = "bar";
    myRest = where;
    availableSeating = new ArrayList<Customer>(numberOfSeatsAvailable);
    for(int j=0; j < numberOfSeatsAvailable; j++){
      availableSeating.add(null);
    }
  }

}