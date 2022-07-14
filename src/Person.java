import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        if (!(age < 0)) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Please enter a valid age");
        }
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        return (address != null && !address.trim()
                .isEmpty());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) this.age = age + 1;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(surname);
        child.setAge(0);
        child.setAddress(address);
        return child;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person[name=")
                .append(name)
                .append(", surname=")
                .append(surname)
                .append(", age=")
                .append(age)
                .append(", address=")
                .append(address)
                .append("]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
