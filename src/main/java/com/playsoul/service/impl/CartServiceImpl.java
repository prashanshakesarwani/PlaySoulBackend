package com.playsoul.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playsoul.dao.CartDAO;
import com.playsoul.model.Cart;
import com.playsoul.service.CartService;


@Service
public class CartServiceImpl implements CartService
{
    @Autowired
    private CartDAO cartDao;

    public Cart getCartById(int cartId)
    {
        return cartDao.getCartById(cartId);
    }

    public void update(Cart cart)
    {
        cartDao.update(cart);
    }
}