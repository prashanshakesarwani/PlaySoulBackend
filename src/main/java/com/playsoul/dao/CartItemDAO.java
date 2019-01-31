package com.playsoul.dao;

import com.playsoul.model.Cart;
import com.playsoul.model.CartItem;

public interface CartItemDAO 
{

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
}