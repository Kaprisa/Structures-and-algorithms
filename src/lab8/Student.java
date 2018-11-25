package lab8;

import lab4.Person;

import java.util.Map;
import java.util.Objects;

public class Student extends Person {
    private String birthday;
    private Map<String, Integer> progress;

    Student(String firstName, String lastName, String birthday, String phone, Map<String, Integer> progress) {
        super(firstName, lastName, phone);
        this.birthday = birthday;
        this.progress = progress;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Map<String, Integer> getProgress() {
        return progress;
    }

    public void setProgress(Map<String, Integer> progress) {
        this.progress = progress;
    }


    public Integer getMark(String subject) {
        return this.progress.get(subject);
    }

    private String getProgressString() {
        final String[] result = {""};
        this.getProgress().forEach((subject, mark) -> result[0] += subject + "-" + mark.toString() + ",");
        return result[0];
    }

    @Override
    public String toString() {
        return this.getName().toLowerCase();
    }

    String toFullString() {
        return this.getName() + "," + this.getBirthday()
                + "," + this.getPhone()
                + "," + this.getProgressString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(birthday, student.birthday) &&
                Objects.equals(progress, student.progress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), birthday, progress);
    }
}
