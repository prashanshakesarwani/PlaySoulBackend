package com.playsoul.dao;
import java.io.IOException;
import com.playsoul.model.Cart;

public interface CartDAO
{

    Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);

}