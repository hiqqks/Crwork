package com.CW.Store.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clothing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ClothingID;
    private String ClothingName;
    private Double ClothingPrice;
    private String Img;

    public Clothing() {

    }

    public Long getClothingID() {
        return ClothingID;
    }

    public void setClothingID(Long clothingID) {
        ClothingID = clothingID;
    }

    public String getClothingName() {
        return ClothingName;
    }

    public void setClothingName(String clothingName) {
        ClothingName = clothingName;
    }

    public Double getClothingPrice() {
        return ClothingPrice;
    }

    public void setClothingPrice(Double clothingPrice) {
        ClothingPrice = clothingPrice;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

}
