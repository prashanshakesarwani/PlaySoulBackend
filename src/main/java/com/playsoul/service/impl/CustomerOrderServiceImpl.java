package com.playsoul.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playsoul.dao.CustomerOrderDAO;
import com.playsoul.model.Cart;
import com.playsoul.model.CartItem;
import com.playsoul.model.CustomerOrder;
import com.playsoul.service.CartService;
import com.playsoul.service.CustomerOrderService;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService
{

    @Autowired
    private CustomerOrderDAO customerOrderDAO;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder)
    {
        customerOrderDAO.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cartId)
    {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems)
        {
            grandTotal += item.getTotalPrice();
        }
        return grandTotal;
    }
}