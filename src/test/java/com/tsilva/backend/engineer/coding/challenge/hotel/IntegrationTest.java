package com.tsilva.backend.engineer.coding.challenge.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
public class IntegrationTest {
	
	@Autowired
	public MockMvc mvc;
}
