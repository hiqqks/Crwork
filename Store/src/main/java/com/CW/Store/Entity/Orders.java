package com.CW.Store.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Getter
@Setter
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long OrderID;
    private String Customer;
    private Date date;
    private String address;
    private boolean status;

    private Long IdClothingInBasket;

    public Orders(Long orderID, String customer, Date date, String address, boolean status, Long idClothingInBasket) {
        OrderID = orderID;
        Customer = customer;
        this.date = date;
        this.address = address;
        this.status = status;
        IdClothingInBasket = idClothingInBasket;
    }

    public Orders() {
    }
}
