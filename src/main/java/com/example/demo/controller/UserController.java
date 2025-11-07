package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getusers")
    public List<UserDTO> getUsers(){
        return userService.getAllusers();
    }

    @PostMapping("/adduser")
    public UserDTO addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @PutMapping("/updateuser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser((userDTO));
    }

    @DeleteMapping("/deleteuser")
    public String deleteUser(@RequestBody UserDTO userDTO){
        return  userService.deleteUser(userDTO);
    }

    @DeleteMapping("/deleteuserbyid/{id}")
    public String deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }

}
