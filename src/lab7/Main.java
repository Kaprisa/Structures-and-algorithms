package lab7;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void swipe(int[] arr, int index1, int index2) {
        int t = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = t;
    }

    public static void shift(int[] numbers, int root, int bottom) {
        int max;
        boolean done = false;
        while (!done && root * 2 <= bottom) {
            if (root * 2 == bottom)
                max = root * 2;
            else if (numbers[root * 2] > numbers[root * 2 + 1])
                max = root * 2;
            else
                max = root * 2 + 1;

            if (numbers[root] < numbers[max]) {
                swipe(numbers, root, max);
                root = max;
            } else {
                done = true;
            }
        }
    }

    public static void pyramidSort(int[] numbers) {
        int size = numbers.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            shift(numbers, i, size - 1);
        }

        for (int i = size - 1; i >= 1; i--) {
            swipe(numbers, 0, i);
            shift(numbers, 0, i - 1);
        }

    }

    static final Scanner sc = new Scanner(System.in);

    public static int getInput(String request) {
        System.out.println(request);
        return sc.nextInt();
    }

    public static void printArray(int[] arr, String message) {
        System.out.println(message);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }


    public static void main(String args[]) {

        int size = getInput("\nВведите размер массива");
        int min = getInput("\nМинимальный элемент");
        int max = getInput("\nМаксимальный элемент");

        final Random random = new Random();

        int[] a = new int[size];

        for (int i = 0; i < size; i++)
            a[i] = random.nextInt(max - min) + min;

        printArray(a, "\nИсходный массив:\n");

        pyramidSort(a);

        printArray(a, "\n\nОтсортированный массив:\n");

        System.out.println("\n\nОтсортированный массив: Вывод методом вложенных скобок\n");

        for (int i = 0; i < size; i++) {
            if (i < size - 4 || i == size - 2) {
                System.out.print("(");
            }
            System.out.print(a[i]);
            if (i == size - 4) {
                System.out.print(")");
            }
            if (i != size - 1) {
                System.out.print(" ");
            }
        }
        for (int i = 0; i < size - 4; i ++) {
            System.out.print(")");
        }

        System.out.println();

    }
}