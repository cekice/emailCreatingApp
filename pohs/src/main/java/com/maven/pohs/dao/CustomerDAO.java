package com.maven.pohs.dao;

import com.maven.pohs.model.Customer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component
public class CustomerDAO {
 
	@Autowired
        @Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
	public List getAllCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List customersList = session.createQuery("from Customer").list();
		return customersList;
	}
 
	public Customer getCustomer(int idCustomer) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, new Integer(idCustomer));
		return customer;
	}
 
	public Customer addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(customer);
		return customer;
	}
 
	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(customer);
	}
 
	public void deleteCustomer(int idCustomer) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer c = (Customer) session.load(Customer.class, new Integer(idCustomer));
		if (null != c) {
			session.delete(c);
		}
	} 
}