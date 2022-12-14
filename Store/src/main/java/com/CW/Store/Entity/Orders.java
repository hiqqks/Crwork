package com.CW.Store.Entity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public Long getOrderID() {
        return OrderID;
    }

    public void setOrderID(Long orderID) {
        OrderID = orderID;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getIdClothingInBasket() {
        return IdClothingInBasket;
    }

    public void setIdClothingInBasket(Long idClothingInBasket) {
        IdClothingInBasket = idClothingInBasket;
    }



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
