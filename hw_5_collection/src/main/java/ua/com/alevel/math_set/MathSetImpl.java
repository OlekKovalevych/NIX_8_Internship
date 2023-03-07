package ua.com.alevel.math_set;

import java.util.Arrays;

public class MathSetImpl<E extends Number & Comparable> implements MathSet<E> {

    private int INIT_CAPACITY = 8;
    private Object[] objArray;
    private int size = 0;

    public MathSetImpl() {
        objArray = new Object[INIT_CAPACITY];
    }

    public MathSetImpl(int capacity) {
        INIT_CAPACITY = capacity;
        objArray = new Object[INIT_CAPACITY];
    }

    public MathSetImpl(Number[] numbers) {
        if (numbers == null) {
            this.objArray = new Object[0];
        } else {
            this.objArray = numbers;
            size = numbers.length;
        }

    }

    public MathSetImpl(Number[]... numbers) {
        INIT_CAPACITY = 0;
        for (Number[] numArr : numbers) {
            INIT_CAPACITY += numArr.length;
        }
        objArray = new Object[INIT_CAPACITY];
        for (Number[] numArr : numbers) {
            for (Number e : numArr) {
                add((E) e);
            }
        }
    }

    public MathSetImpl(MathSet<E> mathSet) {
        Number[] array = mathSet.toArray();
        INIT_CAPACITY = array.length;
        objArray = new Object[INIT_CAPACITY];
        this.add(array);
    }

    public MathSetImpl(MathSet<E>... mathSets) {
        INIT_CAPACITY = 0;
        for (MathSet<E> mathSet : mathSets) {
            INIT_CAPACITY += mathSet.size();
        }
        objArray = new Object[INIT_CAPACITY];
        for (MathSet<E> mathSet : mathSets) {
            add(mathSet.toArray());
        }
    }

    @Override
    public void add(Number e) {
        if (contains((E) e)) {
            return;
        }
        if (size >= objArray.length) {
            grow();
        }
        objArray[size] = e;
        size++;
    }

    @Override
    public void add(Number... n) {
        for (Number e : n) {
            add(e);
        }
    }

    @Override
    public void join(MathSet<E> ms) {
        add(ms.toArray());
    }

    @Override
    public void join(MathSet<E>... ms) {
        for (MathSet<E> mathSet : ms) {
            add(mathSet.toArray());
        }
    }

    @Override
    public void intersection(MathSet<E> ms) {
        for (int i = 0; i < size(); i++) {
            final E element = get(i);
            var isDeleteNecessary = true;
            for (int j = 0; j < ms.size(); j++) {
                if (ms.get(j).equals(element)) {
                    isDeleteNecessary = false;
                    break;
                }
            }
            if (isDeleteNecessary) {
                remove(element);
                i--;
            }
        }
    }

    @Override
    public void intersection(MathSet<E>... ms) {
        for (MathSet<E> mathSet : ms) {
            intersection(mathSet);
        }
    }

    @Override
    public void sortDesc() {
        bubbleSort(false, 0, size() - 1);
    }

    @Override
    public void sortDesc(int firstIndex, int lastIndex) {
        if (firstIndex > size || lastIndex > size) return;
        bubbleSort(false, firstIndex, lastIndex);
    }

    @Override
    public void sortDesc(E value) {
        final int indexOf = indexOf(value);
        if (indexOf != -1) {
            bubbleSort(false, indexOf, size() - 1);
        }
    }

    @Override
    public void sortAsc() {
        bubbleSort(true, 0, size() - 1);
    }

    @Override
    public void sortAsc(int firstIndex, int lastIndex) {
        if (firstIndex > size || lastIndex > size) return;
        bubbleSort(true, firstIndex, lastIndex);
    }

    @Override
    public void sortAsc(E value) {
        final int indexOf = indexOf(value);
        if (indexOf != -1) {
            bubbleSort(true, indexOf, size() - 1);
        }
    }

    @Override
    public E get(int index) {
        if (index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("index more than size");
        }
        return (E) objArray[index];
    }

    @Override
    public E getMax() {
        E max = (E) objArray[0];
        for (int i = 0; i < size(); i++) {
            E temp = (E) objArray[i];
            if (temp.compareTo(max) > 0) {
                max = temp;
            }
        }
        return max;
    }

    @Override
    public E getMin() {
        E min = (E) objArray[0];
        for (int i = 0; i < size(); i++) {
            E temp = (E) objArray[i];
            if (temp.compareTo(min) < 1) {
                min = temp;
            }
        }
        return min;
    }

    @Override
    public Number getAverage() {
        var sum = 0d;
        for (int i = 0; i < size; i++) {
            sum += ((E) objArray[i]).doubleValue();
        }
        sum /= size();
        return sum;
    }

    @Override
    public Number getMedian() {
        sortAsc();
        Number median;
        if (size % 2 == 0)
            median = (((E) objArray[size / 2]).doubleValue() + ((E) objArray[size / 2 - 1]).doubleValue()) / 2;
        else
            median = (Number) objArray[size / 2];
        return median;
    }

    @Override
    public Number[] toArray() {
        Number[] objects = new Number[size];
        for (int i = 0; i < size; i++) {
            objects[i] = (Number) objArray[i];
        }
        return objects;
    }

    @Override
    public Number[] toArray(int firstIndex, int lastIndex) {
        Number[] result = new Number[lastIndex - firstIndex];
        var resultIdx = 0;
        for (int i = firstIndex; i < lastIndex; i++) {
            result[resultIdx++] = (Number) objArray[i];
        }
        return result;
    }

    @Override
    public MathSetImpl<E> cut(int firstIndex, int lastIndex) {
        Number[] es = toArray(firstIndex, lastIndex);
        return new MathSetImpl<>(es);
    }

    @Override
    public void clear() {
        size = 0;
        INIT_CAPACITY = 8;
        objArray = new Object[INIT_CAPACITY];
    }

    @Override
    public void clear(E[] numbers) {
        for (int i = 0, numbersLength = numbers.length; i < numbersLength; i++) {
            E number = numbers[i];
            remove(number);
        }
    }

    @Override
    public int size() {
        return size;
    }

    private boolean contains(E e) {
        if (e == null) return false;
        for (Object obj : objArray) {
            if (e.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    private int indexOf(E value) {
        for (int i = 0; i < objArray.length; i++) {
            if (value.equals(objArray[i]))
                return i;
        }
        return -1;
    }

    private void grow() {
        if (objArray.length < INIT_CAPACITY) {
            objArray = Arrays.copyOf(objArray, INIT_CAPACITY);
        } else {
            objArray = Arrays.copyOf(objArray, objArray.length * 2);
        }
    }

    private boolean remove(Object o) {
        boolean isDeleted = false;
        for (int i = 0; i < size; i++) {
            if (!isDeleted) {
                if (o.equals(objArray[i])) {
                    objArray[i] = null;
                    isDeleted = true;
                }
            } else {
                objArray[i - 1] = objArray[i];
                objArray[i] = null;
            }
        }
        if (isDeleted) size--;
        return isDeleted;
    }

    private void bubbleSort(boolean asc, int start, int end) {
        for (int i = start; i < end; i++)
            for (int j = start; j < end - (i - start); j++) {
                final E first = (E) objArray[j];
                final E second = (E) objArray[j + 1];
                if (asc ? first.compareTo(second) > 0 : first.compareTo(second) < 0) {
                    objArray[j] = second;
                    objArray[j + 1] = first;
                }
            }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append((E) objArray[i]);
            builder.append(" ");
        }
        builder.append("]");
        return builder.toString();
    }
}
