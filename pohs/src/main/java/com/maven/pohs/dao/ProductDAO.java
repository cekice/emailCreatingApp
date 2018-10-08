package com.maven.pohs.dao;

import com.maven.pohs.model.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO {
 
	@Autowired
        @Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
	public List getAllProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List productsList = session.createQuery("from Product").list();
		return productsList;
	}
 
	public Product getProduct(int idProduct) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, new Integer(idProduct));
		return product;
	}
 
	public Product addProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(product);
		return product;
	}
 
	public void updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
	}
 
	public void deleteProduct(int idProduct) {
		Session session = this.sessionFactory.getCurrentSession();
		Product c = (Product) session.load(Product.class, new Integer(idProduct));
		if (null != c) {
			session.delete(c);
		}
	}
       
}
