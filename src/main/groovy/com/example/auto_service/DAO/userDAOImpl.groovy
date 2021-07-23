package com.example.auto_service.DAO

import com.example.auto_service.Entities.Car
import com.example.auto_service.Entities.User
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
public class userDAOImpl implements userDAO {

    @Autowired
    private SessionFactory sessionFactory;


    // get the current hibernate session
    @Override
    public List<User> getUser() {
        Session currentSession = sessionFactory.getCurrentSession();


        // create a query, sort by username

        Query<User> theQuery = currentSession.createQuery("from User order by user", User.class).list();

        // execute query and get result list

        List<User> users = theQuery.getResultList();

        // return the result

        return users;

    }




    @Override
    public void saveUsers(User theUsers){

        // get current session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/update the car
        currentSession.saveOrUpdate(theUsers);
    }

    @Override
    public User getUser(int theId){
        // get the current session

        Session currentSession = sessionFactory.getCurrentSession();

        // read from database using primary key

        User theUser = currentSession.get(User.class, theId);

        return theUser;
    }

    @Override
    public void deleteUser(int theId){
        // get the current session

        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key

        Query theQuery = currentSession.createQuery("delete from User where id=:theUserId");

        theQuery.setParameter("userId", theId);

        theQuery.executeUpdate();

    }

}