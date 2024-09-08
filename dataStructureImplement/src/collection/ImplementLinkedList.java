package collection;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ImplementLinkedList<E> {

    private Node<E> head;
    private Node<E> last;
    private int size = 0;

    public void addLast(E value) {

    }

    public void addFirts(E value) {

    }

    public void removeFirst() {

    }

    public void removeList() {

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

        public Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

}
