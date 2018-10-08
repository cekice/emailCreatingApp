package com.maven.pohs.service;

import com.maven.pohs.dao.CustomerDAO;
import com.maven.pohs.model.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
public class CustomerService {
    
@Autowired
CustomerDAO customerDao;
 
@Transactional
public List getAllCustomers() {
	return customerDao.getAllCustomers();
}
 
@Transactional
public Customer getCustomer(int idCustomer) {
	return customerDao.getCustomer(idCustomer);
}
 
@Transactional
public void addCustomer(Customer customer) {
	customerDao.addCustomer(customer);
}
 
@Transactional
public void updateCustomer(Customer customer) {
	customerDao.updateCustomer(customer);
 
}
 
@Transactional
public void deleteCustomer(int idCustomer) {
	customerDao.deleteCustomer(idCustomer);
}
}
