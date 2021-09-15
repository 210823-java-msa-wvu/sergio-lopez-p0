package dev.lopez.services;

import dev.lopez.exceptions.IncorrectPasswordException;
import dev.lopez.exceptions.NoUsernameFound;
import dev.lopez.models.Customer;
import dev.lopez.repositories.CustomerRepo;

import java.util.List;

public class UserServices {
    private final CustomerRepo customerRepo;

    public UserServices() {
        this.customerRepo = new CustomerRepo();

    }

    public Customer userLogin(String username, String password) throws NoUsernameFound, IncorrectPasswordException {
        Customer c = customerRepo.getByUsername(username);
        if (c == null) {
            throw new NoUsernameFound();
        }
        if (password.equals(c.getPassword())) {
            return c;
        } else {
            throw new IncorrectPasswordException();
        }
    }

    public Customer userRegister(String username, String password) throws IllegalArgumentException {
        Customer c = customerRepo.getByUsername(username);
        if (c != null) {
            throw new IllegalArgumentException();
        }
        c = customerRepo.addCustomer(username, password);
        return c;
    }

    public Customer loadBalance(Customer u, int amount) {
        int previous = u.getBalance();
        if (previous + amount < 0) {
            System.out.println("ERROR: Insufficient balance.");
            return u;
        }
        u.setBalance(previous + amount);
        if (customerRepo.updateUserBalance(u)) return u;
        else return null;
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.getAllCustomers();


    }
}



