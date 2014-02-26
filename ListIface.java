/**
 * Created by mejty on 25.2.14.
 */
/**
 * Rozhrani, jez definuje operace, ktere musi splnit kazda implementace seznamu
 * @author Pavel Micka
 * @editor mejty
 */
public interface ListIface<T> {

    /**
     * Vlozi na konec seznamu prvek
     * @param i prvek k vlozeni
     */
    public void add(T value);

    /**
     * Vrati prvek na indexu i
     * @param i index prvku
     * @return prvek na indexu i
     */
    public T get(int i);

    /**
     * Smaze prvek na indexu i
     * @param i index mazaneho prvku
     */
    public void remove(int i);

    /**
     * Dotaz na delku seznamu
     * @return delka seznamu
     */
    public int getSize();
}