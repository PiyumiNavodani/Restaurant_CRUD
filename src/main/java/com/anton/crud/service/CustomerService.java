package com.anton.crud.service;

import com.anton.crud.model.Customer;
import com.anton.crud.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    //Create Customer
    public Customer createCustomer(Customer customer){return customerRepository.save(customer);}

    //Read Customer
    public List<Customer> getCustomer(){return customerRepository.findAll(); }

    //Update Customer
    public Customer updateCustomer(Customer customer){return customerRepository.save(customer);}

    public Customer getCustomerById(long id){return customerRepository.findById(id).get();
    }

    //Delete Customer
    public void deleteCustomer(Customer customer){customerRepository.delete(customer);}
}
