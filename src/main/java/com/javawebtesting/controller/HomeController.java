package com.javawebtesting.controller;

import com.javawebtesting.service.user.ICategoryService;
import com.javawebtesting.service.user.IProductService;
import com.javawebtesting.service.user.ISlidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{

    @Autowired
    ISlidesService slidesService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    IProductService productService;

    @RequestMapping(value = { "/", "/trang-chu" })
    public ModelAndView index() {
        _mvShare.setViewName("user/index");
        _mvShare.addObject("slides", slidesService.getDataSlides());
        _mvShare.addObject("category", categoryService.getDataCategory());
        _mvShare.addObject("product", productService.getDataProduct());
        return _mvShare;
    }
}
