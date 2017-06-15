package br.com.cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "CART_PRODUCT")
public class CartProduct {

	public CartProduct() {
		
	}

	public CartProduct(Long cartId, Long productId, Integer quantity) {
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CART_ID")
	private Long cartId;

	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "QUANTITY")
	private Integer quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
