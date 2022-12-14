package com.CW.Store.service.impl;

import com.CW.Store.Entity.Clothing;
import com.CW.Store.Entity.Orders;
import com.CW.Store.repo.ClothingRepository;
import com.CW.Store.repo.OrdersRepository;
import com.CW.Store.repo.RoleRepository;
import com.CW.Store.repo.UserRepository;
import com.CW.Store.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {


    private final ClothingRepository clothingRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final OrdersRepository ordersRepository;

    private Map<Clothing, Integer> clothings = new LinkedHashMap<>();

    @Autowired
    public ShoppingCartServiceImpl(ClothingRepository clothingRepository, UserRepository userRepository, RoleRepository roleRepository, OrdersRepository ordersRepository) {
        this.clothingRepository = clothingRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.ordersRepository = ordersRepository;
    }

    @Override
    public void addProduct(Clothing clothing) {
        if(clothings.containsKey(clothing)){
            clothings.replace(clothing, clothings.get(clothing)+1);
        } else {
            clothings.put(clothing, 1);
        }
    }

    @Override
    public void removeProduct(Clothing clothing) {
        if(clothings.containsKey(clothing)){
            if (clothings.get(clothing)>1)
                clothings.replace(clothing,clothings.get(clothing)-1);
            else if (clothings.get(clothing) == 1){
                clothings.remove(clothing);
            }
        }

    }

    @Override
    public Map<Clothing, Integer> getProductsInCart() {
      return Collections.unmodifiableMap(clothings);
    }

    @Override
    public void checkout(Orders orders) {

        clothings.clear();
    }
    @Override
    public void clearCart() {
        clothings.clear();
    }

    @Override
    public BigDecimal getTotal() {
      return clothings.entrySet().stream()
              .map(entry -> entry.getKey().getClothingPrice().multiply(BigDecimal.valueOf(entry.getValue())))
              .reduce(BigDecimal::add)
              .orElse(BigDecimal.ZERO);
    }

    @Override
    public int getAmountOfItems() {
       int amount = clothings.size();
       return amount;
    }
}
