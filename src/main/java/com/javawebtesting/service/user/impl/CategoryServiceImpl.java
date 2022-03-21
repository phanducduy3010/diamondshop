package com.javawebtesting.service.user.impl;

import com.javawebtesting.dao.CategoryDAO;
import com.javawebtesting.dao.SlidesDAO;
import com.javawebtesting.dto.ProductDTO;
import com.javawebtesting.entity.Category;
import com.javawebtesting.entity.Slides;
import com.javawebtesting.service.user.ICategoryService;
import com.javawebtesting.service.user.ISlidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Category> getDataCategory() {
        return categoryDAO.getDataCategory();
    }

    @Override
    public List<ProductDTO> getAllProductsPagination(int idCategory, int start, int totalPages) {
        List<ProductDTO> products = categoryDAO.getAllProductsPagination(idCategory, start, totalPages);
        return products;
    }

    @Override
    public List<ProductDTO> getAllProductsByCategoryId(int id) {
        return categoryDAO.getAllProductsByCategoryId(id);
    }
}
