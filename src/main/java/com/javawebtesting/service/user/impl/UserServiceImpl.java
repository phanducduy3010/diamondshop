package com.javawebtesting.service.user.impl;

import com.javawebtesting.dao.UserDAO;
import com.javawebtesting.entity.User;
import com.javawebtesting.service.user.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public int addAccount(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        return userDAO.addAccount(user);
    }

    @Override
    public User login(User user) {
        String pass = user.getPassword();
        user = userDAO.login(user);
        if(user != null) {
            if(BCrypt.checkpw(pass, user.getPassword())) {
                return user;
            } else {
                return null;
            }
        }
        return null;
    }
}
