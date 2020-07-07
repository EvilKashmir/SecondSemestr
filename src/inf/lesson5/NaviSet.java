/**
 * My implementation NavigableSet.
 * @author EvilKashmir
 */

package inf.lesson5;

import java.util.*;

public class NaviSet<T> extends AbstractSet<T> implements NavigableSet<T> {

    private ArrayList<T> data;
    private Comparator<T> comparator;

    /**
     * Empty constructor for NavigableSet.
     */
    public NaviSet() {
        this.data = new ArrayList<>();
        this.comparator = new NaviComparator<T>();
    }

    /**
     * Constructor with comparator for NavigableSet.
     * @param comparator
     */
    public NaviSet(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Constructor with all parameters.
     * @param data
     * @param comparator
     */
    public NaviSet(ArrayList<T> data, Comparator<T> comparator) {
        this.data = data;
        this.comparator = comparator;
    }
    /**
     * @param t
     * @return the greatest element in this set strictly less than the given element, or null if there is no such element.
     */
    @Override
    public T lower(T t) {
        if (size() == 0) {
            return null;
        }
        for (int i = 0; i < size(); i++) {
            if (comparator.compare(data.get(i), t) > 0) {
                if (i != 0) {
                    return data.get(i - 1);
                }
                else {
                    return null;
                }
            }
            else if (i == size() - 1) return data.get(i);
        }
        return null;
    }

    /**
     * @param t
     * @return the greatest element in this set less than or equal to the given element, or null if there is no such element.
     */
    @Override
    public T floor(T t) {
        if(size() == 0) {
            return null;
        }
        for (int i = 0; i < size(); i++) {
            if (comparator.compare(data.get(i), t) >= 0) {
                if (i != 0) {
                    return data.get(i - 1);
                }
                else {
                    return null;
                }
            }
            else if (i == size() - 1) return data.get(i);
        }
        return null;
    }

    /**
     * @param t
     * @return the least element in this set greater than or equal to the given element, or null if there is no such element.
     */
    @Override
    public T ceiling(T t) {
        if (size() == 0) {
            return null;
        }
        for (int i = 0; i < size(); i++) {
            if (comparator.compare(data.get(i), t) >= 0) {
                return data.get(i - 1);
            }
        }
        return null;
    }

    /**
     * @param t
     * @return the least element in this set strictly greater than the given element, or null if there is no such element.
     */
    @Override
    public T higher(T t) {
        if (size() == 0) {
            return null;
        }
        for (int i = 0; i < size(); i++) {
            if (comparator.compare(data.get(i), t) > 0) {
                return data.get(i - 1);
            }
        }
        return null;
    }

    /**
     * Retrieves and removes the first (lowest) element, or returns null if this set is empty.
     * @return the first removed element or null
     */
    @Override
    public T pollFirst() {
        if (size() == 0){
            return null;
        }
        T temp = data.get(0);
        data.remove(0);
        return temp;
    }

    /**
     * Retrieves and removes the last (highest) element, or returns null if this set is empty.
     * @return the last removed element or null
     */
    @Override
    public T pollLast() {
        if (size() == 0){
            return null;
        }
        T temp = data.get(size() - 1);
        data.remove(size() - 1);
        return temp;
    }

    /**
     * Add element in NaviSet.
     * @param el
     * @return true if element added or false if element didn't add
     */
    @Override
    public boolean add(T el) {
        if (data.size() == 0) {
            data.add(el);
            return true;
        }
        for (int i = 0; i < size(); i++) {
            if(comparator.compare(data.get(i), el) == 0)
                return false;
            else if (this.comparator.compare(data.get(i), el) > 0) {
                data.add(i, el);
                return true;
            }
        }
        data.add(size(), el);
        return true;
    }

    /**
     * @return an iterator over the elements in this set.
     */
    @Override
    public Iterator<T> iterator() {
        return new NaviIterator();
    }

    /**
     * @return a reverse order view of the elements contained in this set.
     */
    @Override
    public NavigableSet<T> descendingSet() {
        NaviSet<T> revSet = new NaviSet<>(data, comparator);
        revSet.data.sort(Collections.reverseOrder());
        return revSet;
    }

    /**
     * @return an iterator over the elements in this set, in descending order.
     */
    @Override
    public Iterator<T> descendingIterator() {
        return new NaviDescendingIterator();
    }

    /**
     * @param fromElement
     * @param fromInclusive
     * @param toElement
     * @param toInclusive
     * @return a view of the portion of this set whose elements range from fromElement to toElement.
     */
    @Override
    public NavigableSet<T> subSet(T fromElement, boolean fromInclusive, T toElement, boolean toInclusive) {
        if (toElement == null || fromElement == null)
            throw new NullPointerException();
        if (comparator.compare(fromElement, toElement) > 0)
            throw new IllegalArgumentException();
        NaviSet<T> result = new NaviSet<>(new ArrayList<>(), comparator);
        boolean flag = false;
        for (T el : data) {
            if (!flag && comparator.compare(el, fromElement) >= 0){
                if (fromInclusive && comparator.compare(el, fromElement) == 0)
                    result.data.add(el);
                else if (comparator.compare(el, fromElement) > 0)
                    result.data.add(el);
                flag = true;
            }
            else if(flag && comparator.compare(el, toElement) < 0) {
                result.add(el);
            }
            else if(toInclusive && comparator.compare(el, toElement) == 0)
                result.add(el);
        }
        return result;
    }

    /**
     * @param toElement
     * @param inclusive
     * @return a view of the portion of this set whose elements are less than (or equal to, if inclusive is true) toElement.
     */
    @Override
    public NavigableSet<T> headSet(T toElement, boolean inclusive) {
        if(toElement == null) throw new NullPointerException();
        if(comparator.compare(data.get(0), toElement) > 0) throw new IllegalArgumentException();
        return subSet(data.get(0), true, toElement, inclusive);
    }

    /**
     * @param fromElement
     * @param inclusive
     * @return a view of the portion of this set whose elements are greater than (or equal to, if inclusive is true) fromElement.
     */
    @Override
    public NavigableSet<T> tailSet(T fromElement, boolean inclusive) {
        if(fromElement == null) throw new NullPointerException();
        if(comparator.compare(data.get(size() - 1), fromElement) < 0) throw new IllegalArgumentException();
        return subSet(fromElement, inclusive, data.get(size() - 1), true);
    }

    /**
     * @return comparator for our NavigableSet.
     */
    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    /**
     * @param fromElement
     * @param toElement
     * @return a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive.
     */
    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        SortedSet<T> result = new NaviSet<>(new ArrayList<>(), comparator);
        if (fromElement == null || toElement == null)
            throw new NullPointerException();
        if (comparator.compare(fromElement, toElement) > 0)
            throw new IllegalArgumentException();
        if (comparator.compare(fromElement, toElement) == 0)
            return result;
        result = subSet(fromElement, true, toElement, false);
        return result;
    }

    /**
     * @param toElement
     * @return a view of the portion of this set whose elements are less than (or equal to, if inclusive is true) toElement.
     */
    @Override
    public SortedSet<T> headSet(T toElement) {
        SortedSet<T> result = headSet(toElement, false);
        return result;
    }

    /**
     * @param fromElement
     * @return a view of the portion of this set whose elements are greater than or equal to fromElement.
     */
    @Override
    public SortedSet<T> tailSet(T fromElement) {
        SortedSet<T> result = tailSet(fromElement,true);
        return result;
    }

    /**
     * @return the first element.
     */
    @Override
    public T first() {
        return data.get(0);
    }

    /**
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), data);
    }

    /**
     * @param o
     * @return true if our NavigableSets equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NaviSet<?> that = (NaviSet<?>) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public T[] toArray() {
        return (T[]) data.toArray();
    }

    /**
     * Transform into string
     * @return string view of data
     */
    public String toString() {
        return data.toString();
    }

    /**
     * @return the last element
     */
    @Override
    public T last() {
        return data.get(size() - 1);
    }

    /**
     * @return size of NaviSet
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Iterator for NaviSet
     */
    private class NaviIterator implements Iterator<T> {

        private int cursor;

        private NaviIterator() {cursor = 0;}

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public T next() {
            try {
                return data.get(cursor++);
            } catch (IndexOutOfBoundsException e) {
                throw  new NoSuchElementException();
            }
        }
    }

    /**
     * Descending iterator for NaviSet
     */
    private class NaviDescendingIterator implements Iterator<T> {

        private int cursor;

        private NaviDescendingIterator() {cursor = size() - 1;}

        @Override
        public boolean hasNext() {
            return cursor > 0;
        }

        @Override
        public T next() {
            try {
                return data.get(cursor--);
            } catch (IndexOutOfBoundsException e) {
                throw  new NoSuchElementException();
            }
        }
    }

    /**
     * Comparator for our NavigableSet
     * @param <T>
     */
    private class NaviComparator<T> implements Comparator<T>{

        @Override
        public int compare(T o1, T o2) {
            return o1.toString().compareTo(o2.toString());
        }
    }
}
