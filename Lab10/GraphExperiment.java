/**
 * This class serves as the test grounds for finding the complexity of finding 
 * the shortest path to a graph.
 * @author Craig Lombardo
 */
public class GraphExperiment{
  
  /**
   * This constructor method creates the test environment for our experimentation.
   */
  public GraphExperiment(){
    
  }
  
  private DirectedGraph<Integer,Integer> makeGraph(int n, int seed){
    DirectedGraph<Integer,Integer> graph = new DirectedGraph<Integer,Integer>(1,1);
    for(int i=1; i<=n; i++) graph.addNode(i,i);
    int max = (n*n)/2 - n;
    Wheel tenWheel = new Wheel(seed,10);
    Wheel selWheel = new Wheel(seed,n);
    for(int i=0; i<max; i++){
      int K1 = 0;
      int K2 = 0;
      int w = tenWheel.spin();
      while(K1==K2){
        K1 = selWheel.spin();
        K2 = selWheel.spin();
      }
      graph.addEdge(K1, K2, w);
    }
    boolean allConnected = graph.checkAllConnected();
    if(!allConnected) System.out.println("ok");
    return allConnected ? graph : makeGraph(n,seed+1);
  } 
  
  /**
   * This method tests a series of graphs with a randomized set of edges. The smallest graph should have 5 nodes.
   * @param args This is not used in experimentation.
   */
  public static void main(String[] args){
    GraphExperiment test = new GraphExperiment();
    DirectedGraph<Integer, Integer> tmp = test.makeGraph(1000,711);
  }
  
}