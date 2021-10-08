package com.example.cmtest.servises;

import com.example.cmtest.entities.Users;

import java.util.List;

public interface UsersService {
    public List<Users> getAllUsers();
    public Users getUsersForLogin(String login);
    public Users saveUsers(Users users);

}
