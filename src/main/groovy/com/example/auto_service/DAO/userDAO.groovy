package com.example.auto_service.DAO

import com.example.auto_service.Entities.Car
import com.example.auto_service.Entities.User

public interface userDAO {

    public List<User> getUser();

    public void saveUsers(User theUser);

    public User getUser(int theId);

    public void deleteUser(int theId);

}