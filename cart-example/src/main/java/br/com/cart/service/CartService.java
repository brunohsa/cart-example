package br.com.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cart.model.Cart;
import br.com.cart.resource.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository repository;

	public void delete(Cart cart) {
		repository.delete(cart);
	}

	public Cart createCart(Cart cart) {
		return repository.save(cart);
	}

	public Iterable<Cart> getAll() {
		return repository.findAll();
	}

	public Cart findById(Long id) {
		return repository.findOne(id);
	}
}
