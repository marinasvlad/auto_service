package com.example.auto_service.DAO

import com.example.auto_service.Entities.Admin
import com.example.auto_service.Entities.Car
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
public class adminDAOImpl implements adminDAO{


    @Autowired
    private SessionFactory sessionFactory;


    // get the current hibernate session
    @Override
    public List<Admin> getAdmin() {
        Session currentSession = sessionFactory.getCurrentSession();


        // create a query, sort by user

        Query<Admin> theQuery = currentSession.createQuery("from Admin order by user", Admin.class).list();

        // execute query and get result list

        List<Admin> admins = theQuery.getResultList();

        // return the result

        return admins;

    }

    @Override
    public void saveAdmins(Admin theAdmin){

        // get current session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/update the admin
        currentSession.saveOrUpdate(theAdmin);
    }

    @Override
    public Admin getAdmin(int theId){
        // get the current session

        Session currentSession = sessionFactory.getCurrentSession();

        // read from database using primary key

        Admin theAdmin = currentSession.get(Admin.class, theId);

        return theAdmin;
    }

    @Override
    public void deleteAdmin(int theId){
        // get the current session

        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key

        Query theQuery = currentSession.createQuery("delete from Admin where id=:theAdminId");

        theQuery.setParameter("adminId", theId);

        theQuery.executeUpdate();

    }


}
