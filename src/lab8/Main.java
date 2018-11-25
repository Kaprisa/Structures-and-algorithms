package lab8;

import java.io.IOException;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        StudentsStore studentsStore = new StudentsStore();

        // Читаем студентов из файла
        studentsStore.readFromFile("resources/students.txt");

        // Добавляем нового студента
        TreeMap<String, Integer> progress = new TreeMap<>();
        progress.put("математика", 4);
        progress.put("информатика", 4);
        progress.put("английский язык", 4);
        Student student = new Student("Иван", "Иванов", "13.03.1998", "89042343434", progress);
        studentsStore.addStudent(student);


        System.out.println("\nИщем студентов на \"В\"\n");
        System.out.println(studentsStore.getStudents().search("в"));

        // Удаляем одного из студентов
        Student studentToDelete = studentsStore.get("васильева наталья");
        System.out.println("\nУдаляем студента " + studentToDelete.getName());
        studentsStore.deleteStudent(studentToDelete);

        // Записываем студентов в файл
        studentsStore.writeToFile("resources/students1.txt");

        System.out.println("\nИщем студентов на \"В\"\n");
        System.out.println(studentsStore.getStudents().search("в"));


    }


}
