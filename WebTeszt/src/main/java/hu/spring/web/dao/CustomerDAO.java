package hu.spring.web.dao;

import java.util.List;

import hu.spring.web.model.Customer;

public interface CustomerDAO {
public void saveOrUpdate(Customer customer);
	
	public void delete(int customerId);
	
	public Customer get(int customerId);
	
	public List<Customer> list();
}
