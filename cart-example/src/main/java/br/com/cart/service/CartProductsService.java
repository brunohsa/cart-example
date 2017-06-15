package br.com.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cart.model.CartProduct;
import br.com.cart.resource.CartProductsRepository;

@Service
public class CartProductsService {

	@Autowired
	private CartProductsRepository repository;

	public CartProduct save(CartProduct products) {
		return repository.save(products);
	}

	public CartProduct findProduct(Long cartId, Long productId) {
		return repository.findProduct(cartId, productId);
	}
}
