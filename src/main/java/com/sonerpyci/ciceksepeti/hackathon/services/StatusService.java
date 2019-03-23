package com.sonerpyci.ciceksepeti.hackathon.services;

import com.sonerpyci.ciceksepeti.hackathon.dao.GiftRepository;
import com.sonerpyci.ciceksepeti.hackathon.dao.StatusRepository;
import com.sonerpyci.ciceksepeti.hackathon.models.Gift;
import com.sonerpyci.ciceksepeti.hackathon.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private EntityManager entityManager;


    public Status findStatusById(long id){
        Optional<Status> status = statusRepository.findById(id);
        return status.orElse(null);
    }



    public Status getStatusByDescription(String searchQuery) { //"Delivered"
        Status statusSearchResult = new Status();
        Query query = entityManager.createQuery("SELECT s FROM status As s WHERE s.statusDescription =:searchQuery");
        query.setParameter("searchQuery", searchQuery);
        try {
            query.setFirstResult(0);
            query.setMaxResults(1);
            System.out.println(query.getSingleResult());
            statusSearchResult = (Status)query.getSingleResult();
        } catch (Exception e) {
            // Handle exception
        }
        return statusSearchResult;
    }

}