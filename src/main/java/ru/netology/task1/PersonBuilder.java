package ru.netology.task1;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;
    private boolean flagSetAge;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean getFlagSetAge() {
        return flagSetAge;
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
        this.age = age;
        this.flagSetAge = true;
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
        return age >= 0 && age <= 120;
    }
}
