package co.com.local.customer.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.com.local.customer.dao.CustomerDAO;
import co.com.local.customer.dao.CustomerDAOImpl;
import co.com.local.customer.dto.*;

@Path("customer")
public class CustomerService {
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomer() {
    	List<CustomerDTO> listCustomers;
    	GenericEntity<List<CustomerDTO>> entity;
    	CustomerDAO dao;    	
    	dao = new CustomerDAOImpl();
    	listCustomers = dao.getAllCustomers();
    	entity  = new GenericEntity<List<CustomerDTO>>( listCustomers){ };
    	return Response.ok(entity).build();
    	 
    }	 
}
