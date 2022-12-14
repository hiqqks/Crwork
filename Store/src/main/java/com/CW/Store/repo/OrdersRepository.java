package com.CW.Store.repo;

import com.CW.Store.Entity.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository <Orders, Long> {
}
