package br.com.cart.resource;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cart.model.CartProduct;

public interface CartProductsRepository extends CrudRepository<CartProduct, Long> {

	@Query("from CART_PRODUCT where CART_ID=:cartId and PRODUCT_ID=:productId")
	public CartProduct findProduct(@Param("cartId") Long cartId, @Param("productId") Long productId);
}
