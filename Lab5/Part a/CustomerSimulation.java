/**
 * This class acts like a restaurant, receiving new customers periodically,
 * putting Customers in a queue and then removing them.
 */
public class CustomerSimulation{
  
  LineQueue<Customer> customerQueue;
  RandomRange arrival, departure;
  private int customerCount=0;
  public int nextGroupArrivalTime = 0, nextGroupDepartTime = 0;
  private boolean printLine;
  
  /**
   * This constructor method instantiates the the LineQueue customerQueue,
   * and creates two random number generators arrival and departure. These are used
   * to control when customers enter and leave the restaurant.
   */
  public CustomerSimulation(){
    customerQueue = new LineQueue<Customer>();
    arrival = new RandomRange(1,10);
    departure = new RandomRange(5,15);
  }
  
  /**
   * This method essentially runs the simulation for a given amount of time. Controling when
   * new customers arrive and when current customers leave.
   * @param closingTime The closing time for the restaurant, restaurant opens at time = 0.
   */
  public void openTil(int closingTime){
    nextGroupArrivalTime = arrival.getRandomTime();
    nextGroupDepartTime = departure.getRandomTime();
    for(int time=0; time<=closingTime; time++){
      printLine = checkArrival(nextGroupArrivalTime,time);
      checkDeparture(nextGroupDepartTime,time);
      if(printLine) System.out.println();
    }
    System.out.println("Restaurant Closed");
  }
  
  /**
   * This method checks to see if there has been a new group that has arrived.
   * @param arrivalTime The next customer arrival time.
   * @param time The current time.
   * @return boolean A boolean representing whether or not a group has arrived at this time. 
   * (useful for the classes printLine variable, nothing more than aesthetics though)
   */
  public boolean checkArrival(int arrivalTime, int time){
    if(arrivalTime == time){
        customerCount++;
        customerQueue.offer(new Customer("Customer"+customerCount,time));
        System.out.print("new customer arrived at "+time+", ");
        nextGroupArrivalTime = time + arrival.getRandomTime();
        return true;
      }
    else return false;
  }
  
  /**
   * This method checks to see if there has been a group that has left.
   * @param departTime The time for the next customer to leave.
   * @param time The current time.
   */
  public void checkDeparture(int departTime, int time){
    if(departTime == time){
      Customer tmp = customerQueue.poll();
      System.out.print("it is now: " + time+", ");
      if(tmp != null) System.out.println("customer who arrived at: "+tmp.getArrivalTime()+" has left,");
      else System.out.println("There are no customers in the Queue,");
      nextGroupDepartTime = time + departure.getRandomTime();
      printLine = false;
      }
  }
  
  public static void main(String[] args){
    CustomerSimulation restaurant = new CustomerSimulation();
    restaurant.openTil(100); 
  }
}