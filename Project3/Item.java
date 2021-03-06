/**
 * This class serves as a product that can be sold by a farm. For the purposes
 * of this project, each item will represent an ingredient in our meal.
 * @author Craig Lombardo
 */
public class Item implements Comparable<Item>{
  
  private String myName;
  private double myCost;
  
  /**
   * This constructor method creates a new Item with a desired name and cost per unit.
   * @param name The name of the Item.
   * @param cost The price per unit.
   */
  public Item(String name, double cost){
    myName = name;
    myCost = cost;
  }
  
  public int compareTo(Item other){
    return myName.compareTo(other.getName());
  }
  
  /**
   * This method returns the name of the Item.
   * @return The name of the Item.
   */
  public String getName(){
    return myName;
  }
  
  /**
   * This method returns the cost of the Item.
   * @return The price per unit.
   */
  public double getCost(){
    return myCost;
  }
  
  /**
   * This method sets the cost to another value.
   * @param other The new cost of the Item.
   */
  public void setCost(Double other){
    myCost = other;
  }
  
}