import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Rozhrani, jez definuje operace, ktere musi splnit kazda implementace seznamu
 * @author Matej Mihal
 * @contributor Lukas Tomcik
 */
public class ListIfaceTest {
    private ListIface<Integer> list;
    /**
     * Pokud ve svem LinkedListu indexujete od nuly zmente INITIAL_INDEX_POSITION na 0
     */
    private final int INITIAL_INDEX_POSITION = 1;

    @Test
    public void testAddGet() throws Exception {
        listFill();
        assertEquals("Velikost listu po přidani 6 polozek neni 6, ale: "+list.getSize(),list.getSize(),6);
        for (int i = INITIAL_INDEX_POSITION; i < list.getSize()+INITIAL_INDEX_POSITION; i++) {
            assertEquals("Polozky nejsou ve spravnem poradi, polozka c:"+i+" hodnoty: ocekavana: "+(i+1-INITIAL_INDEX_POSITION)+" vracena; "+(int) list.get(i),(int) list.get(i), i+1-INITIAL_INDEX_POSITION);
        }
    }

    @Test
    public void testRemove() throws Exception {
        listFill();
        list.remove(INITIAL_INDEX_POSITION);
        assertEquals("Po smazani prvniho prvku nema list velikost 5, ale: " + list.getSize(), list.getSize(), 5);
        list.remove(4 + INITIAL_INDEX_POSITION);
        assertEquals("Po smazani posledniho prvku nema list velikost 4, ale: " + list.getSize(), list.getSize(), 4);
        list.remove(1+INITIAL_INDEX_POSITION);
        assertEquals("Po smazani druheho prvku nema list velikost 3, ale: "+list.getSize(),list.getSize(),3);
        for (int i = INITIAL_INDEX_POSITION; i < list.getSize()+INITIAL_INDEX_POSITION; i++) {
            if(i>INITIAL_INDEX_POSITION){
                assertEquals("Smazana spatná polozka. Hodnoty: ocekavana: "+(i+3-INITIAL_INDEX_POSITION)+" vracena; "+(int) list.get(i),(int) list.get(i), i+3-INITIAL_INDEX_POSITION);
            }else{
            assertEquals("Smazana spatná polozka. Hodnoty: ocekavana: "+(i+2-INITIAL_INDEX_POSITION)+" vracena; "+(int) list.get(i),(int) list.get(i), i+2-INITIAL_INDEX_POSITION);
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
        for (int i = 1; i < 7; i++) {
            list.add(i);
        }
    }
}
