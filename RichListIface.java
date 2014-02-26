/**
 * Created by mejty on 25.2.14.
 */
public interface RichListIface<T extends Comparable<T>> extends ListIface<T> {
    public boolean isOrdered();
    public void addOrdered(T value);
    public boolean isUnique();
    public void addUnique(T value);
    public void removeAll(T value);
}