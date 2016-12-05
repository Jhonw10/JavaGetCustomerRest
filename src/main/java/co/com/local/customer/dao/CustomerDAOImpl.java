package co.com.local.customer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import co.com.local.customer.db.DbConnection;
import co.com.local.customer.dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {

	private final AtomicLong counter = new AtomicLong();

	public List<CustomerDTO> getAllCustomers() {
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
		DbConnection conex = new DbConnection();

		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM EMPLOYEES");
			ResultSet res = consulta.executeQuery();

			while (res.next()) {
				CustomerDTO customer = toDTO(res.getString("first_name"), res.getString("last_name"), res.getString("employee_id"));				
				customers.add(customer);
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}
	
	public CustomerDTO toDTO(String firstName, String lastName, String employeeId){		
		CustomerDTO customer = new CustomerDTO();
		customer.setId(counter.incrementAndGet());
		customer.setName(firstName + " " + lastName);
		customer.setDocumentNumber(employeeId);
		customer.setDocumentType("CC");
		customer.setSource(("JAVA"));		
		return customer;
	}

}
