package com.bulytovs.spring.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.validation.constraints.*;

@Entity
@Table(name = "usersproject")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;
    @Column(name = "lastName")
    @NotEmpty(message = "Last name should not be empty")
    @Size(min = 2, max = 30, message = "Last name should be between 2 and 30 characters")
    private String lastName;
    @Column(name = "age")
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;
    @Column(name = "email")
    @NotEmpty(message = "Last name should not be empty")
    @Email(message = "Email should be valid")
    private String email;
    @Column(name = "phone_number")
    @Pattern(regexp = "\\+7\\d{3}-\\d{2}-\\d{2}")
    private String phoneNumber;
    @Column(name = "address")
    //Страна, Город, Индекс (6 цифр)
    //Россия, Иркутск, 999999
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your address should be format: Country, City, Postal Code (6 digits)")
    private String address;

    public User() {
    }

    public User(String name, String lastName, int age, String email, String phoneNumber, String address) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
