package lab4;

public class Main {
    public static void main(String[] args) {
        PeopleList people = new PeopleList();
        Person ivan = new Person("Иван", "Иванов", "666", "89127777777");
        Person maria = new Person("Мария", "Иванова", "777", "89130888888");
        Person misha = new Person("Михаил", "Сергеев", "12345", "89777777777");
        Person sofia = new Person("София", "Сергеева", "12345", "89500888888");
        people.add(ivan);
        people.add(maria);
        people.add(misha);
        people.add(sofia);
        System.out.println("Сортировка по ID:");
        System.out.println(people.toString());
        System.out.println("Сортировка по ID по убыванию:");
        people.sort(-1);
        System.out.println(people.toString());
        System.out.println("Сортировка по firstName:");
        people.sort("firstName");
        System.out.println(people.toString());
        System.out.println("Сортировка по lastName по убыванию:");
        people.sort(-1, "lastName");
        System.out.println(people.toString());
        System.out.println("Сортировка по postalAddress:");
        people.sort("postalAddress");
        System.out.println(people.toString());
        System.out.println("Сортировка по phone по убыванию:");
        people.sort(-1, "phone");
        System.out.println(people.toString());
    }
}
