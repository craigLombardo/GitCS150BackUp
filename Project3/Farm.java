import java.util.ArrayList;
/**
 * This class serves as a Farm by which we will travel to in order 
 * to collect all of the necessary ingredients for a meal.
 * @author Craig Lombardo
 */
public class Farm{
  
  private String myName;
  private ArrayList<Item> myItems;
  
  /**
   * This constructor method creates a new Farm with a given name.
   * @param name The name of the farm.
   * @param items The itesma the Farm has to offer.
   */
  public Farm(String name, ArrayList<Item> items){
    myName = name;
    myItems = items;
  }
  
  /**
   * This method returns the name of this farm.
   * @return The name of this farm.
   */
  public String getName(){
    return myName;
  }  
  
  /**
   * This method returns an ArrayList of the Items in stock at this farm.
   * @return An ArrayList with all of the items at this farm.
   */
  public ArrayList<Item> getItems(){
    return myItems;
  }
  
  /**
   * This method looks for a given Item at the farm given it's name.
   * @param name The name of the Item you are looking for.
   * @return null if the Item is not listed, an Item if it is present
   */
  public Item findItem(String name){
    Item best = null;
    for(Item i : myItems){ 
      if(i.getName().equals(name)){
        if(best ==null || i.getCost()<best.getCost()) best = i;
      }
    }
    return best;
  }
  
  /**
   * This method determines what ingredients this farm has out of the list of needed ingredients.
   * @param list An ArrayList of Strings corresponding to the names of the ingredients that are needed.
   * @return An ArrayList of Strings corresponding to the names of the ingredients that this farm has
   * that are also needed by the user
   */
  public ArrayList<String> hasWhichIngredients(ArrayList<String> list){
    ArrayList<String> out = new ArrayList<String>();
    for(String i : list){
      Item item = findItem(i);
      if(item!=null) out.add(item.getName());
    }
    return out;
  }
  
  /**
   * This method returns the total cost of getting all of the necessary ingredients from this farm,
   * based on the given list. It is important to note that getting the price of ingredients that are not present
   * at this parm will not result in a price change. i.e. if this farm only has beans for 1$ and you ask for the
   * price to buy beans and chicken the price will be 1$.
   * @param list The list of items to be purchased from this farm.
   * @return The cost of all of these ingredients.
   */
  public double getCost(ArrayList<String> list){
    double total = 0.0;
    for(String i : list){
      Item current = findItem(i);
      if(current!=null) total += current.getCost();
    }
    return total;
  }
}