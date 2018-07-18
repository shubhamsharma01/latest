package service;

import java.util.ArrayList;
import java.util.Set;

import daoOperation.CustomerDao;
import entityPojo_customer.Customer;

public class CustomerService
{
	CustomerDao dao=new CustomerDao();
	Validation validation=new Validation();
	public ArrayList<Customer> viewCustomer()
	{
		
		ArrayList<Customer> customers=dao.fetchAll();
		return customers;
	}
	
	public int delete(String id)
	{
		int count=dao.deleteCustomer(id);
		return count;
	}
	
	public int add(Customer customer)
	{
		int count=0;
		Set<String> set=dao.fetch_customer_code();
		boolean code=validation.validCustomerCode(customer, set);
		if(code==true)
		{
		count=dao.addCustomer(customer);
		return count;
		}
		else
		return count;
	}
	
	public Customer updateCustomer(String customerCode)
	{
		Customer customer=dao.viewupdate(customerCode);
		return customer;
	}
	
	public int update(Customer customer)
	{
		int count=dao.updateCustomer(customer);
		return count;
	}
	
	public boolean checkCode(String customerCode)
	{
		Set<String> set=dao.fetch_customer_code();
		if(set.contains(customerCode))
		return true;
		else
			return false;
	}
	
}
