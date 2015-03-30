import java.util.*;

/**
 * This class creates a wheel which generates pseudorandom numbers based 
 * on a seed and an upperbound value.
 * @author Craig Lombardo
 */
public class Wheel{
  
  private int upper;
  private Random random;
  
  /**
   * This constructor class creates a Wheel which has a "spin" functionality, which generates a random number.
   * @param seed An integer value which is used to generate pseudorandom numbers.
   * @param upper An integer value which is the highest number the wheel can generate, range is 1-upper.
   */
  public Wheel(int seed, int upper){
    this.upper=upper;
    random = new Random(seed);
  }
    
  /**
   * The spin method generates a pseudorandom int.
   * @return int A pseudorandom number from 1-upper.
   */
  public int spin(){
    return random.nextInt(upper)+1;
  }
  
}