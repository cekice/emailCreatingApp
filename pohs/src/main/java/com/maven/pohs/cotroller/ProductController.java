package com.maven.pohs.cotroller;

import com.maven.pohs.model.Product;
import com.maven.pohs.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    
    @Autowired
    ProductService productService;
    
     @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    public String getAllProducts(Model model){
        
        List listAllProducts = productService.getAllProducts();
        model.addAttribute("product", new Product());
        model.addAttribute("listAllProducts", listAllProducts);
        return "productDetails";
    }
    
    @RequestMapping(value = "/getProduct/{idProduct}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int idProduct){
    
        return productService.getProduct(idProduct);
    }
    
    
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {	
		
        if(product.getIdProduct()== null)
		{
			productService.addProduct(product);
		}
	else
		{	
			productService.updateProduct(product);
		}
 
		return "redirect:/getAllProducts";
	}
 
    @RequestMapping(value = "/updateProduct/{idProduct}", method = RequestMethod.GET)
    public String updateProduct(@PathVariable("idProduct") int idProduct,Model model) {
	model.addAttribute("product", this.productService.getProduct(idProduct));
	model.addAttribute("listAllProducts", this.productService.getAllProducts());
	return "productDetails";
	}
 
    @RequestMapping(value = "/deleteProduct/{idProduct}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("idProduct") int idProduct) {
	productService.deleteProduct(idProduct);
	return "redirect:/getAllProducts";
 
	}	
        
   
}
