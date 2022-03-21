package com.javawebtesting.controller;

import com.javawebtesting.service.user.ICategoryService;
import com.javawebtesting.service.user.ICommentService;
import com.javawebtesting.service.user.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController extends BaseController{

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ICommentService commentService;

    @RequestMapping(value= {"/chi-tiet-san-pham/{id}", "trang-chu/chi-tiet-san-pham/{id}"})
    public ModelAndView viewProsuctdetail(@PathVariable long id) {
        _mvShare.setViewName("user/product_detail");
        _mvShare.addObject("product", productService.getProductById(id));
        _mvShare.addObject("comment", commentService.getAllCommentsByIdProduct(id));

        int idCategory = productService.getProductById(id).getId_category();
        _mvShare.addObject("productsByIdCategory", categoryService.getAllProductsByCategoryId(idCategory));
        return _mvShare;
    }
}
