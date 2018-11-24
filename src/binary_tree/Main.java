package binary_tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer, String> tree = new Tree<>();

        tree.add(1, "a");
        tree.add(7, "b");
        tree.add(5, "c");
        tree.add(3, "d");
        tree.add(9, "e");
        tree.add(12, "f");

        System.out.println("\nДерево, в виде списка: \n");

        System.out.println(tree.toList());

        tree.remove(7);

        System.out.println("\nУдаляем значение с ключом 7 (b): \n");

        System.out.println(tree.toList());
    }
}
