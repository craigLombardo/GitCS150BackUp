import java.util.ArrayList;

/**
 * This class will control the seating availability given a certain table type.
 * @author Craig Lombardo
 */
public class Seating{
  /**
   * The number of seats at a given table
   */
  protected int numberOfSeatsAvailable;
  
  /**
   * This keeps a tally on number of each availability type in a 2d array
   */
  protected ArrayList<ArrayList<Integer>> seatingIndexes;
  
  /**
   * The type of table we are looking at
   */
  protected String tableType;
  
  /**
   * used to map available seating, if null then seat is open else there should be a customer there
   */
  protected ArrayList<Customer> availableSeating;
  
  /**
   * The Restaurant the table is in
   */
  protected Restaurant myRest;
  
  //These will create instances of RandomGaussian number generators to calculate stay
  //times for small and large groups.
  private RandomGaussian smallStay, largeStay;
  
  /**
   * This constructor method instantiates the 2d array, as well as creates the RandomGaussian number generators for stay times.
   */
  public Seating(){
    seatingIndexes = new ArrayList<ArrayList<Integer>>(8); //1 for each group size
    for(int i=0; i < 8; i++){
      seatingIndexes.add(new ArrayList<Integer>());
    }
    
    smallStay = new RandomGaussian(2700,600);
    
    largeStay = new RandomGaussian(3600,900);
  }
  
  /**
   * This method gets the number of seats at a given table. (Irregardless of whether or not the seats are taken)
   * @return int The number of seats at the table.
   */
  public int getNumberOfSeatsAvailable(){
    return numberOfSeatsAvailable;
  }
  
  /**
   * This method wraps the arraylist for continuity at the oval, allowing for seating that is otherwise impossible
   * at seating areas like the bar. Tables are also given this continuitu so multiple small groups may sit at the 
   * same table, It's a great way to meet new people and adds seating options.
   * @param size The size of the group attempted to be seated.
   * @return ArrayList The corrected ArrayList that gives continuity or "circular-ness" to an otherwise
   * linear list.
   */
  public ArrayList<Customer> wrap(int size){
    ArrayList<Customer> tmp = new ArrayList<Customer>();
    for(int j=0; j<availableSeating.size(); j++){
      tmp.add(availableSeating.get(j));
    }
    /*One less as we do not need to count the number of elements equal to the size.
     *The reason behind this is because if it was extended the length of the array then we
     *would result in having the same seat pattern twice (i.e. seat 0 is counted twice)
     */
    for(int i=0; i< size - 1; i++){
      tmp.add(availableSeating.get(i));
    }
    return tmp;
  }
  
  /**
   * This method checks for the availability at a given table for a specific group size.
   * @param size The size of the group we want to know if we have seating for.
   */
  public void checkForSize(int size){
    int consec; // the number of consecutive tables
    //If the seating type is a "table", the maximum number that can be seated at the table is 4, so groups larger than that
    //automatically will not be able to sit there
    if(tableType.equals("table") && size > 4) return; 
    else{
      //If the seating type is "oval" or "table" we must perform the wrap operation to get continuity
      ArrayList<Customer> arrToUse = tableType.equals("oval") ||  tableType.equals("table") ? wrap(size) :   availableSeating;
      //This array stores the indexes we can put customers at
      ArrayList<Integer> pos = new ArrayList<Integer>();
      for(int i = 0; i < arrToUse.size() - (size-1); i++){
        consec = 0; //keeps track of consecutive empty seats
        for(int j = 0; j < size; j++){
          if(arrToUse.get(i+j) == null) consec++;
        }
        if(consec == size) pos.add(i); //if consecutive open seats = size of group to sit then we add that number to our
      }
      seatingIndexes.set(size-1,pos);}
  }
  
  /**
   * This method checks the availability at the table for all group sizes.
   */
  public void checkGroupAvailability(){
    for(int i = 1; i<=8; i++){
      checkForSize(i);
    }
  }
  
  /**
   * This method removes the group from their table, it also recalculates the availability for the table.
   * @param leaving The group that is done eating and is about to get up.
   */
  public void removeGroup(Customer leaving){
    int index = leaving.getIndex(); //The index of the first person in the party
    for(int i = 0; i < leaving.getSize(); i++){
      int offset = 0;
      if((index+i) >= numberOfSeatsAvailable) offset = numberOfSeatsAvailable;
      availableSeating.set(index + i - offset,null); //sets the seat to null (available seat/no customer present)
    }
    checkGroupAvailability();
  }
  
  /**
   * This method provides the user with a visual representation of the available seating positions for a group. 
   * Indexes are the seating position of the first person in the group.
   */
  public void printSeats(){
    checkGroupAvailability();
    for(int i = 0; i< 8; i++) System.out.println("Group Size: " + (i+1) + " " + seatingIndexes.get(i));
  }
  
  /**
   * This method calculates which customer group is next to leave at the table and returns them.
   * @return Customer The customer group that is next to leave.
   */
  public Customer getNextCustomerToDepart(){
    int nextTime=999999999; //an initial number larger than any possible depart time
    Customer nextCustomer=null;
    //looks through all seating indexes
    for(int i=0; i<numberOfSeatsAvailable; i++){
      //if there is someone at the seat we look at their information
      if(availableSeating.get(i)!=null){
        int custDepart = availableSeating.get(i).getDepartTime();
        //if there is a customer with a departTime < the previous lowest depart time, we correct this
        if(custDepart < nextTime){
          nextTime = custDepart;
          nextCustomer = availableSeating.get(i);
        }
      }
    }
    return nextCustomer;
  }
  
  /**
   * This method tries to seat a group, returning a boolean representing whether or not the seating was successful.
   * @param group The customers to seat.
   * @return boolean A boolean representing whether or not the group was actually seated.
   */
  public boolean tryToSeatGroup(Customer group){
    checkGroupAvailability();
    boolean seated = false;
    try{
      int where = this.seatingIndexes.get(group.getSize()-1).get(0); //first available seating option
      group.setIndex(where);
      for(int i = 0; i < group.getSize(); i++){
        //This makes sure the index is not out of bounds when setting the customers to the table
        int index = (tableType.equals("oval") || tableType.equals("table")) && where + i >= numberOfSeatsAvailable ? 
          where + i - numberOfSeatsAvailable : where + i;
        availableSeating.set(index,group);
      }
      group.setTable(this);
      seated = true;
 
    }
    catch(Exception e){
      
    }
    checkGroupAvailability();
    
    //if a customer is seated we want to assign them a depart time
    if(seated){
      boolean small = group.getType().equals("small");
      int cTime = myRest.getTime();
      int stayTime = small ? smallStay.getNext() : largeStay.getNext();
      group.setDepartTime(stayTime+cTime);
    }
    return seated;
  }
 
  
}