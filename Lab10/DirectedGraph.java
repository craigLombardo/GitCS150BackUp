import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Map;

/**
 * This class serves as a directed graph which will store a collection of directed edges.
 * @author Craig Lombardo
 */
public class DirectedGraph<K,E>{
  
  private HashMap<K,DirectedGraphNode> map;
  
  /**
   * This constructor method creates a directed graph with a single key/element node.
   * @param k The key of the first node.
   * @param e The element of the first node.
   */
  public DirectedGraph(K k, E e){
    map = new HashMap<K,DirectedGraphNode>();
    map.put(k,new DirectedGraphNode(k,e));
  }
  
  /**
   * This method adds a new node to the graph.
   * @param k The key of the new node.
   * @param e The element of new node.
   * @return true if successful, false if not
   */
  public boolean addNode(K k, E e){
    if(!map.containsKey(k)){
      map.put(k,new DirectedGraphNode(k,e));
      return true;
    }
    else return false;
  }
  
  /**
   * This method adds an edge from the node with key k1 to the node with key k2. Since it is a directed graph,
   * k1 "points" to k2 but not in reverse.
   * @param k1 The key of the starting node.
   * @param k2 The key of the destination node.
   * @param w The weight of the new edge. 
   * @return true if the edge is successfully added, false if not.
   */
  public boolean addEdge(K k1, K k2, int w){
    DirectedGraphNode one = map.get(k1);
    DirectedGraphNode two = map.get(k2);
    
    if((one!=null && two!=null) && one!=two && w>0){
      one.addEdge(new Edge(two,w));
      one.setConnected(true);
      two.setConnected(true);
      return true;
    }
    else return false;
  }
  
  /**
   * This method finds the shortest path from the node with key k1 to the node with key k2.
   * @param k1 The key of the starting node.
   * @param k2 The key of the destination node.
   * @return ArrayList An ArrayList of the path from k1 to k2
   */
  public ArrayList<DirectedGraphNode> findShortestPath(K k1, K k2){
    DirectedGraphNode source = map.get(k1);
    DirectedGraphNode target = map.get(k2);
    computePaths(source);
    ArrayList<DirectedGraphNode> path = getShortestPathTo(target);
    return path;
  }
  
  /**
   * This method finds the shortest path information from the node with key k1 to the node with key k2.
   * @param k1 The key of the starting node.
   * @param k2 The key of the destination node.
   * @return String The information on the path from k1 to k2; information includes distance and the element 
   * of each node in the order of the path.
   */
  public String findShortestPathInfo(K k1, K k2){
    DirectedGraphNode source = map.get(k1);
    DirectedGraphNode target = map.get(k2);
    computePaths(source);
    ArrayList<DirectedGraphNode> path = getShortestPathTo(target);
    int total = 0;
    String pathStr = "";
    for(int i=0; i<path.size()-1; i++){
      DirectedGraphNode current = path.get(i);
      pathStr = pathStr + current.getElement() + " --> ";
      LinkedList<Edge> edges = current.getEdges();
      for(int j=0; j<edges.size(); j++){
        Edge currentEdge = edges.get(j);
        if(currentEdge.getConnectedTo()==path.get(i+1)){
          total+=currentEdge.getWeight();
          break;
        }
      }
    }
    String output = "Path from " + source.getElement() + " -> " + target.getElement() + "\n";
    if(path.size()>0){
      output = output + "Distance: " + total + "\n";
      output = output + "Path: " + pathStr + path.get(path.size()-1).getElement() + "\n";
    }
    else output = output + "No valid path found!\n";
    return output;
  }
  
  /**
   * This method was modified from Algolist.com
   * http://www.algolist.com/code/java/Dijkstra%27s_algorithm
   */
  private void computePaths(DirectedGraphNode source){
    for(Map.Entry<K, DirectedGraphNode> entry : map.entrySet())
    {
      entry.getValue().setMinDistance((int) Double.POSITIVE_INFINITY);
      entry.getValue().setPrevious(null);
    }
    source.setMinDistance(0);
    PriorityQueue<DirectedGraphNode> queue = new PriorityQueue<DirectedGraphNode>();
    queue.add(source);
    while(!queue.isEmpty()){
      DirectedGraphNode current = queue.poll();
      // Visit each edge exiting current
      LinkedList<Edge> edgeList = current.getEdges();
      for(Edge e : edgeList){
        DirectedGraphNode next = e.getConnectedTo();
        int weight = e.getWeight();
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
   * This method was modified from Algolist.com
   * http://www.algolist.com/code/java/Dijkstra%27s_algorithm
   */
  private ArrayList<DirectedGraphNode> getShortestPathTo(DirectedGraphNode target){
    ArrayList<DirectedGraphNode> path = new ArrayList<DirectedGraphNode>();
    for(DirectedGraphNode node = target; node != null; node = node.getPrevious()){
      path.add(node);
    }
    Collections.reverse(path);
    return path.size()<=1 ? new ArrayList<DirectedGraphNode>() : path;
  }
  
  /**
   * This method returns whether or not all nodes can be reached in the graph.
   * @return true if all can be reached, false if not
   */
  public boolean checkAllConnected(){
    boolean output = true;
    for(Map.Entry<K, DirectedGraphNode> entry : map.entrySet()){
      if(output) output = entry.getValue().isConnected();
    }
    return output;
  }
  
  private class DirectedGraphNode implements Comparable<DirectedGraphNode>{
    
    private LinkedList<Edge> myEdges;
    private K myKey;
    private E myElement;
    private int minDistance = (int) Double.POSITIVE_INFINITY;
    private DirectedGraphNode previous;
    private boolean connected = false;
    
    private DirectedGraphNode(K key, E element){
      myEdges = new LinkedList<Edge>();
      myKey = key;
      myElement = element;
    }
    
    /**
     * This method compares this minimum distance to the minimum distance of another node.
     * @param other The other DirectedGraphNode to compare to this current node.
     * @return int An integer <0 if this distance is less, =0 if the distances are equal or >0
     */
    public int compareTo(DirectedGraphNode other){
      return Integer.compare(minDistance, other.minDistance);
    }
    
    private void addEdge(Edge edge){
      myEdges.add(edge);
    }
    
    private void setMinDistance(int d){
      minDistance = d;
    }
    
    private int getMinDistance(){
      return minDistance;
    }
    
    private LinkedList<Edge> getEdges(){
      return myEdges;
    }
    
    private void setPrevious(DirectedGraphNode prev){
      previous = prev;
    }
    
    private DirectedGraphNode getPrevious(){
      return previous;
    }
    
    private E getElement(){
      return myElement;
    }
    
    private void setConnected(boolean bool){
      connected = bool;
    }
    
    private boolean isConnected(){
      return connected;
    }
  }
  
  private class Edge{
    private DirectedGraphNode connectedTo;
    private int myWeight;
    
    private Edge(DirectedGraphNode other, int weight){
      connectedTo = other;
      myWeight = weight;
    }
    
    private DirectedGraphNode getConnectedTo(){
      return connectedTo;
    }
    
    private int getWeight(){
      return myWeight;
    }
    
  }
  
  /**
   * The main method is used in conjunction with the graph presented to 
   * @param args This is not used in testing.
   */
  public static void main(String[] args){    
    DirectedGraph<Integer,String> test = new DirectedGraph<Integer,String>(1,"A");
    test.addNode(2,"B");
    test.addNode(3,"C");
    test.addNode(4,"D");
    test.addNode(5,"E");
    test.addNode(6,"F");
    test.addNode(7,"G");
    
    test.addEdge(1,4,12);
    test.addEdge(1,5,1);
    test.addEdge(2,6,11);
    test.addEdge(4,2,1);
    test.addEdge(3,4,5);
    test.addEdge(7,3,17);
    test.addEdge(4,5,3);
    test.addEdge(5,6,2);
    test.addEdge(6,7,9);
    
    System.out.println(test.findShortestPathInfo(2,4));
    
    System.out.println(test.findShortestPathInfo(4,2));
    
    System.out.println(test.findShortestPathInfo(7,1));
    
    System.out.println(test.findShortestPathInfo(7,6));
    
    System.out.println(test.findShortestPathInfo(1,3));
    
    System.out.println(test.findShortestPathInfo(1,2));
  }
  
}