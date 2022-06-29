package net.harsh.CustomerApplication.controllers;

import net.harsh.CustomerApplication.entities.CustomerEntity;
import net.harsh.CustomerApplication.repositories.CustomerRepository;
import net.harsh.CustomerApplication.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService service;

    //save customer
    @PostMapping("/add-customer")
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
        return service.saveCustomer(customer);
    }

    //get customers
    @PostMapping("/add-customers")
    public List<CustomerEntity> addCustomers(@RequestBody List<CustomerEntity> customers) {
        return service.saveCustomers(customers);
    }

    //get List of Customers
    @GetMapping("/customers-list")
    public List<CustomerEntity> customersList() {
        return service.getCustomers();
    }

    //get customer by id
    @GetMapping("/customer-id/{id}")
    public CustomerEntity findCustomerById(@PathVariable int id) {
        return service.getCustomerById(id);
    }

    //get customer by Firstname
    @GetMapping("/customer-fn/{fn}")
    public CustomerEntity findCustomerByFirstName(@PathVariable String fn) {
        return service.getCustomerByFirstName(fn);
    }

    //get customer by Lastname
    @GetMapping("/customer-ln/{ln}")
    public CustomerEntity findCustomerByILastName(@PathVariable String ln) {
        return service.getCustomerByLastName(ln);
    }
}
