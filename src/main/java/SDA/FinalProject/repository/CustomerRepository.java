package SDA.FinalProject.repository;

import SDA.FinalProject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {


//    List<Customer> findByNameContaining(String name);
    boolean existsByName(String name);
}
