package net.harsh.CustomerApplication.repositories;

import net.harsh.CustomerApplication.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    public CustomerEntity findByFirstName(String name);

    public CustomerEntity findByLastName(String name);

}
