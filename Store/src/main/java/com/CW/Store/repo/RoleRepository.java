package com.CW.Store.repo;

import com.CW.Store.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer>, CrudRepository<Role,Integer> {

    Optional<Role> findByName(String username);

}
