package com.maven.pohs.service;

import com.maven.pohs.dao.ProductDAO;
import com.maven.pohs.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productService")
public class ProductService {
    
@Autowired
ProductDAO productDao;
 
@Transactional
public List getAllProducts() {
	return productDao.getAllProducts();
}
 
@Transactional
public Product getProduct(int idProduct) {
	return productDao.getProduct(idProduct);
}
 
@Transactional
public void addProduct(Product product) {
	productDao.addProduct(product);
}
 
@Transactional
public void updateProduct(Product product) {
	productDao.updateProduct(product);
 
}
 
@Transactional
public void deleteProduct(int idProduct) {
	productDao.deleteProduct(idProduct);
}

}