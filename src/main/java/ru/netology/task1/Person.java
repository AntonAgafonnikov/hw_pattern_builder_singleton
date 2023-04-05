package ru.netology.task1;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private OptionalInt age;
    private String address;

    public Person(final PersonBuilder personBuilder) {
        this.name = personBuilder.getName();
        this.surname = personBuilder.getSurname();
        this.age = personBuilder.getAge();
        this.address = personBuilder.getAddress();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean hasAddress() {
        return !"".equals(address);
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        if (this.age.isEmpty()) {
            this.age = OptionalInt.of(age);
        }
    }

    public void happyBirthday() {
        if (this.age.isPresent()) {
            this.age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.getSurname())
                .setAddress(this.getAddress())
                .setAge(0);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname)
                && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
