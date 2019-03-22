package com.sonerpyci.ciceksepeti.hackathon.services;

import com.sonerpyci.ciceksepeti.hackathon.dao.GiftRepository;
import com.sonerpyci.ciceksepeti.hackathon.models.Gift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class GiftService {

    @Autowired
    private GiftRepository giftRepository;

    @Autowired
    private EntityManager entityManager;

    /* GIFT MODEL OPERATIONS */
    public Collection<Gift> findAllGifts(){
        List<Gift> gifts = new ArrayList<>();
        for (Gift gift : giftRepository.findAll()) {
            gifts.add(gift);
        }
        return gifts;
    }

    public Gift findGiftById(long id){
        Optional<Gift> pet = giftRepository.findById(id);
        return pet.orElse(null);
    }


    public void deleteGift(long id){
        giftRepository.deleteById(id);
    }

    public void saveGift(Gift gift){
        giftRepository.save(gift);
        System.out.println();
    }

    public List findGiftsByOwnerId(Long id) {
        List gifts = new ArrayList<>();
        Query query = entityManager.createQuery("SELECT u FROM gift u WHERE u.owner=:owner");
        query.setParameter("owner", id);
        try {
            gifts = query.getResultList();
        } catch (Exception e) {
            // Handle exception
        }
        return gifts;
    }

    public List findGiftsBySearch(String searchQuery) {
        List giftSearchResult = new ArrayList<>();
        Query query = entityManager.createQuery("SELECT p FROM gift As p WHERE p.name LIKE:searchQuery");
        query.setParameter("searchQuery", '%'+searchQuery+'%');
        try {
            giftSearchResult = query.getResultList();
            System.out.println();
        } catch (Exception e) {
            // Handle exception
        }
        return giftSearchResult;
    }

}
