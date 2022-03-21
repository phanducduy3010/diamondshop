package com.javawebtesting.service.user;

import com.javawebtesting.dto.ProductDTO;
import com.javawebtesting.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    @Autowired
    public List<Category> getDataCategory();

    @Autowired
    public List<ProductDTO> getAllProductsPagination(int idCategory,int start, int totalPages);

    @Autowired
    public List<ProductDTO> getAllProductsByCategoryId(int id);
}
