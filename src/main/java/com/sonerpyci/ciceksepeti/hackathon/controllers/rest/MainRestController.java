package com.sonerpyci.ciceksepeti.hackathon.controllers.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sonerpyci.ciceksepeti.hackathon.models.Gift;
import com.sonerpyci.ciceksepeti.hackathon.models.GiftConditions;
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
import javax.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;


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

    @PostMapping(value = "/findNearestPoint" )
    public Order findNearestOrder(@RequestParam String data, HttpServletRequest req, HttpServletResponse resp){
        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(data);
        JsonObject jsonObject = jsonTree.getAsJsonObject();
        Order order = orderService.findNearestOrder(jsonObject.get("latitude").getAsString(), jsonObject.get("longitude").getAsString());

        System.out.println(order.getDistance());

        return order;
    }

    @PostMapping(value = "/findNearestPointList" )
    public List<Order> findNearestOrderList(@RequestParam String latitude, @RequestParam String longitude, HttpServletRequest req, HttpServletResponse resp){
        List<Order> orderList = orderService.findNearestOrderList(req.getParameter("latitude"), req.getParameter("longitude"));
        return orderList;
    }

    @PostMapping(value = "/getGiftConditions" )
    public Set<GiftConditions> findOrderByQr(@RequestParam String id, HttpServletRequest req, HttpServletResponse resp){
        return orderService.getGiftConditonsByQr(Long.valueOf(id));
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
