package com.sonerpyci.ciceksepeti.hackathon.business;

import com.sonerpyci.ciceksepeti.hackathon.business.entities.Gift;
import com.sonerpyci.ciceksepeti.hackathon.business.entities.Order;
import com.sonerpyci.ciceksepeti.hackathon.business.entities.Receiver;
import com.sonerpyci.ciceksepeti.hackathon.services.OrderService;

import com.sonerpyci.ciceksepeti.hackathon.business.entities.Order;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Business {
    public Business(){}

    public List<Order> getAllOrders(){
        OrderService orderService = new OrderService();

        List<Order> orders = orderService.findAllOrders().stream().map(order -> {
            Gift gift = new Gift(order.getGift().getId(), order.getGift().getName(), order.getGift().getImageSource(),
                    order.getGift().getType(), order.getGift().getAdditionalInfo());

            Receiver receiver = new Receiver(order.getReceiver().getId(), order.getReceiver().getName(), order.getReceiver().getSurname(), order.getReceiver().getAddress(),
                    order.getReceiver().getLatitude(), order.getReceiver().getLongitude());

            return new Order(order.getId(), gift, receiver);
        }).collect(Collectors.toList());

        return orders;
    }

    public static Order findNearestOrder(){
        return new Order();
    }

    public static List<Order> findNearestOrderList(){
        return Collections.emptyList();
    }

}
