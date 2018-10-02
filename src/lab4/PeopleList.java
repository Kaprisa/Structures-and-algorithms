package lab4;

import lab2.DynamicArrayV2;

public class PeopleList extends DynamicArrayV2<Person> {
    @Override
    public void add(Person el) {
        super.add(el);
        el.setID(this.size);
    }

    @Override
    public int compareBy(Person el1, Person el2, String by) {
        switch(by) {
            case "firstName":
                return el1.getFirstName().compareTo(el2.getFirstName());
            case "lastName":
                return el1.getLastName().compareTo(el2.getLastName());
            case "postalAddress":
                return el1.getPostalAdress().compareTo(el2.getPostalAdress());
            case "phone":
                return el1.getPhone().compareTo(el2.getPhone());
            default:
                return el1.compareTo(el2);
        }
    }
}
