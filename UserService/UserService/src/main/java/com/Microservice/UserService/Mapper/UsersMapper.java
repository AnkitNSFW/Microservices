package com.Microservice.UserService.Mapper;

import com.Microservice.UserService.DTO.UsersCreationDTO;
import com.Microservice.UserService.DTO.UsersDTO;
import com.Microservice.UserService.Model.Users;

public class UsersMapper {
    public static UsersDTO toDTO(Users user) {
        return UsersDTO.builder()
                .id(user.getId())
                .role(user.getRole())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    public static Users fromCreationDTO(UsersCreationDTO dto) {
        return Users.builder()
                .role(dto.getRole())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .build();
    }
}
