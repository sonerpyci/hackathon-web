package com.sonerpyci.ciceksepeti.hackathon.controllers.rest;

import com.google.gson.Gson;
import com.sonerpyci.ciceksepeti.hackathon.models.Order;
import com.sonerpyci.ciceksepeti.hackathon.services.GiftService;
import com.sonerpyci.ciceksepeti.hackathon.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;


@RestController
public class MainRestController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private GiftService giftService;


    @PostMapping(value = "/searchOrder")
    public String searchOrder(@RequestParam String searchQuery, HttpServletRequest req, HttpServletResponse resp){

        List orders = orderService.findOrdersBySearch(req.getParameter("searchQuery"));
        req.setAttribute("orderResult", orders);
        return new Gson().toJson(orders);
    }

    @PostMapping(value = "/searchGift")
    public String searchGift(@RequestParam String searchQuery, HttpServletRequest req, HttpServletResponse resp){

        List gifts = giftService.findGiftsBySearch(req.getParameter("searchQuery"));
        req.setAttribute("giftsResult", gifts);
        return new Gson().toJson(gifts);
    }

    @GetMapping(value = "/findAllOrders" )
    public Collection<Order> getAllOrders(){
        return orderService.findAllOrders();
    }

    @PostMapping(value = "/findNearestPoint" )
    public Order findNearestOrder(@RequestParam String latitude, @RequestParam String longitude, HttpServletRequest req, HttpServletResponse resp){
        return orderService.findNearestOrder(req.getParameter("latitude"), req.getParameter("longitude"));
    }

    @PostMapping(value = "/findNearestPointList" )
    public List<Order> findNearestOrderList(@RequestParam String latitude, @RequestParam String longitude, HttpServletRequest req, HttpServletResponse resp){
        return orderService.findNearestOrderList(req.getParameter("latitude"), req.getParameter("longitude"));
    }

    @GetMapping(value = "/delete")
    public void deleteOrder(@RequestParam long id){
        orderService.deleteOrder(id);
    }

}
