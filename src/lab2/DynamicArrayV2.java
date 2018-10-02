package lab2;

import lab1.DynamicArray;

import java.util.Random;

public class DynamicArrayV2<T extends Comparable<T>> extends DynamicArray<T> {
    public boolean has(T el) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i].equals(el)) {
                return true;
            }
        }
        return false;
    }

    public int compareBy(T el1, T el2, String by) {
        return el1.compareTo(el2);
    }

    public void sort(int direction, String by) {
        T[] newArray = (T[])new Comparable[this.size + this.increaseAmount];
        int newArraySize = 0;
        for (int i = 0 ; i < this.size; i ++) {
            int j = 0;
            T el = this.array[i];
            while (j < newArraySize) {
                if (direction * compareBy(newArray[j], el, by) >= 0) {
                    break;
                }
                j++;
            }
            newArraySize++;
            for (int y = newArraySize; y > j; y --) {
                newArray[y] = newArray[y - 1];
            }
            newArray[j] = el;
        }
        this.array = newArray;
    }

    public void sort(int direction) {
        this.sort(direction, "");
    }

    public void sort(String by) {
        this.sort(1, by);
    }

    public void swipe(int i1, int i2) {
        if (i1 != i2)
        {
            T tmp = this.array[i1];
            this.array[i1] = this.array[i2];
            this.array[i2] = tmp;
        }
    }

    public void sort() {
        this.sort(1);
    }

    public void bubbleSort() {
        boolean swapped;
        do
        {
            swapped = false;
            for (int i = 1; i < this.size; i++) {
                if (this.array[i - 1].compareTo(this.array[i]) > 0)
                {
                    this.swipe(i - 1, i);
                    swapped = true;
                }
            }
        } while (swapped != false);
    }

    public void quickSort() {

    }

    public void deleteDuplicates() {
        int i = 0;
        while (i < this.size - 1) {
            int counter = 0;
            while (this.array[i] == this.array[i + 1] && i < this.size - 1) {
                i++;
                counter++;
            }
            if (counter > 0) {
                for (int j = i; j < this.size; j ++) {
                    swipe(j, j - counter);
                }
                this.size -= counter;
                i -= counter;
            }
            i++;
        }
    }
}
