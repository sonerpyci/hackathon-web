package com.sonerpyci.ciceksepeti.hackathon.models;


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

    @OneToOne
    private Gift gift;

    @ManyToOne
    private Receiver receiver;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
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

    public Gift getGift() {
        return gift;
    }

    public void setGiftId(Gift gift) {
        this.gift = gift;
    }


    public String getCreationTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(creationTime);
    }

    public void setCreationTime() {
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
