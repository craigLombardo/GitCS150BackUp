import java.util.Random;

/** 
 Generate pseudo-random floating point values, with an 
 approximately Gaussian (normal) distribution.

 Many physical measurements have an approximately Gaussian 
 distribution; this provides a way of simulating such values.
 http://www.javapractices.com/topic/TopicAction.do?Id=62
 http://www.javamex.com/tutorials/random_numbers/gaussian_distribution_2.shtml
*/
public final class RandomGaussian {
    
  private Random fRandom = new Random();
  private int mean, variance;
  
  /**
   * This method creates random numbers with a normal distribution.
   * @param myMean The mean of the distribution
   * @param myVariance The variance of the distribution.
   */
  public RandomGaussian(int myMean, int myVariance){
    mean = myMean;
    variance = myVariance;
  }
  
  /**
   * This method gets the next random number.
   * @return int A random Gaussian integer.
   */
  public int getNext(){
    int val = 0;
    /*This ensures we cannot get a negative number as the time used is uptime so 
    negative numbers will give us customers who arrived in the past, not the future*/
    val = (int) Math.round(fRandom.nextGaussian() * variance + mean);
    if(val <= 0) return 1;
    else return val;
  }
  
  public static void main(String[] args){
     RandomGaussian test1 = new RandomGaussian(20,10);
    
    for(int i=0; i<100; i++) System.out.println(test1.getNext());
  }
  
}