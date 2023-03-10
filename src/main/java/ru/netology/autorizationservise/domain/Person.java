package ru.netology.autorizationservise.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Person {
    @NotBlank//символы не должны быть все пробылы
    @Size(min = 2, max = 20) //сколько должно быть минимально и максимально символов
    private String name;
    @NotBlank
    @Size(min = 3, max = 10)
    private String password;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password=" + password +
                '}';
    }

    public String getName() {
        return name;
    }

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return password == person.password && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}

