package br.com.cart.webservice;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cart.enums.ActionType;
import br.com.cart.enums.Entity;
import br.com.cart.model.CartProduct;
import br.com.cart.model.Log;
import br.com.cart.service.CartProductsService;
import br.com.cart.service.LogService;

@RestController
@RequestMapping("/cartproduct")
public class CartProductWS {

	@Autowired
	private CartProductsService service;

	@Autowired
	private LogService logService;

	@RequestMapping(value = "/insertproduct", method = RequestMethod.POST)
	public ResponseEntity<CartProduct> insertProduct(@RequestParam("cartid") Long cartId,
			@RequestParam("productid") Long productId, @RequestParam("quantity") Integer quantity) {

		if (cartId == null || productId == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		ActionType action = null;
		String description = null;

		CartProduct product = service.findProduct(cartId, productId);

		if (product == null) {
			product = new CartProduct(cartId, productId, quantity);

			action = ActionType.INSERT;
			description = "Insert a new product in the cart_id = " + product.getCartId();
		} else {
			product.setQuantity(product.getQuantity() + quantity);

			action = ActionType.UPDATE;
			description = "Update product";
		}

		CartProduct newProduct = service.save(product);
		logService.insert(new Log(action, Entity.CART_PRODUCT, product.getId(), description, Calendar.getInstance()));

		return new ResponseEntity<CartProduct>(newProduct, HttpStatus.OK);
	}
}
