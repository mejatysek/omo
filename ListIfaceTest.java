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
        assertEquals("Velikost listu po přidani 6 polozek neni 6, ale: "+list.getSize(),list.getSize(),6);
        for (int i = 1; i < list.getSize()+1; i++) {
            assertEquals("Polozky nejsou ve spravnem poradi, polozka c:"+i+" hodnoty: ocekavana: "+(i)+" vracena; "+(int) list.get(i),(int) list.get(i), i);
        }
    }

    @Test
    public void testRemove() throws Exception {
        listFill();
        list.remove(1);
        assertEquals("Po smazani prvniho prvku nema list velikost 5, ale: "+list.getSize(),list.getSize(), 5);
        list.remove(5);
        assertEquals("Po smazani posledniho prvku nema list velikost 4, ale: "+list.getSize(),list.getSize(),4);
        list.remove(2);
        assertEquals("Po smazani druheho prvku nema list velikost 3, ale: "+list.getSize(),list.getSize(),3);
        for (int i = 1; i < list.getSize()+1; i++) {
            if(i>1){
                assertEquals("Smazana spatná polozka. Hodnoty: ocekavana: "+(i+2)+" vracena; "+(int) list.get(i),(int) list.get(i), i+2);
            }else{
            assertEquals("Smazana spatná polozka. Hodnoty: ocekavana: "+(i+1)+" vracena; "+(int) list.get(i),(int) list.get(i), i+1);
            }
        }
    }

    @Test
    public void testGetSize() throws Exception {
        list= new Jednosmerny<Integer>();
        assertEquals("Prazdny list nema velikost 0, ale: "+list.getSize(),list.getSize(),0);
        list.add(1);
        assertEquals("List s jednim prvkem nema velikost 1, ale: "+list.getSize(),list.getSize(),1);
        list.add(2);
        assertEquals("List s dma prvky nema velikost 2"+list.getSize(),list.getSize(),2);

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
