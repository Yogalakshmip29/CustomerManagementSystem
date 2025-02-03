package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CustomerDTO;
import com.example.entity.Customer;

import CustomerRepository.CustomerRepository;

@Service(value="ser")
public class CustomerServiceImpl {
@Autowired
private CustomerRepository customerRepository;
public CustomerDTO getCustomerById(Integer id) throws Exception {
    Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new Exception("Customer not found"));
CustomerDTO c=new CustomerDTO();
c.setId(customer.getId());
c.setName(customer.getName());
    return c;
}
public Customer create(CustomerDTO cd){
Customer c=new Customer();
c.setId(cd.getId());
c.setName(cd.getName());
Customer c1=customerRepository.save(c);
return c1;
}

public void delete(Integer cId) throws Exception{
Optional<Customer> optional=customerRepository.findById(cId);
Customer cus=optional.orElseThrow(()->new Exception(""));
customerRepository.deleteById(cId);}

public void create1(CustomerDTO cd) throws Exception{
Customer c=new Customer();
c.setId(cd.getId());
c.setName(cd.getName());
try {
customerRepository.save(c);
}
catch(Exception e) {
	throw new Exception("",e);
}
}

}
