package com.CW.Store.service;

import com.CW.Store.Entity.Clothing;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {

    void addProduct(Clothing clothing);

    void removeProduct(Clothing clothing);

    Map<Clothing, Integer> getProductsInCart();

    void checkout();

    BigDecimal getTotal();

}
