package com.proj.ticketsellingsystem.persistanceLayer;

import com.proj.ticketsellingsystem.modelData.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminBLL extends JpaRepository<Admin, Integer> {

    Admin findAdminByUsername(String username);
}