package com.CW.Store.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Clothing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ClothingID;
    private String ClothingName;
    private BigDecimal ClothingPrice;
    private String Img;

    public BigDecimal getClothingPrice() {
        return ClothingPrice;
    }

    public void setClothingPrice(BigDecimal clothingPrice) {
        ClothingPrice = clothingPrice;
    }

    @Override
    public int hashCode() {
        return ClothingID.hashCode();
    }
}
