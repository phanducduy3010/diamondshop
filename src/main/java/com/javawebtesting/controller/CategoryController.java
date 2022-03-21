package com.javawebtesting.controller;

import com.javawebtesting.dto.PaginationDTO;
import com.javawebtesting.service.user.ICategoryService;
import com.javawebtesting.service.user.IPaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController extends BaseController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPaginationService paginationService;

    private int totalProductsPerPage = 9;

    @RequestMapping(value = "/san-pham/{idCategory}")
    public ModelAndView showProductInCategory(@PathVariable String idCategory) {
        _mvShare.setViewName("user/category");
        int totalProducts = categoryService.getAllProductsByCategoryId(Integer.parseInt(idCategory)).size();
        PaginationDTO paginationDTO = paginationService.getPaginationInfo(totalProducts, totalProductsPerPage, 1);
_mvShare.addObject("paginationInfo", paginationDTO);
        _mvShare.addObject("idCategory", idCategory);
        _mvShare.addObject("allProductsPagination", categoryService.getAllProductsPagination(Integer.parseInt(idCategory), paginationDTO.getStart(), totalProductsPerPage));
        return _mvShare;
    }

    @RequestMapping(value = "/san-pham/{idCategory}/{currentPage}")
    public ModelAndView showProductInCategoryAndPagination(@PathVariable String idCategory, @PathVariable String currentPage) {
        _mvShare.setViewName("user/category");
        int totalProducts = categoryService.getAllProductsByCategoryId(Integer.parseInt(idCategory)).size();
        PaginationDTO paginationDTO = paginationService.getPaginationInfo(totalProducts, totalProductsPerPage, Integer.parseInt(currentPage));
        _mvShare.addObject("paginationInfo", paginationDTO);
        _mvShare.addObject("idCategory", idCategory);
        _mvShare.addObject("allProductsPagination", categoryService.getAllProductsPagination(Integer.parseInt(idCategory), paginationDTO.getStart(), totalProductsPerPage));
        return _mvShare;
    }
}
