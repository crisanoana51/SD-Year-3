package com.proj.ticketsellingsystem.businessLayer;

import com.proj.ticketsellingsystem.modelData.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.ticketsellingsystem.persistanceLayer.CashierBLL;


import java.util.List;

@Service
public class CashierService {

    private final CashierBLL cashierBLL;


    @Autowired
    public CashierService(CashierBLL cashierBLL){
        this.cashierBLL = cashierBLL;

    }

    public Cashier addCashier(Cashier cashier){

        return cashierBLL.save(cashier);
    }

    public List<Cashier>  findAllCashiers(){
        return cashierBLL.findAll();

    }

    public Cashier updateCashier(Cashier cashier){
        return cashierBLL.save(cashier);
    }

    public void deleteCashier(int id){
        cashierBLL.deleteById(id);
    }


    public Cashier findByUsername(String username) {
        return cashierBLL.findCashierByUsername(username);

    }
}
