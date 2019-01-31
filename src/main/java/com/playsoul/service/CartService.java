package com.playsoul.service;

import com.playsoul.model.Cart;

public interface CartService 
{
	Cart getCartById(int cartId);

    void update(Cart cart);
}