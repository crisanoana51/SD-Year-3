package com.proj.ticketsellingsystem.modelData;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Base64;

public class CashierTest {

    @Test
    public void testGetPassword() {
        Cashier cashier = new Cashier("testuser", "testpassword");
        String expected = Base64.getEncoder().encodeToString("testpassword".getBytes());
        String actual = cashier.getPassword();
        Assertions.assertEquals(expected, actual, "Password is not encoded correctly");
    }

    @Test
    public void testSetPassword() {
        Cashier cashier = new Cashier("testuser", "testpassword");
        String expected = Base64.getEncoder().encodeToString("newpassword".getBytes());
        cashier.setPassword("newpassword");
        String actual = cashier.getPassword();
        Assertions.assertEquals(expected, actual, "Password is not updated correctly");
    }

    @Test
    public void testVerifyPassword() {
        Cashier cashier = new Cashier("testuser", "testpassword");
        cashier.setPassword("testpassword");
        Assertions.assertTrue(cashier.verifyPassword("testpassword"), "Password verification failed");
        Assertions.assertFalse(cashier.verifyPassword("incorrectpassword"), "Password verification succeeded for incorrect password");
    }

}
