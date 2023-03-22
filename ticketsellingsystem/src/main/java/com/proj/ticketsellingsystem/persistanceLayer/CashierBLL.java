package com.proj.ticketsellingsystem.persistanceLayer;

import com.proj.ticketsellingsystem.modelData.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashierBLL extends JpaRepository<Cashier, Integer> {

    void deleteCashierById(int id);

    Cashier findCashierByUsername(String username);
}
