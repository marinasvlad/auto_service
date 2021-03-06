package com.example.auto_service.Entities

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name="admin")
class Admin {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user")
    private String user;

    @Column(name="password")
    private double password;

    @OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinColumn(name="admin_id")
    private List<User> users;


    public Admin(){

    }

    Admin(String user, double password) {
        this.user = user
        this.password = password
    }

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getUser() {
        return user
    }

    void setUser(String user) {
        this.user = user
    }

    double getPassword() {
        return password
    }

    void setPassword(double password) {
        this.password = password
    }

    Admin(List<User> users) {
        this.users = users
    }

    List<User> getUsers() {
        return users
    }

    void setUsers(List<User> users) {
        this.users = users
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password=" + password +
                '}';
    }



}
