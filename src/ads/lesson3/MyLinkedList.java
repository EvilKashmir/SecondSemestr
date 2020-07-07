package ads.lesson3;

import java.util.*;

public class MyLinkedList<T> {

    private Node head, tail;
    private int size;

    public MyLinkedList() {
        this.size = 0;
    }

    public void add(T t) {
        Node node = new Node(t);
        if (size == 0) {
            head = node;
            tail = node;
            node.next = null;
        } else {
            tail.next = node;
            tail = node;
            node.next = null;
        }
        size++;
    }

    public void addFirst(T t) {
        if (isEmpty())
            add(t);
        else {
            Node node = new Node(t);
            node.next = head;
            head = node;
            size++;
        }
    }

    public void addAfter(T t, int pos) {
        if (pos < 0 || pos > size) throw new IllegalArgumentException();
        LinkedListIterator it = new LinkedListIterator();
        Node node = new Node(t);
        if (pos == 0) {
            addFirst(t);
            return;
        }
        if (pos == size) {
            add(t);
            return;
        }
        while (it.hasNext()) {
            if (pos-- == 1) {
                node.next = it.cursor.next;
                it.cursor.next = node;
                size++;
                return;
            } else
                it.next();
        }
    }

    public int size() {
        return size;
    }

    public T get(int pos) {
        if (isEmpty()) throw new NullPointerException();
        if (pos > size || pos < 1) throw new IllegalArgumentException();
        LinkedListIterator it = new LinkedListIterator();
        while (it.hasNext()) {
            if (pos-- == 1)
                return it.cursor.data;
            it.next();
        }
        throw new NoSuchElementException();
    }

    public T getFirst() {
        if (isEmpty()) throw new NullPointerException();
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) throw new NullPointerException();
        return tail.data;
    }

    public void removeFrom(int pos) {
        if (isEmpty()) throw new NullPointerException();
        if (pos > size || pos < 1) throw new IllegalArgumentException();
        LinkedListIterator it = new LinkedListIterator();
        if (pos == 1) {
            head = head.next;
            size--;
            return;
        }
        int count = 2;
        while (it.hasNext()) {
            if (count == size) {
                tail = it.cursor;
                tail.next = null;
                size--;
                return;
            } else if (count == pos) {
                it.cursor.next = it.cursor.next.next;
                size--;
                return;
            } else {
                count++;
                it.next();
            }
        }
    }

    public void remove(T t) {
        removeFrom(indexOf(t));
    }

    public int indexOf(T t) {
        if (isEmpty()) throw new NullPointerException();
        LinkedListIterator it = new LinkedListIterator();
        Node node = new Node(t);
        int pos = 1;
        while (it.hasNext()) {
            if (node.equals(it.cursor))
                return pos;
            pos++;
            it.next();
        }
        throw new NoSuchElementException();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public MyLinkedList<T> merge(MyLinkedList<T> list) {
        MyLinkedList<T> res = new MyLinkedList<>();
        LinkedListIterator it1 = new LinkedListIterator();
        LinkedListIterator it2 = new LinkedListIterator(list);
        while (it1.hasNext()) {
            res.add(it1.cursor.data);
            it1.next();
        }
        while (it2.hasNext()) {
            res.add(it2.cursor.data);
            it2.next();
        }
        return res;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Empty!";
        StringBuilder sb = new StringBuilder();
        LinkedListIterator it = new LinkedListIterator();
        while (it.hasNext()) {
            sb.append(it.cursor.toString());
            if (it.cursor.next != null) sb.append(" --> ");
            it.next();
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return this.toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    private class Node {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data);
        }

        @Override
        public String toString() {
            return "[ " + data + " ]";
        }
    }

    private class LinkedListIterator implements Iterator<Node> {

        private Node cursor;

        public LinkedListIterator() {
            this.cursor = head;
        }

        public LinkedListIterator(MyLinkedList<T> list) {
            this.cursor = list.head;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Node next() {
            try {
                return cursor = cursor.next;
            } catch (NullPointerException ex) {
                throw new java.util.NoSuchElementException();
            }
        }
    }
}
