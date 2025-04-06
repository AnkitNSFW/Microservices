package com.Microservice.UserService.Service;

import com.Microservice.UserService.DTO.UsersCreationDTO;
import com.Microservice.UserService.DTO.UsersDTO;
import com.Microservice.UserService.Mapper.UsersMapper;
import com.Microservice.UserService.Model.Users;
import com.Microservice.UserService.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {
    @Autowired
    UsersRepo usersRepo;

    public List<UsersDTO> getAllUsers() {
        return usersRepo.findAll().stream()
                .map(UsersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UsersDTO getUserById(int id) {
        return usersRepo.findById(id)
                .map(UsersMapper::toDTO)
                .orElse(null);
    }
//    public UsersDTO getUserByEmail(String email) {
//        Users user = usersRepo.findByEmail(email);
//        if(user==null){
//            return UsersMapper.toDTO(user);
//        }
//        return  null;
//    }

    public UsersDTO createUser(UsersCreationDTO userCreationDTO) {
        Users user = UsersMapper.fromCreationDTO(userCreationDTO);
        Users saved = usersRepo.save(user);
        return UsersMapper.toDTO(saved);
    }

    public boolean deleteUser(int id){
        if(usersRepo.existsById(id)){
            usersRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
