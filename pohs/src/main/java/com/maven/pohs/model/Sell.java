
package com.maven.pohs.model;


public class Sell {
        
        private Product product = new Product();
	private int quantityProduct;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public Sell() {
	}

	public Sell(Product product, int quantityProduct) {
		this.product = product;
		this.quantityProduct = quantityProduct;
	}
    
}
