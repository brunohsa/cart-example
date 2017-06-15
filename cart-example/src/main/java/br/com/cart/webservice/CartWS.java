package br.com.cart.webservice;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cart.enums.ActionType;
import br.com.cart.enums.Entity;
import br.com.cart.model.Cart;
import br.com.cart.model.Log;
import br.com.cart.service.CartService;
import br.com.cart.service.LogService;

@RestController
@RequestMapping("/cart")
public class CartWS {

	@Autowired
	private CartService service;

	@Autowired
	private LogService logService;

	@RequestMapping(value = "/createcart", method = RequestMethod.POST)
	public Cart createCart(@RequestParam("userid") Long userId) {
		Cart cart = new Cart(userId, null);

		Cart newCart = service.createCart(cart);
		logService.insert(
				new Log(ActionType.INSERT, Entity.CART, newCart.getId(), "insert new cart", Calendar.getInstance()));

		return newCart;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity delete(@RequestParam("id") Long id) {
		Cart cart = service.findById(id);
		if (cart == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		service.delete(cart);
		logService.insert(new Log(ActionType.DELETE, Entity.CART, cart.getId(), "delte cart", Calendar.getInstance()));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/findcartbyid", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> getCartById(@RequestParam("cartid") Long id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Cart>(service.findById(id), HttpStatus.OK);
	}
}
