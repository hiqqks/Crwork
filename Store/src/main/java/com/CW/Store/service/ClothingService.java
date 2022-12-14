package com.CW.Store.service;

import com.CW.Store.Entity.Clothing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ClothingService {

    Optional<Clothing> findById(Long id);

}
