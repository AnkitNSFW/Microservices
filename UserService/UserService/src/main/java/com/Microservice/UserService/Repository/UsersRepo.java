package com.Microservice.UserService.Repository;

import com.Microservice.UserService.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UsersRepo extends JpaRepository<Users, Integer> {
}
