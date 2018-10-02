package lab1;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nCreate array of integers");
        DynamicArray<Integer> arr = new DynamicArray<Integer>();
        arr.add(1);
        Integer[] arrToInsert = new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        arr.addAll(arrToInsert);
        System.out.println(arr.toString());

        System.out.println("\nDelete fifth item");
        arr.delete(5);
        System.out.println(arr.toString());

        System.out.println("\nInsert 50 at position 5");
        arr.insert(5, 50);
        System.out.println(arr.toString());

        System.out.println("\nArray size: " + arr.size());

        System.out.println("Fifth element: " + arr.get(5));

        System.out.println("Max: " + arr.max());
        System.out.println("Min: " + arr.min());
    }
}
