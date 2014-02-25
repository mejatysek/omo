/**
 * Rozhrani pouzito s mirnou upravou ze zdroje publikovaneho cvicim.
 * Upraven byl nazev parametru v metode add, jelikoz nazev value popisuje ucel parametru vystizneji,
 * a byl pridan datovy typ k nazvu tridy, cehoz muzeme vyuzit pro vytvareni seznamu i s jinymi hodnotami
 * nez typu int.
 */
/**
 * Rozhrani, jez definuje operace, ktere musi splnit kazda implementace seznamu
 * @author Pavel Micka
 * @editor mejty
 */
public interface ListIface<T> {

    /**
     * Vlozi na konec seznamu prvek
     * @param value prvek k vlozeni
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