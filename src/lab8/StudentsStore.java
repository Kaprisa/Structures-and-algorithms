package lab8;

import lab6.HashTable;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.stream.Stream;

class StudentsStore {
    private HashTable<Student> students;

    void writeToFile(String fileName) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            writer.write(this.toString());
        }
    }

    void readFromFile(String fileName) throws IOException {

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream
                    .map(line -> line.split(","))
                    .forEach(this::addStudent);
        }
    }

    StudentsStore() {
        students = new HashTable<Student>(Student.class);
    }

    Student get(String key) {
        return this.students.getByKey(key);
    }

    public void addStudent(String[] values) {
        TreeMap<String, Integer> progress = new TreeMap<>();
        for (int i = 3; i < values.length; i ++) {
            String[] subjectAndMark = values[i].split("-");
            progress.put(subjectAndMark[0], Integer.parseInt(subjectAndMark[1]));
        }
        String[] name = values[0].split(" ");
        students.add(new Student(name[1], name[0], values[1], values[2], progress));
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(Student student) {
        this.students.delete(student);
    }

    @Override
    public String toString() {
        return students.toList().stream().map(Student::toFullString).reduce("", (acc, s) -> acc + s + "\n");
    }

    public HashTable<Student> getStudents() {
        return students;
    }
}
