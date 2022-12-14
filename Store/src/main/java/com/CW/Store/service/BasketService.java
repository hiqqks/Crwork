package com.CW.Store.service;

import com.CW.Store.Entity.Clothing;

public interface BasketService {

    void addClothing(Clothing clothing);

    void removeClothing(Clothing clothing);
}
