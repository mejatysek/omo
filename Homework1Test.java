import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mejty on 19.2.14.
 */
public class Homework1Test {
    Homework1 i1= new Homework1();
    Homework1 i2= new Homework1();
    Homework1 i3= new Homework1();
    @Test
    public void testF() throws Exception {
        Assert.assertEquals("Medoda f() ma vracet true", true, i1.f());
    }

    @Test
    public void testG() throws Exception {
        Assert.assertEquals("Medoda g() ma vracet false", false, Homework1.g());
    }

    @Test
    public void testH() throws Exception {
        Assert.assertEquals("Prvni volani metody h() má vracet 1",1,i1.h());
        Assert.assertEquals("Druhe volani metody h() má vracet 2",2,i1.h());
        Assert.assertEquals("Prvni volani metody h() má vracet 1",1,i2.h());
    }

    @Test
    public void testI() throws Exception {
        Assert.assertEquals("Prvni volani metody i() má vracet 1",1,i1.i());
        Assert.assertEquals("Druhe volani metody i() má vracet 2",2,i1.i());
        Assert.assertEquals("Treti volani metody i() má vracet 3",3,i2.i());
        i1=new Homework1();
        Assert.assertEquals("Prvni volani metody h() má vracet 1",1,i1.h());
        Assert.assertEquals("Ctvrte volani metody i() má vracet 4",4,i3.i());
    }
}
