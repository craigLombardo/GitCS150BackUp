/**
 * This class represents a small group and has full functionality of Customer.
 * @author Craig Lombardo
 */
public class SmallGroup extends Customer{
  
  /**
   * The constructor method of this class creates a SmallGroup, setting type = to "small".
   * @param groupSize The number of people in the SmallGroup.
   * @param timeArrived The time the group arrived at the Restaurant.
   */
  public SmallGroup(int groupSize, int timeArrived){
    partySize = groupSize;
    arrivalTime = timeArrived;
    setType("small");
  }
  
}