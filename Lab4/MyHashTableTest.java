import junit.framework.TestCase;

public class MyHashTableTest extends TestCase{
  
  public void testInsert(){
    MyHashTable test = new MyHashTable(10);
    test.insert(31,100);
    assertTrue(test.buckets[1].get(0).getKey()==31);
    
    test.insert(1,110);
    test.insert(41,101);
    test.insert(11,150);
    test.insert(21,109);
    
    assertTrue(test.buckets[1].get(0).getKey()==21);
    assertTrue(test.buckets[1].get(2).getKey()==41);
    
  }
  
  public void testFind(){
    MyHashTable test = new MyHashTable(10);
    test.insert(31,100);
    test.insert(1,110);
    test.insert(41,101);
    test.insert(11,150);
    test.insert(21,109);
    
    assertTrue(test.find(31)!=null);
  }
  
  public void testHash(){
    MyHashTable test = new MyHashTable(10);
    assertTrue(test.hash(158326)==158326%10);
    assertTrue(test.hash(0)==0%10);
  }
  
  public void testGetLoadFactor(){
    int size = 100;
    MyHashTable test = new MyHashTable(size);
    Wheel testWheel = new Wheel(126408273,size);
    for(int i=0; i<size; i++) test.insert(testWheel.spin(), testWheel.spin());
    assertTrue(test.getLoadFactor()==(test.getNumElements()*100.0)/size);
  }
  
  public void testGetNumElements(){
    int size = 100;
    MyHashTable test = new MyHashTable(size);
    Wheel testWheel = new Wheel(126408273,size);
    for(int i=0; i<size; i++) test.insert(testWheel.spin(), testWheel.spin());
    assertTrue(test.getNumElements()==size);
  }
  
  public void testReturnMaxNumInLL(){
    int size = 1000000;
    MyHashTable testTable = new MyHashTable(size);
    Wheel testWheel = new Wheel(639162937,size);
    for(int i = 0; i<size; i++) testTable.insert(testWheel.spin(), testWheel.spin());
    assertTrue(testTable.returnMaxNumInLL() > 0);
  }
  
}