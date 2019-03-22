package com.sonerpyci.ciceksepeti.hackathon.services;


import com.sonerpyci.ciceksepeti.hackathon.dao.OrderRepository;
import com.sonerpyci.ciceksepeti.hackathon.dao.GiftRepository;
import com.sonerpyci.ciceksepeti.hackathon.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GiftRepository giftRepository;

    @Autowired
    private EntityManager entityManager;

    public Collection<Order> findAllOrders() {
        List<Order> orders = new ArrayList<>();
        for (Order order : orderRepository.findAll()) {
            orders.add(order);
        }

        return orders;
    }

    public void deleteOrder(long id){
        orderRepository.deleteById(id);
    }

    public Order findOrderById(long id){
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }



    public void saveOrder(Order order){
        orderRepository.save(order);
    }


    public List findOrdersBySearch(String searchQuery) {
        List orderSearchResult = new ArrayList<>();
        Query query = entityManager.createQuery("SELECT o FROM order o");
        //query.setParameter("searchQuery", '%'+searchQuery+'%');
        try {
            orderSearchResult = query.getResultList();
        } catch (Exception e) {
            // Handle exception
        }
        return orderSearchResult;
    }



}
