package com.sonerpyci.ciceksepeti.hackathon.dao;

import com.sonerpyci.ciceksepeti.hackathon.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {


}
