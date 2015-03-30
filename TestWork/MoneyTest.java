import junit.framework.*;

public class MoneyTest extends TestCase {

    public void testEquals() {
        Money m12CHF= new Money(12, "CHF");
        Money m14CHF= new Money(14, "CHF");

        Assert.assertTrue(!m12CHF.equals(null));
        Assert.assertEquals(m12CHF, m12CHF);
        Assert.assertEquals(m12CHF, new Money(12, "CHF")); 
        Assert.assertTrue(!m12CHF.equals(m14CHF));
    }
}