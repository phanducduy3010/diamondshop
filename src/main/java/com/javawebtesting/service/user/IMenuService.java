package com.javawebtesting.service.user;

import com.javawebtesting.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMenuService {
    @Autowired
    public List<Menu> getDataMenu();
}
