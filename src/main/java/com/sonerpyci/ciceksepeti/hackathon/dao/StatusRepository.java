package com.sonerpyci.ciceksepeti.hackathon.dao;


import com.sonerpyci.ciceksepeti.hackathon.models.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long> {

}