package com.example.auto_service.DAO

import com.example.auto_service.Entities.Car

public interface carDAO {

    public List<Car> getCars();

    public void saveCars(Car theCar);

    public Car getCar(int theId);

    public void deleteCar(int theId);
}
