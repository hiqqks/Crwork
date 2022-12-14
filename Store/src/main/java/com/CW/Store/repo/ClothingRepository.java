package com.CW.Store.repo;

import com.CW.Store.Entity.Clothing;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClothingRepository extends CrudRepository<Clothing, Long> {
    Optional<Clothing> findById(Long id);
}
