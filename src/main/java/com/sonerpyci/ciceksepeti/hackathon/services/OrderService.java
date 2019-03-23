package com.sonerpyci.ciceksepeti.hackathon.services;


import com.sonerpyci.ciceksepeti.hackathon.dao.OrderRepository;
import com.sonerpyci.ciceksepeti.hackathon.dao.GiftRepository;
import com.sonerpyci.ciceksepeti.hackathon.dao.StatusRepository;
import com.sonerpyci.ciceksepeti.hackathon.models.GiftConditions;
import com.sonerpyci.ciceksepeti.hackathon.models.Order;
import com.sonerpyci.ciceksepeti.hackathon.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GiftRepository giftRepository;

    @Autowired
    private StatusService statusService;

    @Autowired
    private EntityManager entityManager;

    public Collection<Order> findAllOrders() {
        List<Order> orders = new ArrayList<>();
        for (Order order : orderRepository.findAll()) {
            orders.add(order);
        }

        return orders;
    }

    public Order findNearestOrder(String latitude, String longitude) {
        List<Order> orders = new ArrayList<>();
        for (Order order : orderRepository.findAll()) {
            order.setDistance(
                Math.pow(Double.parseDouble(order.getReceiver().getLatitude().replace(',','.')) - Double.parseDouble(latitude.replace(',','.')), 2)
                +
                Math.pow(Double.parseDouble(order.getReceiver().getLongitude().replace(',','.')) - Double.parseDouble(longitude.replace(',','.')), 2)
            );
            orders.add(order);
        }


        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Double.compare(o1.getDistance(), o2.getDistance());
            }
        });

        return orders.get(0);
    }

    public List<Order> findNearestOrderList(String latitude, String longitude) {
        List<Order> orders = new ArrayList<>();
        for (Order order : orderRepository.findAll()) {
            order.setDistance(
                    Math.pow(Double.parseDouble(order.getReceiver().getLatitude().replace(',','.')) - Double.parseDouble(latitude.replace(',','.')), 2)
                            +
                    Math.pow(Double.parseDouble(order.getReceiver().getLongitude().replace(',','.')) - Double.parseDouble(longitude.replace(',','.')), 2)
            );
            orders.add(order);
        }

        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Double.compare(o1.getDistance(), o2.getDistance());
            }
        });

        return orders;
    }

    public Set<GiftConditions> getGiftConditonsByQr(Long id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        Order order = optionalOrder.orElse(null);
        GiftConditions conditions;

        if (order != null) {
            if(order.getStatus().getStatusDescription().equalsIgnoreCase("delivered")){
                return order.getGift().getGiftConditionsSet();
            }
            else{
                Status status = statusService.getStatusByDescription("Delivered");
                order.setStatus(status);
                order.getShop().setCurrentOrderCount(order.getShop().getCurrentOrderCount() + 1);
                orderRepository.save(order);
            }
        }

        return null;
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
