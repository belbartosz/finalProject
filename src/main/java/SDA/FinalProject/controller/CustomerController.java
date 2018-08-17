package SDA.FinalProject.controller;

import SDA.FinalProject.model.Customer;
import SDA.FinalProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer (@RequestBody @Valid Customer customer){
        return customerService.create(customer);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> searchCustomers (@RequestParam(value = "name", required = false) String name){
        return customerService.search(name);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById (@PathVariable Long id){
        return customerService.getById(id);
    }

    @GetMapping("/allCustomers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers (){
        return customerService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable Long id){
        customerService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomerById (@RequestBody @Valid Customer customer, @PathVariable Long id){
        return customerService.updateById(customer, id);
    }


}
