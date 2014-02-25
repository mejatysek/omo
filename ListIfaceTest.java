import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mejty on 25.2.14.
 */
public class ListIfaceTest {
    private ListIface<Integer> list;
    @Test
    public void testAddGet() throws Exception {
        listFill();
        assertEquals(list.getSize(),6);
        for (int i = 1; i < list.getSize()+1; i++) {
            assertEquals("Ocekavana: "+(i)+" vracena; "+(int) list.get(i),(int) list.get(i), i);
        }
    }

    @Test
    public void testRemove() throws Exception {
        listFill();
        list.remove(1);
        assertEquals(list.getSize(), 5);
        list.remove(5);
        assertEquals(list.getSize(),4);
        list.remove(2);
        assertEquals(list.getSize(),3);
        for (int i = 1; i < list.getSize()+1; i++) {
            if(i>1){
                assertEquals("Ocekavana: "+(i+2)+" vracena; "+(int) list.get(i),(int) list.get(i), i+2); 
            }else{
            assertEquals("Ocekavana: "+(i+1)+" vracena; "+(int) list.get(i),(int) list.get(i), i+1);
            }
        }
    }

    @Test
    public void testGetSize() throws Exception {
        list= new Jednosmerny<Integer>();
        assertEquals(list.getSize(),0);
        list.add(1);
        assertEquals(list.getSize(),1);
        list.add(2);
        assertEquals(list.getSize(),2);

    }
    private void listFill() {
        list=new Jednosmerny<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
    }
}
