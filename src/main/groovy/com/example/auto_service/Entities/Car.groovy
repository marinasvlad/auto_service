package com.example.auto_service.Entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name="car")
class Car {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="model")
    private String model;

    @Column(name="kilometers")
    private double kilometers;

    @Column(name="fabrication")
    private Date fabrication;

    @Column(name="engine")
    private Enum engine;

    public Car(){

    }

    String getModel() {
        return model
    }

    Car(String model, double kilometers, Date fabrication, Enum engine) {
        this.model = model
        this.kilometers = kilometers
        this.fabrication = fabrication
        this.engine = engine
    }

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    void setModel(String model) {
        this.model = model
    }

    double getKilometers() {
        return kilometers
    }

    void setKilometers(double kilometers) {
        this.kilometers = kilometers
    }

    Date getFabrication() {
        return fabrication
    }

    void setFabrication(Date fabrication) {
        this.fabrication = fabrication
    }

    Enum getEngine() {
        return engine
    }

    void setEngine(Enum engine) {
        this.engine = engine
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", kilometers=" + kilometers +
                ", fabrication=" + fabrication +
                ", engine=" + engine +
                '}';
    }


}
