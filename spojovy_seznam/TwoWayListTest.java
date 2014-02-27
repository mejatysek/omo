

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * radky 11, 12, 16 a 18 si upravte tak, aby odpovidaly vasi implementaci
 * @author Lukas Tomcik
 *
 */
public class TwoWayListTest {
    private TwoWayIface list;
    /**
     * INDEX_BASE = 0 pri indexovani od 0, pro seznamy indexovane od 1 INDEX_BASE = 1
     */
    private static final int INDEX_BASE = 0;
    private void buildList() {
        this.list = new TwoWayList();
    }
    private String printList() {
        String output = "";
        for (int i=INDEX_BASE; i<this.list.getSize()+INDEX_BASE; i++) {
            output += "("+this.list.get(i)+")<->";
        }
        return (output.endsWith("<->"))?output.substring(0,output.length()-3):output;
    }

    @Test
    public void testIsOrdered() throws Exception {
        buildList();
        assertEquals("Ja bych rekl, ze prazdny seznam je serazeny", true, list.isOrdered());
        for (int i=INDEX_BASE; i<5+INDEX_BASE; i++)
            this.list.add(i);
        assertEquals("Serazeny seznam nebyl rozpoznan: " + printList(), true, list.isOrdered());
        this.list.add(5 + INDEX_BASE - 1);
        this.list.add(5 + INDEX_BASE);
        assertEquals("Serazeny seznam nebyl rozpoznan: " + printList(), true, list.isOrdered());
        this.list.add(3 + INDEX_BASE);
        assertEquals("Neserazeny seznam nebyl rozpoznan: " + printList(), false, list.isOrdered());
        this.list.add(4 + INDEX_BASE);
        this.list.add(5 + INDEX_BASE);
        assertEquals("Neserazeny seznam nebyl rozpoznan: " + printList(), false, list.isOrdered());
        buildList();
        this.list.add(1);
        assertEquals("Serazeny seznam nebyl rozpoznan: " + printList(), true, list.isOrdered());
        this.list.add(1);
        assertEquals("Serazeny seznam nebyl rozpoznan: " + printList(), true, list.isOrdered());
        this.list.add(0);
        assertEquals("Neserazeny seznam nebyl rozpoznan: " + printList(), false, list.isOrdered());
    }

    @Test
    public void testAddOrdered() throws Exception {
        buildList();
        this.list.addOrdered(3);
        this.list.addOrdered(1);
        assertEquals("Metoda addOrdered nevytvari serazeny seznam: " + printList(), true, list.isOrdered());
        this.list.addOrdered(2);
        assertEquals("Metoda addOrdered nevytvari serazeny seznam: " + printList(), true, list.isOrdered());
        this.list.addOrdered(4);
        this.list.addOrdered(5);
        assertEquals("Metoda addOrdered nevytvari serazeny seznam: " + printList(), true, list.isOrdered());
        this.list.addOrdered(4);
        assertEquals("Metoda addOrdered nevytvari serazeny seznam: " + printList(), true, list.isOrdered());
    }

    @Test
    public void testIsUnique() throws Exception {
        buildList();
        assertEquals("Prazdny seznam neobsahuje zadne duplicitni zaznamy", true, list.isUnique());
        this.list.add(1);
        assertEquals("Seznam [" + printList() + "] neobsahuje duplicitni zaznamy", true, list.isUnique());
        this.list.add(2);
        assertEquals("Seznam [" + printList() + "] neobsahuje duplicitni zaznamy", true, list.isUnique());
        this.list.add(1);
        assertEquals("Seznam obsahuje duplicitni zaznamy: " + printList(), false, list.isUnique());
        this.list.add(1);
        assertEquals("Seznam obsahuje duplicitni zaznamy: " + printList(), false, list.isUnique());
        this.list.add(2);
        assertEquals("Seznam obsahuje duplicitni zaznamy: " + printList(), false, list.isUnique());
    }

    @Test
    public void testAddUnique() throws Exception {
        buildList();
        this.list.addUnique(1);
        this.list.addUnique(2);
        assertEquals("Seznam ma obsahovat 2 unikatni zaznamy: " + printList(), 2, list.getSize());
        this.list.addUnique(1);
        assertEquals("Seznam ma obsahovat 2 unikatni zaznamy: " + printList(), 2, list.getSize());
        this.list.addUnique(2);
        this.list.addUnique(1);
        assertEquals("Seznam ma obsahovat 2 unikatni zaznamy: " + printList(), 2, list.getSize());
        assertEquals("Seznam ma obsahovat pouze unikatni zaznamy " + printList(), true, list.isUnique());
        buildList();
        this.list.add(1);
        this.list.addUnique(1);
        this.list.addUnique(1);
        assertEquals("Seznam ma obsahovat pouze jeden zaznam", 1, list.getSize());
        assertEquals("Seznam ma obsahovat pouze unikatni zaznamy", true, list.isUnique());
    }

    @Test
    public void testRemoveAll() throws Exception {
        buildList();
        this.list.add(0);
        this.list.add(1);
        this.list.add(0);
        this.list.add(1);
        this.list.add(3);
        this.list.add(2);
        this.list.add(2);
        this.list.add(0);
        this.list.removeAll(4);
        assertEquals("Odebirani zaznamu s hodnotou 3 nemuzu ovlivnit seznam se zaznamy nabivajicimi pouze hodnot 0-3", 8, list.getSize());
        this.list.removeAll(3);
        assertEquals("Odebirani zaznamu neprobehlo spravne", 7, list.getSize());
        this.list.removeAll(2);
        assertEquals("Odebirani dvou po sobe jdoucich zaznamu neprobehlo spravne", 5, list.getSize());
        this.list.removeAll(0);
        assertEquals("Odebirani krajnich zaznamu neprobehlo spravne", 2, list.getSize());
        this.list.removeAll(1);
        assertEquals("Odebirani poslednich zaznamu ktere seznam obsahuje neprobehlo spravne", 0, list.getSize());
    }
}