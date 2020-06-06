package com.sanil.model;

import javax.persistence.*;

@NamedQuery(name="find_all",query="select u from User u")
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    Integer id;

    private String name, email;

    @Column(name="phone_number")
    private String phoneNumber;

    public User() {
    }

    public User(Integer id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

}
