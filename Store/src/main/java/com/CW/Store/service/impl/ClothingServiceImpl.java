package com.CW.Store.service.impl;

import com.CW.Store.Entity.Clothing;
import com.CW.Store.repo.ClothingRepository;
import com.CW.Store.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClothingServiceImpl implements ClothingService {

    private final ClothingRepository clothingRepository;

    @Autowired
    public ClothingServiceImpl(ClothingRepository clothingRepository) {
        this.clothingRepository = clothingRepository;
    }
    @Override
    public Optional<Clothing> findById(long id) {
        return clothingRepository.findById(id);
    }


}
