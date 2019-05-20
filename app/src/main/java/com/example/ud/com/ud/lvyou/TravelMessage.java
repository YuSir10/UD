package com.example.ud.com.ud.lvyou;

public class TravelMessage {
    private int imagerid;
    private String name;
    private String organizerName;
    private String content;
    private String price;

    public TravelMessage(){

    }

    public TravelMessage(int imagerid, String name, String organizerName, String content, String price) {
        this.imagerid = imagerid;
        this.name = name;
        this.organizerName = organizerName;
        this.content = content;
        this.price = price;
    }

    public int getImagerid() {
        return imagerid;
    }

    public void setImagerid(int imagerid) {
        this.imagerid = imagerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
