package com.maven.pohs.cotroller;

import com.maven.pohs.model.Sell;
import com.maven.pohs.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/sell")
public class SellController {
    
 @Autowired
 ProductService ps;

 @RequestMapping(value = "ordernow/{idProduct}", method = RequestMethod.GET)
	public String ordernow(@PathVariable("idProduct") int idProduct, HttpSession session) {
		if (session.getAttribute("cart") == null) {
			List<Sell> cart = new ArrayList<Sell>();
			cart.add(new Sell(ps.getProduct(idProduct), 1));
			session.setAttribute("cart", cart);
		} else {
			List<Sell> cart = (List<Sell>) session.getAttribute("cart");
			int index = this.exists(idProduct, cart);
			if (index == -1) {
				cart.add(new Sell(ps.getProduct(idProduct), 1));
			} else {
				Integer quantityProduct = cart.get(index).getProduct().getQuantityProduct() + 1;
				cart.get(index).getProduct().setQuantityProduct(quantityProduct);
			}
			session.setAttribute("cart", cart);
		}
		return "sellDetails";
	}

	@RequestMapping(value = "deleteProduct/{idProduct}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("idProduct") int idProduct, HttpSession session) {
		List<Sell> cart = (List<Sell>) session.getAttribute("cart");
		int index = this.exists(idProduct, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "sellDetails";
	}

	private int exists(int idProduct, List<Sell> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getIdProduct() == idProduct) {
				return i;
			}
		}
		return -1;
	}
}
