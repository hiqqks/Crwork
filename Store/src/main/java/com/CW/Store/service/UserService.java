package com.CW.Store.service;

import com.CW.Store.Entity.UserEntity;
import com.CW.Store.dto.RegisterDto;

public interface UserService {
    void saveUser(RegisterDto registerDto);
    UserEntity findUserByUsername(String username);

}
