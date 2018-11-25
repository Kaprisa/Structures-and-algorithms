package lab6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashTable<T> {
    private T[] store;
    private Class<T> tClass;
    private int[] offsets;
    private int step = 3;
    private int size = 33;

    private T[] createStore(int len) {
        @SuppressWarnings("unchecked")
        final T[] s = (T[]) Array.newInstance(this.tClass, len);
        return s;
    }

    public HashTable(Class<T> c) {
        this.tClass = c;
        this.store = createStore(this.size * this.step);
        this.offsets = new int[this.size];
    }

    public void add(T value) {
        int key = this.getKey(value.toString());
        if (!this.checkOverflow(key)) {
            this.changeSize();
        }
        this.store[key * this.step + this.offsets[key]] = value;
        this.offsets[key] ++;
    }

    private boolean checkOverflow(int key) {
        return this.offsets[key] < this.step;
    }

    private void changeSize() {
        int newStep = this.step + 10;
        T[] newStore = createStore(this.size * newStep);
        for (int i = 0; i < this.size; i ++) {
            if (this.offsets[i] >= 0)
                System.arraycopy(this.store, i * this.step, newStore, i * newStep, this.offsets[i]);
        }
        this.step = newStep;
        this.store = newStore;
    }

    public void delete(T value) {
        int key = this.getKey(value.toString());
        boolean move = false;
        for (int i = key * this.step; i < key * this.step + this.offsets[key]; i ++) {
            if (move) {
                this.store[i - 1] = this.store[i];
            } else if (this.store[i].equals(value)) {
                move = true;
            }
        }
        this.offsets[key] --;
    }

    int indexOf(T value) {
        int key = this.getKey(value.toString());
        int index = -1;
        for (int i = key * this.step; i < key * this.step + this.offsets[key]; i ++) {
            if (this.store[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean has(T value) {
        return this.indexOf(value) != -1;
    }

    public List<T> search(String prefix) {
        int key = this.getKey(prefix);
        List<T> result = new ArrayList<>();
        for (int i = key * this.step; i < key * this.step + this.offsets[key]; i ++) {
            if (this.store[i].toString().startsWith(prefix)) {
                result.add(this.store[i]);
            }
        }
        return result;
    }

    public T getByKey(String k) {
        int key = this.getKey(k);
        for (int i = key * this.step; i < key * this.step + this.offsets[key]; i ++) {
            if (this.store[i].toString().equals(k)) {
                return this.store[i];
            }
        }
        return null;
    }

    private int getKey(String value) {
        return (int)value.charAt(0) - 1072;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < this.size; i ++) {
            for (int j = 0; j < this.offsets[i]; j++) {
                result.append(this.store[i * this.step + j]).append(", ");
            }
        }
        return result.substring(0, result.length() - 2) + "]";
    }

    public List<T> toList() {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < this.size; i ++) {
            result.addAll(Arrays.asList(this.store).subList(i * this.step, this.offsets[i] + i * this.step));
        }
        return result;
    }
}
