package com.proj.ticketsellingsystem.businessLayer;

import com.proj.ticketsellingsystem.modelData.Admin;
import com.proj.ticketsellingsystem.modelData.Cashier;
import com.proj.ticketsellingsystem.persistanceLayer.AdminBLL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminBLL adminBLL;

    @Autowired
    public AdminService(AdminBLL adminBLL){
        this.adminBLL = adminBLL;

    }

    public Admin addAdmin(Admin admin){

        return adminBLL.save(admin);
    }

    public Admin findByUsername(String username) {
        return adminBLL.findAdminByUsername(username);

    }



}
