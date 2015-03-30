import java.util.ArrayList;

/**
 * This class acts as the clock for the Restaurant. It is important to note that this 
 * clock only processes timed events, it does not keep time.
 * @author Craig Lombardo
 */
public class TimedEvents{
  
  private Restaurant myRest; //The Restaurant the timer is in
  //These are RandomGaussian number generators to calculate random arrival times
  private RandomGaussian smallArrival, largeArrival;
  private Wheel newSize; //calculates random sizes
  private int nextSmallGroupTime, nextLargeGroupTime;
  private int closeTime;
  
  /**
   * This construcor method instantiates the RandomGaussian number generators for small
   * and large groups. It also sets the Restaurant the timed events will be dealing with,
   * and sets the initial arrival times.
   * @param where The Restaurant we are dealing with.
   */
  public TimedEvents(Restaurant where){
    myRest = where;
    closeTime = where.getCloseTime();
    
    smallArrival = new RandomGaussian(20,10);
    largeArrival = new RandomGaussian(30,15);
    
    nextSmallGroupTime = smallArrival.getNext(); 
    nextLargeGroupTime = largeArrival.getNext();
    
    newSize = new Wheel(6932173,4);
    
  }
  
  /**
   * This method checks to see if anyone is done eating, if so it removes them from the 
   * seated list and their table.
   * @param thisTime The current uptime of the Restaurant.
   */
  public void whosDone(int thisTime){
    ArrayList<Customer> seated = myRest.getSeatedList();
    ArrayList<Integer> bye = new ArrayList<Integer>();
    
    //Checks every seat to see if a customers depart time is the current time
    for(int i = 0; i < seated.size();i++){
      if(seated.get(i).getDepartTime() == thisTime){
        bye.add(i); //adds to an array which keeps track of all Customers who are going to leave
      }
    }
    //Iterates through the bye ArrayList and removes every person in the array from the seated list,
    //and from their respective table
    for(int j=bye.size()-1; j>=0; j--){  
      Customer adios = seated.get(bye.get(j));
      myRest.removeSeatedGroup(adios);
      adios.printResults();
      myRest.addToCustomerCount(adios.getSize());
      myRest.tryToSitNextWaitingCustomer();
    }
  }
  
  /**
   * This method checks to see if there is a new SmallGroup at the current time. If customers
   * arrive and it is estimated they will not be seated in time, they are promptly turned away.
   * @param time The current uptime.
   */
  public void isSmallHere(int time){
    boolean seated = false;
    int estimate = myRest.getWaitEstimate();
    if(nextSmallGroupTime == time){
      myRest.addSmallArrival();
      if(nextSmallGroupTime<closeTime && time+estimate<closeTime){
        Customer newSmallG = new SmallGroup(newSize.spin(),time);
        seated = myRest.canWeSeat(newSmallG);
        if(seated) newSmallG.setWaitTimeEstimate(0);
        else newSmallG.setWaitTimeEstimate(estimate);
      }

      nextSmallGroupTime = time + smallArrival.getNext(); 
    }
  }
  
  /**
   * This method checks to see if there is a new LargeGroup at the current time. If customers
   * arrive and it is estimated they will not be seated in time, they are promptly turned away.
   * @param time The current uptime.
   */
  public void isLargeHere(int time){
    boolean seated = false;
    int estimate = myRest.getWaitEstimate();
    if(nextLargeGroupTime == time){
      myRest.addLargeArrival();
      if(nextLargeGroupTime<closeTime && time+estimate<closeTime){ 
        Customer newLargeG = new LargeGroup(newSize.spin()+4,time);
        seated = myRest.canWeSeat(newLargeG);
        if(seated) newLargeG.setWaitTimeEstimate(0);
        else newLargeG.setWaitTimeEstimate(estimate);
      }
      nextLargeGroupTime = time + largeArrival.getNext(); 
    } 
  }
  
  
}