package ru.netology.task1;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    PersonBuilder() {
        age = OptionalInt.empty();
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

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        if (!validAge()) {
            throw new IllegalArgumentException("Недопустимый возраст: " + age);
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        boolean nameNull = this.getName() == null;
        boolean surnameNull = this.getSurname() == null;
        if (nameNull || surnameNull) {
            throw new IllegalStateException("Не хватает обязательных полей: " +
                    (nameNull ? "\n -> name " : "") +
                    (surnameNull ? "\n -> surname" : ""));
        }
        return new Person(this);
    }

    public boolean validAge() {
        if (age.isPresent()) {
            return age.getAsInt() >= 0 && age.getAsInt() <= 120;
        }
        return false;
    }
}