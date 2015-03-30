public class Athlete{

  private String myFirstName, myLastName, myHeight, myBirth, mySport;
  
  public Athlete(String firstName, String lastName, String height, String birth, String sport){
    myFirstName = firstName;
    myLastName = lastName;
    myHeight = height;
    myBirth = birth;
    mySport = sport;
  }
  
  public String getFirstName(){
    return myFirstName;
  }
  
  public String getLastName(){
    return myLastName;
  }
    
  public String getHeight(){
    return myHeight;
  }
    
  public String getBirth(){
    return myBirth;
  }
    
  public String getSport(){
    return mySport;
  }
  
  public void printData(){
    System.out.println("Name: " + myLastName + " " + myFirstName);
    System.out.println("Height: " + myHeight);
    System.out.println("Birth: " + myBirth);
    System.out.println("Sport: " + mySport);
  }
}