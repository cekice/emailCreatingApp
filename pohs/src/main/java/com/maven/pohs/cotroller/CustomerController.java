package com.maven.pohs.cotroller;

import com.maven.pohs.service.CustomerService;
import com.maven.pohs.model.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;
    
     @RequestMapping("/") 
    public String home(){
        return "home"; 
    } 
    
    
    @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
    public String getAllCustomer(Model model){
        
        List listAllCustomers = customerService.getAllCustomers();
        model.addAttribute("customer", new Customer());
        model.addAttribute("listAllCustomers", listAllCustomers);
        return "customerDetails";
    }
    
    @RequestMapping(value = "/getCustomer/{idCustomer}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable int idCustomer){
    
        return customerService.getCustomer(idCustomer);
    }
    
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer) {	
		
        if(customer.getIdCustomer()== null)
		{
			customerService.addCustomer(customer);
		}
	else
		{	
			customerService.updateCustomer(customer);
		}
 
		return "redirect:/getAllCustomers";
	}
 
    @RequestMapping(value = "/updateCustomer/{idCustomer}", method = RequestMethod.GET)
    public String updateCustomer(@PathVariable("idCustomer") int idCustomer,Model model) {
	model.addAttribute("customer", this.customerService.getCustomer(idCustomer));
	model.addAttribute("listAllCustomers", this.customerService.getAllCustomers());
	return "customerDetails";
	}
 
    @RequestMapping(value = "/deleteCustomer/{idCustomer}", method = RequestMethod.GET)
    public String deleteCustomer(@PathVariable("idCustomer") int idCustomer) {
	customerService.deleteCustomer(idCustomer);
	return "redirect:/getAllCustomers";
 
	}	
}
