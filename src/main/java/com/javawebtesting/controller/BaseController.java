package com.javawebtesting.controller;

import com.javawebtesting.service.user.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
public class BaseController {

    @Autowired
    private IMenuService _menuService;

    public ModelAndView _mvShare = new ModelAndView();

    @PostConstruct
    public ModelAndView init() {
        _mvShare.addObject("menu", _menuService.getDataMenu());
        return _mvShare;
    }
}
