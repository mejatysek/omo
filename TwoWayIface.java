package cv02;

public interface TwoWayIface {
    public void add(int value);
    public int get(int i);
    public void remove(int i);
    public int getSize();

    public boolean isOrdered();
    public void addOrdered(int value);
    public boolean isUnique();
    public void addUnique(int value);
    public void removeAll(int value);
}