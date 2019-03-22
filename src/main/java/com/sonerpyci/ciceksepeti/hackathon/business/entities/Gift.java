package com.sonerpyci.ciceksepeti.hackathon.business.entities;

public class Gift {
    private long id;
    private String name;
    private String imageSource;
    private String type;
    private String additionalInfo;

    public Gift(long id, String name, String imageSource, String type, String additionalInfo){
        this.id = id;
        this.name = name;
        this.imageSource = imageSource;
        this.type = type;
        this.additionalInfo = additionalInfo;
    }
}
