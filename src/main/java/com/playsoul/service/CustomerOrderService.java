package com.playsoul.service;

import com.playsoul.model.CustomerOrder;

public interface CustomerOrderService 
{
	void addCustomerOrder(CustomerOrder customerOrder);
	double getCustomerOrderGrandTotal(int cartId);

}
