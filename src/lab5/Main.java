package lab5;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void radixSort(int[] arr, int range) {
        ArrayList<Integer>[] buckets = new ArrayList[range + 1];
        for (int i = 0; i < range + 1; i ++) {
            buckets[i] = new ArrayList<>();
        }
        int max = 0;
        for (int item: arr) {
            if (item > max) {
                max = item;
            }
        }
        int width = Integer.toString(max).split("").length;
        for (int i = 0; i < width; i ++) {
            for (int j = 0; j < arr.length; j ++) {
                buckets[arr[j] >= Math.pow(10, i) ? ((int)Math.floor((arr[j] % (Math.pow(10, i + 1))) / Math.pow(10, i))) + 1 : 0].add(arr[j]);
            }
            int index = 0;
            for (int j = 0; j < range + 1; j ++) {
                for (int k = 0; k < buckets[j].size(); k ++) {
                    arr[index] = buckets[j].get(k);
                    index ++;
                }
                buckets[j].clear();
            }

        }
    }

    public static int[] readArray() {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();

        while (sc.hasNextInt()) {
            arr.add(sc.nextInt());
        }

        sc.close();

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] generateArray(int size, int min, int max) {
        final Random random = new Random();

        int[] a = new int[size];

        for (int i = 0; i < size; i++)
            a[i] = random.nextInt(max - min) + min;

        return a;
    }

    public static int[] readArrayFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));

            ArrayList<Integer> arr = new ArrayList<>();

            while (sc.hasNextInt()) {
                arr.add(sc.nextInt());
            }

            sc.close();

            return arr.stream().mapToInt(Integer::intValue).toArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new int[0];
        }
    }

    public static void main(String args[]) {

        // int[] a = readArray();

        int[] a = readArrayFromFile("resources/array.txt");

        //int[] a = generateArray(10, 0, 100);

        radixSort(a, 10);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }
}