package SDA.FinalProject.service;

import SDA.FinalProject.exception.AlreadyExistsException;
import SDA.FinalProject.exception.NotFoundException;
import SDA.FinalProject.model.Customer;
import SDA.FinalProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer create (Customer customer){
        if(customerRepository.existsByName(customer.getName())){
            throw new AlreadyExistsException(String.format("Customer with NAME= %s already exists", customer.getName()));
        }
        return customerRepository.save(customer);
    }

    public Customer getById (Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent()){
            throw new NotFoundException(String.format("Customer with ID= %s does not exist"));
        }
        return customer.get();
    }

    public List<Customer> getAll (){
        return customerRepository.findAll(new Sort(Sort.Direction.ASC,"name"));
    }

//    public List<Customer> search (String name){
//        return customerRepository.findByNameContaining(name);
//    }

    public void deleteById (Long id){
        if(!customerRepository.existsById(id)){
            throw new NotFoundException(String.format("Customer with ID= %s does not exist"));
        }
        customerRepository.deleteById(id);
    }

    public Customer updateById (Customer customer, Long id){
        if(!customerRepository.existsById(id)){
            throw new NotFoundException(String.format("Customer with ID= %s does not exist"));
        }
        if(customerRepository.existsByName(customer.getName())){
            throw new AlreadyExistsException(String.format("Customer with NAME= %s already exists", customer.getName()));
        }
        customer.setId(id);
        return customerRepository.save(customer);
    }
}
