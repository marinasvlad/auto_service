package com.example.auto_service.DAO

import com.example.auto_service.Entities.Car
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import javax.persistence.Query

@Repository
public class carDAOImpl implements carDAO {

    @Autowired
    private SessionFactory sessionFactory;


    // get the current hibernate session
    @Override
    public List<Car> getCars() {
        Session currentSession = sessionFactory.getCurrentSession();


        // create a query, sort by model

        Query<Car> theQuery = currentSession.createQuery("from Car order by model", Car.class).list();

        // execute query and get result list

        List<Car> cars = theQuery.getResultList();

        // return the result

        return cars;

    }

    @Override
    public void saveCars(Car theCar){

        // get current session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/update the car
        currentSession.saveOrUpdate(theCar);
    }

    @Override
    public Car getCar(int theId){
        // get the current session

        Session currentSession = sessionFactory.getCurrentSession();

        // read from database using primary key

        Car theCar = currentSession.get(Car.class, theId);

        return theCar;
    }

    @Override
    public void deleteCar(int theId){
        // get the current session

        Session currentSession = sessionFactory.getCurrentSession();

         // delete object with primary key

        Query theQuery = currentSession.createQuery("delete from Car where id=:theCarId");

        theQuery.setParameter("carId", theId);

        theQuery.executeUpdate();

    }

}
