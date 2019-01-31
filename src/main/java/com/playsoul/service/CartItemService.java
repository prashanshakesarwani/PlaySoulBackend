package com.playsoul.service;

import com.playsoul.model.Cart;
import com.playsoul.model.CartItem;

public interface CartItemService 
{

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);

}