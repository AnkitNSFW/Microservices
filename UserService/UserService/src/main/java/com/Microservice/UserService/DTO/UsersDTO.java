package com.Microservice.UserService.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersDTO {
    private int id;
    private String role;
    private String name;
    private String email;
    private String phone;
}