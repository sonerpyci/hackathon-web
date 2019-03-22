package com.sonerpyci.ciceksepeti.hackathon.models;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "gift_id")
    private long giftId;

    @ManyToOne
    private Receiver receiver;

    @Column(name="created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date creationTime;

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGiftId() {
        return giftId;
    }

    public void setGiftId(long giftId) {
        this.giftId = giftId;
    }


    public String getCreationTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(creationTime);
    }

    public void setCreationTime(Date newDate) {
        this.creationTime = new Date();
    }

    /*@Transient
    private List pets;

    public List getPets() {
        return pets;
    }

    public void setPets(List pets) {
        this.pets = pets;
    }*/


}
