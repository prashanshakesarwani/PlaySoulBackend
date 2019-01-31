package com.playsoul.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playsoul.dao.CartItemDAO;
import com.playsoul.model.Cart;
import com.playsoul.model.CartItem;
import com.playsoul.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService
{
    @Autowired
    private CartItemDAO cartItemDao;

    public void addCartItem(CartItem cartItem)
    {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem)
    {
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart)
    {
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductId(int productId)
    {
        return cartItemDao.getCartItemByProductId(productId);
    }

}