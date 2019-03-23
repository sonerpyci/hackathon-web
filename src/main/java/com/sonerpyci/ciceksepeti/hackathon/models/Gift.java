package com.sonerpyci.ciceksepeti.hackathon.models;


import javax.persistence.*;
import java.util.List;

@Entity(name="gift")
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_source")
    private String imageSource;

    @Column(name = "type")
    private String type;

    @Column(name = "additional_info")
    private String additionalInfo;

    @OneToMany
    private List<GiftConditions> giftConditions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public List<GiftConditions> getGiftConditions() {
        return giftConditions;
    }

    public void setGiftConditions(List<GiftConditions> giftConditions){
        this.giftConditions = giftConditions;
    }
}
