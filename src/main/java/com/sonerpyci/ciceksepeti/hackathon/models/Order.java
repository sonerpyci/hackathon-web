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

    @Column(name = "receiver_id")
    private long receiverId;

    @Column(name = "gift_id")
    private long giftId;

    private String address;

    private String longitute;

    private String latitude;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public long getGiftId() {
        return giftId;
    }

    public void setGiftId(long giftId) {
        this.giftId = giftId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitute() {
        return longitute;
    }

    public void setLongitute(String longitute) {
        this.longitute = longitute;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCreationTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(creationTime);
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
