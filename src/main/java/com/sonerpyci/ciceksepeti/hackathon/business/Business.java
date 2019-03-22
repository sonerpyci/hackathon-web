package com.sonerpyci.ciceksepeti.hackathon.business;

import com.sonerpyci.ciceksepeti.hackathon.business.entities.Order;

import java.util.Collections;
import java.util.List;

public class Business {
    public Business(){}

    public static List<Order> findAllOrders(){
        return Collections.emptyList();
    }

    public static Order findNearestOrder(){
        return new Order();
    }

    public static List<Order> findNearestOrderList(){
        return Collections.emptyList();
    }

}
