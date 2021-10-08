package com.example.cmtest.controllers;

import com.example.cmtest.entities.Roles;
import com.example.cmtest.entities.Users;
import com.example.cmtest.UsersServiceImpl.UsersServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@RestController
public class UsersController {

    private UsersServiceImpl usersService;

    @Autowired
    public void setUsersService(UsersServiceImpl usersService) {
        this.usersService = usersService;
    }

    /**
     * Получение всех пользователей
     * @return - список всех пользователей
     */
    @GetMapping(value = "/users")
    public ResponseEntity<String> allUsers(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return new ResponseEntity<String>( mapper.writeValueAsString(usersService.getAllUsers()), HttpStatus.OK);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<String>( e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Получение пользователя по логину
     * @param login - логин пользователя
     * @return - данные пользователя или ошибка
     */
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUsers(@RequestParam(name =  "login") String login){
        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<String> responseEntity;

        if(login == null || login.length() < 1 || login.length() > 255){
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }

        try {
            Users users = usersService.getUsersForLogin(login);
            responseEntity = new ResponseEntity<>(mapper.writeValueAsString(users), HttpStatus.OK);

        } catch(EntityNotFoundException | JsonProcessingException ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


    /**
     *
     * @return
     */
    @PostMapping(value = "/user")
    public String addUsers(@RequestBody Users users){

        System.out.println(users.toString());

        return "OK";
    }
}
