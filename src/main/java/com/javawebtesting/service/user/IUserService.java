package com.javawebtesting.service.user;

import com.javawebtesting.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    public int addAccount(User user);
    public User login(User user);
}
