package com.example.auto_service.Services

import com.example.auto_service.DAO.carDAO
import com.example.auto_service.Entities.Car
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Service
class CarServiceImpl implements CarService {
    // need to inject customer dao

    @Autowired
    private carDAO carDAO;

    @Override
    @Transactional
    public List<Car> getCars(){
        return carDAO.getCars()
    }

    @Override
    @Transactional
    public void saveCars(Car theCar){
        carDAO.saveCars(theCar);
    }

    @Override
    @Transactional




}
