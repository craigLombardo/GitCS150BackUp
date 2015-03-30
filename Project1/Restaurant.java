import java.util.ArrayList;

/**
 * This class is where the tests are run and acts as the restaurant we are simulating.
 * @author Craig Lombardo
 */
public class Restaurant{
  
  //Up time of 2 am, starting time is always 0 (6 pm) and time is measured in seconds
  private static final int CLOSETIME = 28800;
  
  private int time;
  
  private int customerTotal;
  
  //This part of the code is for the different preferences of table choices, as well as the 
  //declaration of table types
  private ArrayList<Seating> smallPref, largePref; 
  
  //These are the seating options in the restaurant
  private Seating table1, table2, table3, table4, table5;
  private Seating booth1, booth2, booth3, booth4, booth5;
  private Seating bar;
  private Seating oval;
  
  //These variables keep track of the number of small and large arrivals/seated customers
  private int smallCount, largeCount, seatedSmallCount, seatedLargeCount;
  
  //These lists keep track of the customers in the restaurant, both waiting and seated
  private ArrayList<Customer> waitingList;
  private ArrayList<Customer> seatedGroups;
  
  //This acts like a clock for the restaurant, controlling all timed events
  private TimedEvents timedEv;
  
  //Which waiting strategy to use
  private int waitingStrategy;
  
  /**
   * This constructor method takes no parameters and instantiates the various tables and 
   * RandomGaussian number generators, the lists to keep track of customers, and loads the
   * "scenario" or design strategy of the test.
   */
  public Restaurant(){
    
    smallCount = 0;
    largeCount = 0;
    seatedSmallCount = 0;
    seatedLargeCount = 0;
    
    customerTotal=0;
    
    waitingList = new ArrayList<Customer>();
    
    seatedGroups = new ArrayList<Customer>();
    
    timedEv = new TimedEvents(this);
    
    table1 = new Table(this);
    table2 = new Table(this);
    table3 = new Table(this);
    table4 = new Table(this);
    table5 = new Table(this);
    
    booth1 = new Booth(this);
    booth2 = new Booth(this);
    booth3 = new Booth(this);
    booth4 = new Booth(this);
    booth5 = new Booth(this);
    
    bar = new Bar(this);
    
    oval = new Oval(this);
    
  }
  
  /**
   * This method adds to the total customer count.
   * @param num The number of customers to add to the count.
   */
  public void addToCustomerCount(int num){
    customerTotal+=num;
  }
  
  /**
   * This method sets the which seating preference to use for the restaurant.
   * @param seating The seating option (1-3)
   * @param waiting The waiting option (1-2)
   */
  public void setCustomerHandling(int seating, int waiting){
    if(seating==1) setSeatingPrefToScenario1();
    if(seating==2) setSeatingPrefToScenario2();
    if(seating==3) setSeatingPrefToScenario2();
    setWaitingType(waiting);
  }
  
  /**
   * This method sets the waiting type for the restaurant. Waiting type is the 
   * strategy for removing customers from the waiting list.
   * @param type The waiting option (1-2)
   */
  public void setWaitingType(int type){
    waitingStrategy = type;
  }
  
  /**
   * This method returns the waiting type for the restaurant. Waiting type is the 
   * strategy for removing customers from the waiting list.
   * @return int The value of the waiting strategy (1-2)
   */
  public int getWaitingType(){
    return waitingStrategy;
  }
  
  /**
   * This method returns the metaphorical timer, this method is used for testing purposes.
   * @return TimedEvents Restaurant "timer".
   */
  public TimedEvents getTimer(){
    return timedEv;
  }
  
  /**
   * This method returns an array corresponding to the list of seated customers.
   * @return ArrayList The seated customer list
   */
  public ArrayList<Customer> getSeatedList(){
    return seatedGroups;
  }
  
  /**
   * This method removes a seated group from their table.
   * @param who The customer to remove from their seats.
   */
  public void removeSeatedGroup(Customer who){
    int index = who.getIndex();
    Seating table = who.getTable();
    for(int i=who.getSize()-1; i>=0; i--){
      int num = index + i < table.getNumberOfSeatsAvailable() ? index + i : index + i - table.getNumberOfSeatsAvailable();
      table.availableSeating.set(num,null);
    }
    for(int j=seatedGroups.size()-1; j>=0; j--){
      if(seatedGroups.get(j) == who){
        seatedGroups.remove(j);
        return;
      }
    }
    table.removeGroup(who);
  }
  
  /**
   * This method sets the seating options to scenario 1, in which small groups look to be seated at a table first, then
   * the bar, and finally the oval. Large groups look to be seated at a booth first, then the oval and then
   * finally the bar.
   */
  public void setSeatingPrefToScenario1(){
    smallPref = new ArrayList<Seating>();
    smallPref.add(table1);
    smallPref.add(table2);
    smallPref.add(table3);
    smallPref.add(table4);
    smallPref.add(table5);
    smallPref.add(bar);
    smallPref.add(oval);
    
    largePref = new ArrayList<Seating>();
    largePref.add(booth1);
    largePref.add(booth2);
    largePref.add(booth3);
    largePref.add(booth4);
    largePref.add(booth5);
    largePref.add(oval);
    largePref.add(bar);
  }
  
    /**
   * This method sets the seating options to scenario 2, in which small groups look to be seated at the bar and
   * then the oval and then finally a table. Large groups look to be seated at the oval and then the bar, and then
   * finally the booths.
   */
  public void setSeatingPrefToScenario2(){
    smallPref = new ArrayList<Seating>();
    smallPref.add(bar);
    smallPref.add(oval);
    smallPref.add(table1);
    smallPref.add(table2);
    smallPref.add(table3);
    smallPref.add(table4);
    smallPref.add(table5);
    
    largePref = new ArrayList<Seating>();
    largePref.add(oval);
    largePref.add(bar);
    largePref.add(booth1);
    largePref.add(booth2);
    largePref.add(booth3);
    largePref.add(booth4);
    largePref.add(booth5);
  }
  
  /**
   * This method sets the seating options to scenario 3, in which small groups look to be seated at the bar and
   * then the tables and then finally the oval. Large groups look to be seated at the bar and then the booths, and then
   * finally the oval. This final strategy ensures the two seating preferences are basically the same.
   */
  public void setSeatingPrefToScenario3(){
    smallPref = new ArrayList<Seating>();
    smallPref.add(bar);
    smallPref.add(table1);
    smallPref.add(table2);
    smallPref.add(table3);
    smallPref.add(table4);
    smallPref.add(table5);
    smallPref.add(oval);
    
    largePref = new ArrayList<Seating>();
    largePref.add(bar);
    largePref.add(booth1);
    largePref.add(booth2);
    largePref.add(booth3);
    largePref.add(booth4);
    largePref.add(booth5);
    largePref.add(oval);
  }
  
  /**
   * This method adds to the small group arrival count.
   */
  public void addSmallArrival(){
    smallCount++;
  }
  
  /**
   * This method adds to the large group arrival count.
   */
  public void addLargeArrival(){
    largeCount++;
  }
  
  /**
   * This method adds to the small group seated count.
   */
  public void addSmallSeated(){
    seatedSmallCount++;
  }
  
  /**
   * This method adds to the large group seated count.
   */
  public void addLargeSeated(){
    seatedLargeCount++;
  }
  
  /**
   * This method sets the order of waiting list removal, scenario 1 for waiting list options.
   */
  public void waitingOrder1(){
    boolean seated = false;
    for(int j=0; j< waitingList.size() && !seated; j++){
      Customer group = waitingList.get(j);
      seated = canWeSeat(group);
    }
  }
  
  /**
   * This method sets the order of waiting list removal, scenario 2 for waiting list options.
   */
  public void waitingOrder2(){
    boolean seated = false;
    for(int j=0; j< waitingList.size() && !seated; j++){
      Customer group = waitingList.get(j);
      if(group.getType()=="large") seated = canWeSeat(group);
    }
    for(int j=0; j< waitingList.size() && !seated; j++){
      Customer group = waitingList.get(j);
      if(group.getType()=="small") seated = canWeSeat(group);
    }
  }
  
  /**
   * This method tries to sit the next customer to be drawn from the waiting list.
   */
  public void tryToSitNextWaitingCustomer(){
    if(waitingList.size()>0){
      if(getWaitingType()==1) waitingOrder1();
      if(getWaitingType()==2) waitingOrder1();
    }
  }
  
  /**
   * This method is for the restaurant to check if a specified group can be seated. If so then they
   * are added to the seatedGroups list and seated at the appropriate table, if not then they are added
   * to the waiting list.
   * @param who The customer we would like to 
   * @return boolean A boolean representing whether or not a customer was actually seated.
   */
  public boolean canWeSeat(Customer who){
    String type = who.getType(); //The type of group, either "small" or "large"
    boolean seated = false; //represents whether or not they are seated
    //The next snippets of code determine where to potentially seat a group based on their preferences/type.
    if(type.equals("small")){
      for(int i=0; i<smallPref.size() && !seated; i++){
        seated = smallPref.get(i).tryToSeatGroup(who);
      }
    }
    else if(type.equals("large")){
      for(int i=0; i<largePref.size() && !seated; i++){
        seated = largePref.get(i).tryToSeatGroup(who);
      }
    }
    //if a group was successfully seated 
    if(seated){
      //add them to the seated list
      seatedGroups.add(who);
      //if they were sitting then we want to remove them from the waiting
      //list.
      if(who.getWaiting()){
        who.setActualWaitTime(time-who.getArrivalTime());
        removeFromWaitingList(who);
      }
      //add to seated counts as appropriate
      if(who.getType().equals("small")) addSmallSeated();
      else addLargeSeated();
    }
    //or if they were not seated and not already on the waiting list
    else if(!who.getWaiting()){
      //if this part is reached then we add them to the waiting list.
      //this was done to ensure customers were not duplicating.
      addToWaitingList(who);
    }
    return seated;
  }
  
  /**
   * This method adds customers to the waiting list if a seat was not found for them.
   * @param who The customer we are trying to seat.
   */
  public void addToWaitingList(Customer who){
    waitingList.add(who);
    who.setWaiting(true);
  }
  
  /**
   * This method removes customers from the waiting list.
   * @param who The customer to remove from the waiting list.
   */
  public void removeFromWaitingList(Customer who){
    for(int i=0; i<waitingList.size();i++){
      Customer thisCust = waitingList.get(i);
      if(thisCust == who){
        waitingList.remove(i);
        return;
      }
    }
  }
  
  /**
   * This method returns the current waiting list for use in a sort of system of 
   * checks and balances.
   * @return ArrayList The current Restaurant waiting list.
   */
  public ArrayList<Customer> getWaitingList(){
    return waitingList;
  }
  
  /**
   * This method acts as the restaurants doors "opening" and "closing". Time always starts at 0,
   * and is measured in seconds; however, the user may specify when the restaurant closes. 
   * Time is measured based in uptime.
   * @param closeTime The time the restaurant closes.
   */
  public void openRestaurant(int closeTime){
    for(time=0; time < closeTime; time++){
      timedEv.whosDone(time);
      timedEv.isLargeHere(time);
      timedEv.isSmallHere(time);
    } 
  }
  
  /**
   * This method calculates an approximate wait time for a customer given how many
   * customers are already on the waiting list.
   * @return int The estimated wait time.
   */
  public int getWaitEstimate(){
    int smallCountWait=0, largeCountWait=0;
    for(int i=0; i< waitingList.size(); i++){
      if(waitingList.get(i).getType().equals("large")) largeCountWait++;
      else smallCountWait++;
    }
    return (smallCountWait/4)*200+(largeCountWait/2)*900;
  }
  
  /**
   * This method returns the current Restaurant time.
   * @return int The current time.
   */
  public int getTime(){
    return time;
  }
  
  /**
   * This method returns the Restaurant's close time.
   * @return The closetime of the Restaurant.
   */
  public int getCloseTime(){
    return CLOSETIME;
  }
  
  /**
   * This method creates the test Restaurant which will handle all of our data collection. Through
   * the use of this we may test the different seating options and different wait list handling options.
   * @param args The arguments to be passed in specifying the restaurant scenario.The first corresponds 
   * to the seating preference to use for the restaurant (1-3) and the second corresponds to the 
   * waiting list option (1-2).
   */
  public static void main(String[] args){
    Restaurant test = new Restaurant();
    test.setCustomerHandling(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    
    test.openRestaurant(CLOSETIME);
    System.out.println("Waiting List total: " + test.waitingList.size());
    int foodPayout = 0;
    for(int i=0; i<test.waitingList.size(); i++) foodPayout = foodPayout + 4*(test.waitingList.get(i).getSize());
    System.out.println("Free meals given out to waiting customers: " + foodPayout);
    System.out.println("Total Arrival Amounts:\nSmall Count: " + test.smallCount + " Large Count: " + test.largeCount + " Group Total Count :" + (test.smallCount + test.largeCount));
    System.out.println("\nSeated Totals:\nSmall Count: " + test.seatedSmallCount + " LargeCount: " + test.seatedLargeCount + " Total: " + (test.seatedSmallCount + test.seatedLargeCount));
    
    System.out.println("\nThe number of customers seated total: " + test.customerTotal+"\n");

    System.out.println("# still eating after 2am... " + test.seatedGroups.size());
  }
  
}