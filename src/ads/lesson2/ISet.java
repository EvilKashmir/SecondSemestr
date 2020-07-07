package ads.lesson2;

public interface ISet<T> {
    public boolean add(T obj);
    public boolean contains(T obj);
    public int size();
    public boolean remove(T obj);
}
