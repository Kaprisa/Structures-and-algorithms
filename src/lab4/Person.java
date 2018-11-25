package lab4;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private int ID;
    private String firstName;
    private String lastName;
    private String postalAdress;
    private String phone;

    public Person(String firstName, String lastName, String postalAdress, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalAdress = postalAdress;
        this.phone = phone;
    }

    public Person(int ID, String firstName, String lastName, String postalAdress, String phone) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalAdress = postalAdress;
        this.phone = phone;
    }

    public Person(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Person(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Person o) {
        return this.ID - o.ID;
    }

    void setID(int ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPostalAddress(String postalAdress) {
        this.postalAdress = postalAdress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    public String getName() { return  getLastName() + " " + getFirstName(); }

    protected String getPostalAdress() {
        return postalAdress;
    }

    protected String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", postalAdress='" + postalAdress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return ID == person.ID &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(postalAdress, person.postalAdress) &&
                Objects.equals(phone, person.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, postalAdress, phone);
    }
}
