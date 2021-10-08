package com.example.cmtest.UsersServiceImpl;

import com.example.cmtest.entities.Users;
import com.example.cmtest.repositories.UsersRepository;
import com.example.cmtest.servises.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Сервис для работы с пользователями
 */
@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Получить всех пользователей
     * @return
     */
    @Override
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    /**
     * Получить пользователя по логину
     * @param loginUsers
     * @return
     */
    @Override
    public Users getUsersForLogin(String loginUsers) throws EntityNotFoundException {
        return usersRepository.findById(loginUsers).orElseThrow(()-> new EntityNotFoundException ("User not found"));
    }

    /**
     * Сохранение пользователя
     * @param users
     * @return
     */
    @Override
    public Users saveUsers(Users users){
        return usersRepository.save(users);
    }

}
