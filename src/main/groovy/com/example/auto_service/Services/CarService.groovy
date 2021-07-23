package com.example.auto_service.Services

import com.example.auto_service.Entities.Car

interface CarService {

    public List<Car> getCars();

    public void saveCars(Car theCar);

    public Car getCar(int theId);

    public void deleteCar(int theId);

}