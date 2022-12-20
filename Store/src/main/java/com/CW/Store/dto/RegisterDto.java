package com.CW.Store.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegisterDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
