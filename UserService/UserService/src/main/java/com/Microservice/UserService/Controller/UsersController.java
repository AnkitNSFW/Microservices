package com.Microservice.UserService.Controller;


import com.Microservice.UserService.DTO.UsersCreationDTO;
import com.Microservice.UserService.DTO.UsersDTO;
import com.Microservice.UserService.Model.Users;
import com.Microservice.UserService.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UsersDTO>> getAllUsers(){
        List<UsersDTO> usersList = usersService.getAllUsers();
        if (usersList.isEmpty()){
//            Return Response code 204 i.e. No Content if Users Table is Empty
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getUserById(@PathVariable int id){
        UsersDTO user = usersService.getUserById(id);
        if(user==null){
//            Return Response Code 204 i.e. No Content when User with certain id in not found
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UsersDTO> createUser(@RequestBody UsersCreationDTO userCreationDTO){
        UsersDTO newUser = usersService.createUser(userCreationDTO);
        URI newUserUrl = URI.create("/user/"+newUser.getId());
        return ResponseEntity.created(newUserUrl).body(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id){
        if (usersService.deleteUser(id)){
            return ResponseEntity.ok("User Deleted Successfully");
        }
        return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
    }
}
