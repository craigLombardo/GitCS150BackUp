import junit.framework.TestCase;

public class MyFirstUnitTest extends TestCase {
  
  public void testAddInts(){
    UnitTesting intTest = new UnitTesting();
    intTest.addInt(1);
    assertTrue(intTest.getIntTotal()==1);
    
    intTest.addInt(10);
    assertTrue(intTest.getIntTotal()==11);
    
    intTest.addInt(-11);
    assertTrue(intTest.getIntTotal()==0);
    
    intTest.addInt(-1237439284);
    assertTrue(intTest.getIntTotal()==-1237439284);
    
    intTest.addInt(0);
    assertTrue(intTest.getIntTotal()==-1237439284);
  }
  
  public void testAddDoubles(){
    UnitTesting doubleTest = new UnitTesting();
    doubleTest.addDouble(100.0);
    assertTrue(doubleTest.getDoubleTotal()==100.0);
    
    doubleTest.addDouble(-73.25);
    assertTrue(doubleTest.getDoubleTotal()==26.75);
    
    doubleTest.addDouble(-37182391823.47283947);
    assertTrue(doubleTest.getDoubleTotal()==-37182391796.72283947);
    
    doubleTest.addDouble(0.0);
    assertTrue(doubleTest.getDoubleTotal()==-37182391796.72283947);
  }
  
  public void testAddString(){
    UnitTesting stringTest = new UnitTesting();
    assertTrue(stringTest.getString().equals(""));
    
    stringTest.addString("Hello");
    assertTrue(stringTest.getString().equals("Hello "));
    
    stringTest.addString("");
    assertTrue(stringTest.getString().equals("Hello "));
    
    //Three Spaces
    stringTest.addString("   ");
    assertTrue(stringTest.getString().equals("Hello     "));
    
    stringTest.addString("World");
    assertTrue(stringTest.getString().equals("Hello     World "));
  }
  
  
  
  public void testGetIntTotal(){
    UnitTesting test = new UnitTesting();
    assertTrue(test.getIntTotal()==0);
    
    test.addInt(1234);
    assertTrue(test.getIntTotal()==1234);
    
    test.addInt(-12345);
    assertTrue(test.getIntTotal()==-11111);
    
    test.addInt(0);
    assertTrue(test.getIntTotal()==-11111);
  }
  
  public void testGetDoubleTotal(){
    UnitTesting test = new UnitTesting();
    assertTrue(test.getDoubleTotal()==0.0);
    
    test.addDouble(12368.52515625);
    assertTrue(test.getDoubleTotal()==12368.52515625);
    
    test.addDouble(-18.559);
    assertTrue(test.getDoubleTotal()==12349.96615625);

    test.addDouble(-16293753645189.96615625);
    assertTrue(test.getDoubleTotal()==-16293753632840.0);
    
    test.addDouble(0);
    assertTrue(test.getDoubleTotal()==-16293753632840.0);
  }
  
  public void testgetString(){
    UnitTesting test = new UnitTesting();
    assertTrue(test.getString()=="");
    
    test.addString("Hello");
    assertTrue(test.getString().equals("Hello "));
    
    test.addString("");
    assertTrue(test.getString().equals("Hello "));
    
    test.addString("World");
    assertTrue(test.getString().equals("Hello World "));
    
    test.addString("My name is Craig\n%&^(");
    assertTrue(test.getString().equals("Hello World My name is Craig\n%&^( "));
    
  }
  
  public void testCheckInputFile(){
    UnitTesting test = new UnitTesting();
    assertTrue(test.checkInputFile("unitTestInputCheck.txt"));
    
    assertFalse(test.checkInputFile(""));
    
    assertFalse(test.checkInputFile("notInMyDirectory.txt"));
    
    assertFalse(test.checkInputFile(null));
  }
  
}
