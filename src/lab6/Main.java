package lab6;

public class Main {
    public static void main(String[] args) {
        HashTable table = new HashTable();

        table.add("собака");
        table.add("кот");
        table.add("кит");
        table.add("корова");
        table.add("курица");
        table.add("мышь");
        table.add("муха");
        table.add("лев");
        table.add("тигр");
        table.add("рысь");
        table.add("сова");
        table.add("лось");
        table.add("осёл");
        table.add("норка");
        table.add("лань");

        System.out.println("\nМассив:");
        System.out.println(table);

        System.out.println("\nИндекс строки \"кот\" в таблице:");
        System.out.println(table.indexOf("кот"));

        System.out.println("\nПоиск строк, начинающихся на \"к\"");
        System.out.println(table.search("к"));

        System.out.println("\nУдаляем строку \"кот\"");
        table.delete("кот");

        System.out.println("\nМассив:");
        System.out.println(table);

        System.out.println("\nПоиск строк, начинающихся на \"к\"");
        System.out.println(table.search("к"));
    }
}
