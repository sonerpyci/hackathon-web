package com.sonerpyci.ciceksepeti.hackathon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="gift_conditions")
public class GiftConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long giftId;

    private String conditionKey;

    private String conditionValue;

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

    public String getConditionKey() {
        return conditionKey;
    }

    public void setConditionKey(String conditionKey) {
        this.conditionKey = conditionKey;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }
}
