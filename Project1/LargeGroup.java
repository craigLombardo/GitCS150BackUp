/**
 * This class represents a large group and has full functionality of Customer.
 * @author Craig Lombardo
 */
public class LargeGroup extends Customer{
  
  /**
   * The constructor method of this class creates a LargeGroup, setting type = to "large".
   * @param groupSize The number of people in the LargeGroup.
   * @param timeArrived The time the group arrived at the Restaurant.
   */
  public LargeGroup(int groupSize, int timeArrived){
    partySize = groupSize;
    arrivalTime = timeArrived;
    setType("large");
  }
  
}