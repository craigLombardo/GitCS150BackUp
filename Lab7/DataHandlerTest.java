import junit.framework.TestCase;

public class DataHandlerTest extends TestCase {
  
  public void testGetDataPass(){
    DataHandler test1 = new DataHandler("inputInfo.txt","passedTest.txt");
    
    test1.getData();
    
    //This creates a data handler that has no valid input file, thus when
    //it tries to get the data, it cannot.
    DataHandler test2 = new DataHandler("notHere.txt","failedTest.txt");
    
    try{
      test2.getData();
      assertTrue(false);
    }
    catch(NullPointerException e){
      assertTrue(true);
    }
    
    
  }
  
  public void testGetDataFail(){
    //This creates a data handler that has no valid input file, thus when
    //it tries to get the data, it cannot.
    DataHandler test = new DataHandler("notHere.txt","failedTest.txt");
    try{
      test.getData();
      assertTrue(false);
    }
    catch(NullPointerException e){
      assertTrue(true);
    }
    
  }
  
  public void exportData(){
    DataHandler test = new DataHandler("inputInfo.txt","passedTest.txt");
    
    test.getData();
    test.exportData();
    //should there be no errors writing out, if so then the test passes
  }
  
  
}