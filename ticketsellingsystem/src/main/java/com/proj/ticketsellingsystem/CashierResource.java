package com.proj.ticketsellingsystem;

import com.proj.ticketsellingsystem.businessLayer.CashierService;

import com.proj.ticketsellingsystem.modelData.Cashier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashier")
public class CashierResource {

    private final CashierService cashierService;

    public CashierResource(CashierService cashierService) {
        this.cashierService = cashierService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cashier>> getAllUsers(){
        List<Cashier> cashiers = cashierService.findAllCashiers();
        return new ResponseEntity<>(cashiers, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Cashier cashier) {
        Cashier foundCashier = cashierService.findByUsername(cashier.getUsername());

        if (foundCashier != null && foundCashier.verifyPassword(cashier.getPassword())) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Cashier> addUser(@RequestBody Cashier cashier){
        cashier.setPassword(cashier.getPassword());
        Cashier newCashier = cashierService.addCashier(cashier);
        return new ResponseEntity<>(newCashier, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Cashier> updateUser(@RequestBody Cashier cashier){
        Cashier updateCashier = cashierService.updateCashier(cashier);
        return new ResponseEntity<>(updateCashier, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
        cashierService.deleteCashier(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
