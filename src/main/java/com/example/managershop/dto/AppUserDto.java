package com.example.managershop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data @AllArgsConstructor @NoArgsConstructor
public class AppUserDto {

    @NotNull
    private String Username;
    @NotNull
    private String password;
}
