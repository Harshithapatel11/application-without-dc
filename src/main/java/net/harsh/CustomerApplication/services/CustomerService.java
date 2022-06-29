package net.harsh.CustomerApplication.services;

import net.harsh.CustomerApplication.entities.CustomerEntity;
import net.harsh.CustomerApplication.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> saveCustomers(List<CustomerEntity> customers) {
        return customerRepository.saveAll(customers);
    }

    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    public List<CustomerEntity> getCustomers() {
        return customerRepository.findAll();
    }

    public CustomerEntity getCustomerById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    public CustomerEntity getCustomerByFirstName(String name) {
        return customerRepository.findByFirstName(name);
    }

    public CustomerEntity getCustomerByLastName(String name) {
        return customerRepository.findByLastName(name);
    }
}
