package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.example.api.CustomerAPI;
import com.example.dto.CustomerDTO;
import com.example.entity.Customer;
import com.example.service.CustomerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerAPI.class)
class CustomerControllerTest {
@Autowired
private MockMvc mockMvc;
@Autowired

@MockBean
private CustomerServiceImpl ser;
@Test
public void t1() throws Exception{
	
CustomerDTO d=new CustomerDTO();
d.setId(1);
d.setName("yoga");
Mockito.when(ser.getCustomerById(1)).thenReturn(d);
mockMvc.perform(get("/api/get/1")).andExpect(status().isOk());
}

@Test
public void t2() throws Exception {

	CustomerDTO d=new CustomerDTO();
	d.setId(1);
	d.setName("yoga");
	Mockito.when(ser.getCustomerById(1)).thenReturn(d);
	mockMvc.perform(get("")).andExpect(status().isOk()).andExpect(jsonPath("$.id",is(1))).andExpect(jsonPath("$.name",is("yoga")));
}
@Test
public void t3() throws JsonProcessingException, Exception {
	CustomerDTO c=new CustomerDTO();
	c.setName("yoga");
	doNothing().when(ser.create(c));
	
	mockMvc.perform(post("") .contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(c))).andExpect(status().isCreated());
}
@Test public void testDeleteData() throws Exception { 
	 doNothing().when(ser).delete(1); 
	 // Perform the DELETE request and verify the response 
	 mockMvc.perform(delete("/api/data/1")) .andExpect(content().string("customer record is deleted")).andExpect(status().isOk());
	 
}
}

			


