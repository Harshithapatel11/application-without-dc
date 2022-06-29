package net.harsh.CustomerApplication;

import net.harsh.CustomerApplication.entities.CustomerEntity;
import net.harsh.CustomerApplication.repositories.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerTests {

    @Autowired
    private CustomerRepository repository;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateCustomer() {
        CustomerEntity customer = new CustomerEntity("Krishna" , "Prasad");
        CustomerEntity savedCustomer = repository.save(customer);

        assertNotNull(savedCustomer);
    }

    @Test
    @Order(2)
    public void testFindCustomerByFirstNameExist() {
        String name = "Krishna";
        CustomerEntity customer = repository.findByFirstName(name);

        Assertions.assertThat(customer.getFirstName()).isEqualTo(name);
    }

    @Test
    @Order(4)
    public void testFindCustomerByLastNameExist() {
        String name = "Prasad";
        CustomerEntity customer = repository.findByLastName(name);

        assertThat(customer.getLastName()).isEqualTo(name);
    }

    @Test
    @Order(3)
    public void testFindCustomerByFirstNameNotExist() {
        String name = "Kumar";
        CustomerEntity customer = repository.findByFirstName(name);

        assertNull(customer);
    }

    @Test
    @Order(5)
    public void testFindCustomerByLastNameNotExist() {
        String name = "Rahul";
        CustomerEntity customer = repository.findByLastName(name);

        assertNull(customer);
    }
}
