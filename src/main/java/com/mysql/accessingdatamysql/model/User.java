package com.mysql.accessingdatamysql.model;

import jakarta.persistence.*;

@Entity
@Table(name= "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="username")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name = "phone")
    private String phone;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }
}
