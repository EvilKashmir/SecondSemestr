import java.util.*;

public class MyMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {

    private ArrayList<K> keys;
    private ArrayList<V> values;

    public MyMap() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public MyMap(ArrayList<K> keys, ArrayList<V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("Wrong size!");
        }
        this.keys = keys;
        this.values = values;
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            throw new NullPointerException("Null element");
        }
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            throw new NullPointerException("Null element");
        }
        return keys.contains(value);
    }

    @Override
    public V get(Object key) {
        if (key == null) throw new NullPointerException();
        for (int i = 0; i < size(); i++) {
            if (keys.get(i).equals(key)) {
                return values.get(i);
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        for (int i = 0; i < size(); i++) {
            if (keys.get(i).equals(key)) {
                V old = values.get(i);
                values.set(i, value);
                return old;
            }
        }
        keys.add(key);
        values.add(value);
        return null;
    }

    @Override
    public V remove(Object key) {
        if (key == null) throw new NullPointerException();
        for (int i = 0; i < size(); i++) {
            if (keys.get(i).equals(key)) {
                V val = values.get(i);
                keys.remove(i);
                values.remove(i);
                return val;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Set<? extends Entry<? extends K, ? extends V>> eSet = m.entrySet();
        Iterator<Entry<K, V>> it = (Iterator<Entry<K, V>>) eSet.iterator();
        while (it.hasNext()) {
            Entry<K, V> el = it.next();
            this.put(el.getKey(), el.getValue());
        }
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Set<K> keySet() {
        return new HashSet<>(keys);
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<Entry<K, V>> entryHashSet = new HashSet<>();
        for (int i = 0; i < this.keys.size(); i++) {
            entryHashSet.add(new MyEntry(this.keys.get(i), this.values.get(i)));
        }
        return entryHashSet;
    }

    private class MyEntry<K, V> implements Entry<K, V> {

        K key;
        V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(Object value) {
            if (value == null) throw new NullPointerException();
            V old = this.value;
            this.value = (V) value;
            return old;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.keys.size(); i++) {
            sb.append("( " + keys.get(i) + " <-> " + values.get(i) + " );");
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), keys, values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MyMap<?, ?> myMap = (MyMap<?, ?>) o;
        return Objects.equals(keys, myMap.keys) &&
                Objects.equals(values, myMap.values);
    }
}
