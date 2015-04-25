import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collections;

/**
 * This class serves as a directed graph which will store a collection of directed edges.
 * @author Craig Lombardo
 */
public class DirectedGraph<K,E>{
  
  private HashMap<K,DirectedGraphNode> map;
  
  /**
   * This constructor method creates a directed graph with a single key/element.
   */
  public DirectedGraph(K k, E e){
    map = new HashMap<K,DirectedGraphNode>();
    map.put(k,new DirectedGraphNode(k,e));
  }
  
  /**
   * This method adds a node with key k.
   */
  public boolean addNode(K k, E e){
    if(!map.containsKey(k)){
      map.put(k,new DirectedGraphNode(k,e));
      return true;
    }
    else return false;
  }
  
  /**
   * Add an edge from the node with key k1 to the node with key k2. The edge has weight w. Returns true if the edge is successfully added.
   */
  public boolean addEdge(K k1, K k2, int w){
    DirectedGraphNode one = map.get(k1);
    DirectedGraphNode two = map.get(k2);
    
    if((one!=null && two!=null) && one!=two && w>0){
      one.addEdge(new Edge(two,w));
      return true;
    }
    else return false;
  }
  
  /**
   * Find the shortest path from the node with key k1 to the node with key k2.
   */
  public ArrayList<DirectedGraphNode> findShortestPath(K k1, K k2){
    DirectedGraphNode source = map.get(k1);
    DirectedGraphNode target = map.get(k2);
    computePaths(source);
    ArrayList<DirectedGraphNode> path = getShortestPathTo(target);
    return path;
  }
  
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
    output = output + "Distance: " + total + "\n";
    output = output + "Path: " + pathStr + path.get(path.size()-1).getElement() + " ";
    return path.size()>0 ? output : "No valid path found!";
  }
  
  //http://www.algolist.com/code/java/Dijkstra%27s_algorithm
  private void computePaths(DirectedGraphNode source){
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
  
  //http://www.algolist.com/code/java/Dijkstra%27s_algorithm
  private ArrayList<DirectedGraphNode> getShortestPathTo(DirectedGraphNode target){
    ArrayList<DirectedGraphNode> path = new ArrayList<DirectedGraphNode>();
    for(DirectedGraphNode node = target; node != null; node = node.getPrevious()){
      path.add(node);
    }
    Collections.reverse(path);
    return path.size()<=1 ? new ArrayList<DirectedGraphNode>() : path;
  }
  
  private class DirectedGraphNode implements Comparable<DirectedGraphNode>{
    
    private LinkedList<Edge> myEdges;
    private K myKey;
    private E myElement;
    private int minDistance = (int) Double.POSITIVE_INFINITY;
    private DirectedGraphNode previous;
    
    private DirectedGraphNode(K key, E element){
      myEdges = new LinkedList<Edge>();
      myKey = key;
      myElement = element;
    }
    
    public int compareTo(DirectedGraphNode other){
      return Double.compare(minDistance, other.minDistance);
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
  }
  
}