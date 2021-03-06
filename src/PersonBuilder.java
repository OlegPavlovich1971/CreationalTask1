public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;

    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;

    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {

        if (name == null || name.trim()
                .isEmpty()) {
            throw new IllegalStateException("Please provide employee name.");
        }
        if (surname == null || surname.trim()
                .isEmpty()) {
            throw new IllegalStateException("Please provide employee surname.");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Please provide valid age.");
        }
        Person person = new Person(name, surname, age);
        person.setAddress(address);
        return person;
    }
}