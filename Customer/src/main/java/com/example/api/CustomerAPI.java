package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CustomerDTO;
import com.example.entity.Customer;
import com.example.service.CustomerServiceImpl;

import CustomerRepository.CustomerRepository;

@RestController
@RequestMapping(value="/api")
public class CustomerAPI {
	@Autowired
	private CustomerServiceImpl ser;
	@Autowired
	private CustomerRepository rep;
	@GetMapping(value="/get/{id}")
		public ResponseEntity<CustomerDTO> get(@PathVariable Integer id) throws Exception{
		CustomerDTO dt=ser.getCustomerById(id);
		return new ResponseEntity<>(dt,HttpStatus.OK);
		//return new ResponseEntity<>(dt)
		}


public void add(CustomerDTO cd){
Customer c=new Customer();
c.setId(cd.getId());
c.setName(cd.getName());
rep.save(c);
}
public ResponseEntity<String> delete(@PathVariable Integer cId) throws Exception{
ser.delete(cId);
String s="customer record is deleted";
return new ResponseEntity<>(s,HttpStatus.OK);// means service class return no result so controller class return no content'	
}
}