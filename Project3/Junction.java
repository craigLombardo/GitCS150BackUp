import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;

/**
 * This class serves as the generic node class which will act as a junction,
 * these junctions can serve as "traffic" junctions in which only traffic
 * passes through, or it can serve as a junction with a Restaurant or Farm.
 * @author Craig Lombardo
 */
public class Junction implements Comparable<Junction>{
  
  private String jName;
  private Farm thisFarm;
  private Restaurant thisRest;
  private ArrayList<Road> myRoads;
  private int minDistance = (int) Double.POSITIVE_INFINITY;
  private Junction previous;
  
  /**
   * This constructor creates a new Junction.
   * @param name The name of this junctin.
   * @param farm The Farm at this junction, if there is no Farm present then 
   * the user may simply input null.
   * @param rest The Restaurant at this junction, if there is no Restaurant present then 
   * the user may simply input null.
   */
  public Junction(String name, Farm farm, Restaurant rest){
    jName = name;
    thisFarm = farm;
    thisRest = rest;
    myRoads = new ArrayList<Road>();
  }
  
  /**
   * This method compares this Junction with another Junction. The comparison
   * is a comparison of the names as Strings.
   * @param other The other Junction to compare to
   * @return A negative number if this Junctions name is less than the others,
   * zero if they are the same, otherwise a number greater than 0
   */
  public int compareTo(Junction other){
    return jName.compareTo(other.getName());
  }
  
  /**
   * This method returns the name of this string.
   * @return The name of this Junction
   */
  public String getName(){
    return jName;
  }
  
  /**
   * This method returns the Farm at this junction.
   * @return A Farm if there is one, null if there is no Farm
   */
  public Farm getFarm(){
    return thisFarm;
  }
  
  /**
   * This method returns the Restaurant at this junction.
   * @return A Restaurant if there is one, null if there is no Restaurant.
   */
  public Restaurant getRest(){
    return thisRest;
  }
  
  /**
   * This method adds to the current list of roads the junction is connected by.
   * @param newR The new Road to be added.
   */
  public void addRoad(Road newR){
    myRoads.add(newR);
  }
  
  /**
   * This method returns a list of roads this junction is connected to/by.
   * @return An ArrayList corresponding to all of the paths to/from this junction.
   */
  public ArrayList<Road> getRoads(){
    return myRoads;
  }
  
  /**
   * This method sets the minimum distance of paths, used for Dijkstra's algorithm, it is advised
   * to not use this method as it is used in calculations.
   * @param d The new min distance.
   */
  private void setMinDistance(int d){
    minDistance = d;
  }
  
  /**
   * This method returns the current minimum distance as calculated by Dijkstra's algorithm.
   * @return The min distance.
   */
  private int getMinDistance(){
    return minDistance;
  }
  
  /**
   * This method sets the previous junction, again it is advised to not use this as
   * it is used for Dijkstra's algorithm.
   * @param prev The previous junction
   */
  private void setPrevious(Junction prev){
    previous = prev;
  }
  
  /**
   * This method returns the previous junction.
   * @return The previous junction as used in Dijkstra's algorithm
   */
  public Junction getPrevious(){
    return previous;
  }
  
  /**
   * This method connects this junction to another junction via a road.
   * @param other The other junctions
   * @param dist The distance of the road
   */
  public void connectTo(Junction other, int dist){
    new Road(this,other,dist);
  }
  
  /**
   * This method was modified from Algolist.com
   * http://www.algolist.com/code/java/Dijkstra%27s_algorithm
   * @param map The HashMap to use in order to compare all Junctions
   * to this Junction.
   */
  public void computePaths(HashMap<String, Junction> map){
    for(Map.Entry<String, Junction> entry : map.entrySet())
    {
      entry.getValue().setMinDistance((int) Double.POSITIVE_INFINITY);
      entry.getValue().setPrevious(null);
    }
    setMinDistance(0);
    PriorityQueue<Junction> queue = new PriorityQueue<Junction>();
    queue.add(this);
    while(!queue.isEmpty()){
      Junction current = queue.poll();
      // Visit each edge exiting current
      ArrayList<Road> roadList = current.getRoads();
      for(Road r : roadList){
        Junction next = r.getOtherJunction(current);
        int weight = r.getDistance();
        int distance = current.getMinDistance() + weight;
        if(distance < next.getMinDistance()){
          queue.remove(next);
          next.setMinDistance(distance);
          next.setPrevious(current);
          queue.add(next);
        }
      }
    }
  }
  
  /**
   * 
   * 
   * 
   * CHANGE THIS TO PRIVATE BEFORE SUBMISSION
   * 
   * 
   * 
   * 
   * 
   */
  
  public class Road{
    
    private Junction junctionOne, junctionTwo;
    private int distance;
    
    /**
     * This constructor method creates a "2-way" (undirected) road between two junctions.
     * @param j1 The first junction
     * @param j2 The second junction
     * @param d The distance between the first and second junction
     */
    private Road(Junction j1, Junction j2, int d){
      junctionOne = j1;
      junctionTwo = j2;
      distance = d;
      j1.addRoad(this);
      j2.addRoad(this);
    }
    
    /**
     * This method returns the distance between the two junctions.
     * @return The distance of the road.
     */
    public int getDistance(){
      return distance;
    }
    
    /**
     * This method returns the other junction from the current road.
     * @param current The junction at the end of the road.
     * @return A Junction if there is a valid link between the current junction
     * and this road, if not then it returns null.
     */
    public Junction getOtherJunction(Junction current){
      if(current == junctionOne) return junctionTwo;
      else if(current == junctionTwo) return junctionOne;
      else return null;
    }
  }
  
}