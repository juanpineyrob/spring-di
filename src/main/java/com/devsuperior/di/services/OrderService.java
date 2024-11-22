package com.devsuperior.di.services;

import com.devsuperior.di.entities.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    ShippingService shippingService;

    public double total(Order order) {
        return (order.getBasic() + shippingService.shipment(order)) - (order.getBasic() * (order.getDiscount() / 100));
    }
}
