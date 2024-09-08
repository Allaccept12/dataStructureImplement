package collection;

import java.util.Objects;

public class ImplementList<T> {
    private Object[] array;
    private int size;
    private final int INIT_CAPACITY = 5;

    public ImplementList() {
        array = new Object[INIT_CAPACITY];
        size = 0;
    }

    public void add(T value) {
        if (size == array.length) {
            array = new Object[array.length * 2];
        }
        array[size++] = value;
    }

    public void addAll(T[] values) {
        if (values == null || values.length == 0) {
            return;
        }
        if (array.length - size <= values.length) {
            int capacity = Math.max(size + values.length, array.length * 2);
            Object[] tempArray = new Object[capacity];
            for (int i = 0; i < size-1; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
        for (T value : values) {
            array[size++] = value;
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, array.length);
        return (T) array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        T removedItem = (T) array[index];

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i+1];
        }

        size--;

    }
}
