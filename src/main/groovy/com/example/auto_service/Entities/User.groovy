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
@Table(name="user")
class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user")
    private String user;

    @Column(name="password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<Car> cars;

    public User(){

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

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }

    User(String user, String password) {
        this.user = user
        this.password = password
    }

    List<Car> getCars() {
        return cars
    }

    void setCars(List<Car> cars) {
        this.cars = cars
    }

    // add a convenience method

    public void addCar(Car theCar){
    if(cars == null){
        cars = new ArrayList<>();

        cars.add(theCar);
    }

    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
