package co.com.local.customer.dao;

import static org.junit.Assert.*;
import org.junit.Test;

import co.com.local.customer.dto.CustomerDTO;

public class CustomerDAOImplTest {
	
		public CustomerDAOImpl dataIn;
		
		@Test
		public void testValidateInstanceNotNullValid(){
			CustomerDTO customer;
			dataIn = new CustomerDAOImpl();
			
			customer = dataIn.toDTO("Name", "lastName", "Id");
			
			assertNotNull(customer);			
		}
		
		@Test
		public void testValidateDataValid(){
			CustomerDTO customer;
			dataIn = new CustomerDAOImpl();
			
			customer = dataIn.toDTO("Name", "lastName", "101");
			
			assertEquals(customer.getId(), 1);
			assertEquals(customer.getDocumentNumber(), "101");
			assertEquals(customer.getSource(), "JAVA");
		}
}
