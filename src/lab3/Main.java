package lab3;

import lab2.DynamicArrayV2;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nВведите n: ");
        int n = sc.nextInt();
        System.out.print("Введите максимум: ");
        int max = sc.nextInt();
        System.out.print("Введите минимум: ");
        int min = sc.nextInt();
        DynamicArrayV2<Integer> arr = new DynamicArrayV2<Integer>();
        randomFill(arr, n, min, max);
        long time = (new Date()).getTime();
        arr.sort();
        System.out.println("Время сортировки моим алгоритмом: " + ((new Date()).getTime() - time));
        randomFill(arr, n, min, max);
        long time2 = (new Date()).getTime();
        arr.bubbleSort();
        System.out.println("Время сортировки пузырьковым алгоритмом: " + ((new Date()).getTime() - time2));
        for (int i = 0; i < 3; i ++) {
            for (int j = i; j > 0; j--) {
                arr.add(arr.get(i));
            }
        }
        arr.sort();
        System.out.println("\nОтсортированый массив с повторяющимися элементами: ");
        System.out.println(arr);
        System.out.println("\nУдаляем повторения: ");
        arr.deleteDuplicates();
        System.out.println(arr.toString());
    }

    public static void randomFill(DynamicArrayV2<Integer> arr, int n, int min, int max) {
        arr.clear();
        Random generator = new Random();
        for (int i = 0; i < n; i ++) {
            arr.add(generator.nextInt(max - min) + min);
        }
    }
}
