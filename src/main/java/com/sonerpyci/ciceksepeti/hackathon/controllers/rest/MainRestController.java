package com.sonerpyci.ciceksepeti.hackathon.controllers.rest;

import com.google.gson.Gson;
import com.sonerpyci.ciceksepeti.hackathon.models.Order;
import com.sonerpyci.ciceksepeti.hackathon.services.GiftService;
import com.sonerpyci.ciceksepeti.hackathon.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;


@RestController
public class MainRestController {
    @Autowired
    ServletContext servletContext;

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

    @GetMapping(value = "/delete")
    public void deleteOrder(@RequestParam long id){
        orderService.deleteOrder(id);
    }

    @GetMapping(value = "/image/{imageName}")
    public byte[] getImage(@PathVariable String imageName) throws IOException{
        InputStream in = this.getClass().getResourceAsStream("/static/images/" + imageName);
        return IOUtils.toByteArray(in);
    }
}
