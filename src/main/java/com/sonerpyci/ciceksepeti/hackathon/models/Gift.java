package com.sonerpyci.ciceksepeti.hackathon.models;


import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /*@OneToMany(mappedBy = "gift", cascade = CascadeType.ALL)
    private Set<GiftConditions> giftConditionsSet;

    public List<Set<GiftConditions>> getGiftConditionsSet() {
        return Stream.of(giftConditionsSet).collect(Collectors.toList());
    }

    public Gift(GiftConditions... giftConditions) {
        this.giftConditionsSet = Stream.of(giftConditions).collect(Collectors.toSet());
        this.giftConditionsSet.forEach(x -> x.setGift(this));
    }*/



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


}
