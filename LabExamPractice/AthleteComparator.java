import java.util.Comparator;

public class AthleteComparator implements Comparator<Athlete>{

  public AthleteComparator(){
  
  }
  
  public int compare(Athlete one, Athlete two){
    int height = compareHeight(one,two);
    if(height != 0) return height;
    else{
      int birth = compareBirth(one,two);
      if(birth != 0) return birth;
      else{
        int last = compareLastName(one,two);
        if(last != 0) return last;
        else{
          int sport = compareSport(one,two);
          if(sport != 0) return sport;
          else return 0;
        }
      }
    }
  }
  
  public int compareLastName(Athlete one, Athlete two){
    return one.getLastName().compareTo(two.getLastName());
  }
  
  public int compareHeight(Athlete one, Athlete two){
    String h1 = one.getHeight();
    int p1feet = 0;
    int p1inches = 0;
    for(int i=0; i<h1.length(); i++){
      if(h1.substring(i,i+1).compareTo(" ")==0){
        p1feet = Integer.parseInt(h1.substring(0,i));
        p1inches = Integer.parseInt(h1.substring(i+1));
      }
    }
    String h2 = two.getHeight();
    int p2feet = 0;
    int p2inches = 0;
    for(int i=0; i<h2.length(); i++){
      if(h2.substring(i,i+1).compareTo(" ")==0){
        p2feet = Integer.parseInt(h2.substring(0,i));
        p2inches = Integer.parseInt(h2.substring(i+1));
      }
    }
    if(p1feet != p2feet) return p1feet > p2feet ? 1 : -1;
    else{
      if(p1inches != p2inches) return p1inches > p2inches ? 1 : -1;
      else return 0;
    }
  }
  
  public int compareBirth(Athlete one, Athlete two){
    return one.getBirth().compareTo(two.getBirth());
  }
  
  public int compareSport(Athlete one, Athlete two){
    return one.getSport().compareTo(two.getSport());
  }
  
  public static void main(String[] args){
    
    Athlete test1 = new Athlete("test","one","7 4", "june", "xc");
    Athlete test2 = new Athlete("test","two","7 4", "may", "lol");
    
    AthleteComparator test = new AthleteComparator();
    System.out.println(test.compare(test1,test2));
  }
}