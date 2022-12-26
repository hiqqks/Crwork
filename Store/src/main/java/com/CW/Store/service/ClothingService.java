package com.CW.Store.service;

import com.CW.Store.Entity.Clothing;

import java.util.Optional;


public interface ClothingService {
     Optional<Clothing> findById(long id);




}
