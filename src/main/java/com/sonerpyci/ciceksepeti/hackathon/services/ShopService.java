package com.sonerpyci.ciceksepeti.hackathon.services;

import com.sonerpyci.ciceksepeti.hackathon.dao.GiftRepository;
import com.sonerpyci.ciceksepeti.hackathon.dao.OrderRepository;
import com.sonerpyci.ciceksepeti.hackathon.dao.ShopRepository;
import com.sonerpyci.ciceksepeti.hackathon.models.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ShopService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GiftRepository giftRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private EntityManager entityManager;



    public Shop findNearestShop(String latitude, String longitude){
        List<Shop> shops = new ArrayList<>();
        for (Shop shop : shopRepository.findAll()) {
            shop.setDistance(
                    Math.pow(Double.parseDouble(shop.getLatitude().replace(',','.')) - Double.parseDouble(latitude.replace(',','.')), 2)
                            +
                            Math.pow(Double.parseDouble(shop.getLongitude().replace(',','.')) - Double.parseDouble(longitude.replace(',','.')), 2)
            );
            shops.add(shop);
        }


        Collections.sort(shops, new Comparator<Shop>() {
            @Override
            public int compare(Shop s1, Shop s2) {
                return Double.compare(s1.getDistance(), s2.getDistance());
            }
        });

        return shops.get(0);
    }

}
