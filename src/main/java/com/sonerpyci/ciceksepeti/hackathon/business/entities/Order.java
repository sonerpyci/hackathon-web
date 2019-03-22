package com.sonerpyci.ciceksepeti.hackathon.business.entities;

public class Order {
    private long id;
    private Gift gift;
    private Receiver receiver;

    public Order(long id, Gift gift, Receiver receiver){
        this.id = id;
        this.gift = gift;
        this.receiver = receiver;
    }

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


    }
