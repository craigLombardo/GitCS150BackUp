import java.util.Random;

/** Generate random integers in a certain range. 
  * Code adapted from http://www.javapractices.com/topic/TopicAction.do?Id=62
  */
public class RandomRange{
  
  private int min;
  private int max;
  
  /**
   * This constructor creates a RandomRange with a min and max value.
   * @param min The minimum value that can be generated.
   * @param max The maximum value that can be generated.
   */
  public RandomRange(int min, int max){
    this.min = min;
    this.max = max;
  }
  
  /**
   * This method generates a random time for use in the testing of the simulation.
   * @return int A random time between the minimum and maximum values set in the 
   * constructor method.
   */
  public int getRandomTime(){
    Random randomNums = new Random();
    //get the range, casting to long to avoid overflow problems
    long range = (long) max - (long) min + 1;
    // compute a fraction of the range, 0 <= frac < range
    long fraction = (long) (range * randomNums.nextDouble());
    return (int) (fraction + min);    
  }

} 