package lab2;

import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static int n = 0;
    static int floor = 0;
    static int ceil = 100;
    static DynamicArrayV2<Integer> arr = new DynamicArrayV2<Integer>();
    public static void main(String[] args) {
        System.out.println("Обозначения:\n\nВерно +\nБольше >\nМеньше <\n");
        for (int i = 0; i < ceil; i ++) {
            arr.add(i);
        }
        step(ceil / 2);
    }

    static void step(int index) {
        Integer el = arr.get(index);
        System.out.println("Предполагаю, ваше число " + el + "\nПравильно?");
        String answer = sc.nextLine();
        n ++;
        switch (answer) {
            case "+":
                System.out.println("Game over. " + n + " steps.");
                break;
            case "<":
                ceil = el;
                step(floor + (int)Math.floor((index - floor) / 2));
                break;
            case ">":
                floor = el;
                step(index + (int)Math.ceil((ceil - index) / 2));
                break;
        }
    }


}
