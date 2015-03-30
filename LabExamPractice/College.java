import java.util.TreeSet;
import java.util.Scanner;
import java.io.File;
import java.util.Iterator;
import java.util.ArrayList;

public class College{
  
  private TreeSet<Athlete> myTree;
  private Scanner sc;
  
  public College(){
    myTree = new TreeSet<Athlete>(new AthleteComparator());
  }
  
  public void createDB(String fname){
    try{
      sc = new Scanner(new File(fname));
    }
    catch(java.io.FileNotFoundException e){
      
    }
    
    while(sc.hasNextLine()){
      String line = sc.nextLine();
      int count = 0;
      String firstName = "";
      String lastName = "";
      String height = "";
      String birth = "";
      String sport = "";
      while(count<4){
        if(firstName.compareTo("")==0 && line.substring(0,6).compareTo("Name: ") == 0){
          String fullName = line.substring(6);
          for(int i=0; i<fullName.length()-1; i++){
            if(fullName.substring(i,i+1).compareTo(" ") == 0){
              lastName = fullName.substring(0,i);
              firstName = fullName.substring(i+1);
              if(sc.hasNextLine()) line = sc.nextLine();
              count++;
              break;
            }
          }
        }
        else if(height.compareTo("")==0 && line.substring(0,8).compareTo("Height: ") == 0){
          height = line.substring(8);
          if(sc.hasNextLine()) line = sc.nextLine();
          count++;
        }
        else if(birth.compareTo("")==0 && line.substring(0,7).compareTo("Birth: ") == 0){
          birth = line.substring(7);
          if(sc.hasNextLine()) line = sc.nextLine();
          count++;
        }
        else if(sport.compareTo("")==0 && line.substring(0,7).compareTo("Sport: ") == 0){
          sport = line.substring(7);
          if(sc.hasNextLine()) line = sc.nextLine();
          count++;
        }
      }
      Athlete newGuy = new Athlete(firstName, lastName, height, birth, sport);
      myTree.add(newGuy);
    }
    
  }
  
  public ArrayList<Athlete> getList(){
    Iterator<Athlete> iter = myTree.iterator();
    ArrayList<Athlete> list = new ArrayList<Athlete>();
    while(iter.hasNext()){
      list.add(iter.next());
    }
    return list;
  }
  
  public static void main(String[] args){
    College test = new College();
    test.createDB("sampleData.txt");
    
    ArrayList<Athlete> tmp = test.getList();
    for(int i=0; i< tmp.size(); i++){
      tmp.get(i).printData();
      if(i<tmp.size()-1) System.out.println();
    }
  }
  
}