package collection;

import java.util.NoSuchElementException;

public class ImplementLinkedList<E> {

    private Node<E> head;
    private Node<E> last;
    private int size = 0;

    public void addLast(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(value, null, l);
        last = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void addFirts(E value) {
        final Node<E> prevHead = this.head;
        final Node<E> newNod = new Node<>(value, head, null);
        this.head = newNod;
        if (prevHead == null) {
            this.last = newNod;
        } else {
            prevHead.prev = newNod;
        }
        size++;

    }

    public void removeFirst() {
        if (head == null)
            throw new NoSuchElementException();

        Node<E> next = head.next;
        head.item = null;
        head.next = null;
        head = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
    }

    public void removeList() {
        if (last == null)
            throw new NoSuchElementException();
        Node<E> prev = last.prev;
        last.item = null;
        last.prev = null;
        last = prev;
        if (prev == null)
            head = null;
        else
            prev.next = null;
        size--;
    }

    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return this.head.item;
    }

    public E getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return this.last.item;
    }

    public E getByIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<E> x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x.item;
    }


    public static class Node<E> {

        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

}
