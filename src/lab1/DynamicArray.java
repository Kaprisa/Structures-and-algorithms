package lab1;

import java.util.Arrays;
import java.util.Objects;

public class DynamicArray<T extends Comparable<T>> {

    protected T[] array;
    protected int increaseAmount = 10;
    protected int size = 0;

    public DynamicArray() {
        this.clear();
    }

    private void increaseSize(int amount) {
        T[] newArray = (T[])new Comparable[this.size + amount + this.increaseAmount];
        for (int i = 0; i < this.size; i ++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public int size() {
       return this.size;
    }

    public void setIncreaseAmount(int amount) {
        this.increaseAmount = amount;
    }

    private void check(int size) {
        if (this.array.length < size) {
            this.increaseSize(size - this.array.length);
        }
    }

    public void add(T el) {
        this.check(this.size + 1);
        this.array[this.size] = el;
        this.size ++;
    }

    public void addAll(T[] els) {
        this.check(this.size + els.length);
        int length = this.size;
        for (int i = 0; i < els.length; i ++) {
            this.array[length + i] = els[i];
        }
        this.size += els.length;
    }

    public void insert(int index, T value) {
        if (index > this.array.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        this.check(this.size + 1);
        for (int i = this.size; i >= index + 1; i --) {
            this.array[i] = this.array[i - 1];
        }
        this.array[index] = value;
        this.size ++;
    }

    public void delete(int index) {
        if (index > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < this.size - 1; i ++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[this.size] = null;
        this.size --;
    }

    public void clear() {
        this.array = (T[])new Comparable[this.increaseAmount];
        this.size = 0;
    }


    public T get(int index) {
        if (index > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }

    private T minOrMax(int sign) {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }
        T item = this.array[0];
        for (int i = 0; i < this.size; i ++) {
            if (sign * this.array[i].compareTo(item) > 0) {
                item = this.array[i];
            }
        }
        return item;
    }

    public T min() {
        return this.minOrMax(-1);
    }

    public T max() {
        return this.minOrMax(1);
    }

    @Override
    public String toString() {
        String result = "[ ";
        for (int i = 0; i < this.size; i++) {
            result += this.array[i] + ", ";
        }
        return result.replaceAll(",\\s$", "") + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicArray<?> that = (DynamicArray<?>) o;
        return increaseAmount == that.increaseAmount &&
                size == that.size &&
                Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(increaseAmount, size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
