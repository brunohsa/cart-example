package br.com.cart.resource;

import org.springframework.data.repository.CrudRepository;

import br.com.cart.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {

}
