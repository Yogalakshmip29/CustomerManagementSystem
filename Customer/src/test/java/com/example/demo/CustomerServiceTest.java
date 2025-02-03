package com.example.demo;




import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dto.CustomerDTO;
import com.example.entity.Customer;
import com.example.service.CustomerServiceImpl;

import CustomerRepository.CustomerRepository;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	@Mock
	private CustomerRepository rep;
	@InjectMocks
	private CustomerServiceImpl ser;
	
    
@Test
public void t1() throws Exception{
Customer customer=new Customer();
customer.setName("yoga");//id is automatically generated

Mockito.when(rep.findById(1)).thenReturn(Optional.of(customer));
CustomerDTO c=new CustomerDTO();
c.setId(1);
c.setName("yoga");

Assertions.assertEquals(c,ser.getCustomerById(1));
}
@Test
public void t2() {
	Customer customer=new Customer();
	customer.setName("yoga");//id is automatically generated
	Mockito.when(rep.save(any(Customer.class))).thenReturn(customer);

	CustomerDTO dt=new CustomerDTO();
	dt.setName("yoga");


	Assertions.assertEquals(customer,ser.create(dt));

}

@Test
public void t3() {
	Customer dt=new Customer();
	
	dt.setName("yoga");
	//doNothing().Mockito.when(rep.save(dt));
	doNothing().when(rep.save(dt));
	verify(rep).save(dt);
	
}
@Test
public void t11() throws Exception{
Customer customer=new Customer();
customer.setName("yoga");//id is automatically generated

Mockito.when(rep.findById(1)).thenThrow(new Exception(""));
CustomerDTO c=new CustomerDTO();
c.setId(1);
c.setName("yoga");
Exception ex=Assertions.assertThrows(Exception.class, ()->ser.getCustomerById(4));
Assertions.assertEquals("", ex.getMessage());


}	
	
	}

