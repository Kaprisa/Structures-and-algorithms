package lab6;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private String[] store;
    private int[] offsets;
    private int step = 3;
    private int size = 33;

    HashTable() {
        this.store = new String[this.size * this.step];
        this.offsets = new int[this.size];
    }

    public void add(String value) {
        int key = this.getKey(value);
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
        String[] newStore = new String[this.size * newStep];
        for (int i = 0; i < this.size; i ++) {
            for (int j = 0; j < this.offsets[i]; j++) {
                newStore[i * newStep + j] = this.store[i * this.step + j];
            }
        }
        this.step = newStep;
        this.store = newStore;
    }

    public void delete(String value) {
        int key = this.getKey(value);
        boolean move = false;
        for (int i = key * this.step; i < key * this.step + this.offsets[key]; i ++) {
            if (move) {
                this.store[i - 1] = this.store[i];
            } else if (this.store[i] == value) {
                move = true;
            }
        }
        this.offsets[key] --;
    }

    public int indexOf(String value) {
        int key = this.getKey(value);
        int index = -1;
        for (int i = key * this.step; i < key * this.step + this.offsets[key]; i ++) {
            if (this.store[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean has(String value) {
        return this.indexOf(value) != -1;
    }

    public List<String> search(String prefix) {
        int key = this.getKey(prefix);
        List<String> result = new ArrayList<>();
        for (int i = key * this.step; i < key * this.step + this.offsets[key]; i ++) {
            if (this.store[i].startsWith(prefix)) {
                result.add(this.store[i]);
            }
        }
        return result;
    }

    private int getKey(String value) {
        return (int)value.charAt(0) - 1072;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < this.size; i ++) {
            for (int j = 0; j < this.offsets[i]; j++) {
                result += this.store[i * this.step + j] + ", ";
            }
        }
        return result.substring(0, result.length() - 2) + "]";
    }
}
