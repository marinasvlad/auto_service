package com.example.auto_service.DAO

import com.example.auto_service.Entities.Admin
import com.example.auto_service.Entities.Car

public interface adminDAO {

    public List<Admin> getAdmin();

    public void saveAdmins(Admin theAdmin);

    public Admin getAdmin(int theId);

    public void deleteAdmin(int theId);

}
