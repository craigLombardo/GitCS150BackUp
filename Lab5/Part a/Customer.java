/**
 * This class creates a "customer", hence the class name Customer, that will store an id and arrival time.
 * @author Craig Lombardo
 */
public class Customer{
  
  private String id;
  private int arrivalTime;
  
  /**
   * The constructor method creates the customer with a given id and time.
   * @param id The id associated with this Customer.
   * @param time The time the customer has arrived.
   */
  public Customer(String id, int time){
    this.id=id;
    this.arrivalTime=time;
  }
  
  /**
   * This method returns the Customers arrival time.
   * @return int The arrival time of the Customer.
   */
  public int getArrivalTime(){
    return arrivalTime;
  }
}