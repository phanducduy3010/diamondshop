package com.javawebtesting.service.user.impl;

import com.javawebtesting.dao.CategoryDAO;
import com.javawebtesting.dao.MenuDAO;
import com.javawebtesting.entity.Category;
import com.javawebtesting.entity.Menu;
import com.javawebtesting.service.user.ICategoryService;
import com.javawebtesting.service.user.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuDAO menuDAO;

    @Override
    public List<Menu> getDataMenu() {
        return menuDAO.getDataMenu();
    }
}
