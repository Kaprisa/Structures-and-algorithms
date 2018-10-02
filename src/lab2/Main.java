package lab2;

public class Main {
    public static void main(String[] args) {
        DynamicArrayV2<Integer> arr = new DynamicArrayV2<Integer>();
        arr.addAll(new Integer[]{7, 9, 4, 30, 23, 90, 2, 1, 5});
        System.out.println("Array: " + arr.toString());
        System.out.println("Has 7: " + arr.has(7));
        System.out.println("Has 0: " + arr.has(0));
        arr.sort();
        System.out.println("Sorted array: " + arr.toString());
    }
}
