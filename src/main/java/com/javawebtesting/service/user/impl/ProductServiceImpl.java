package com.javawebtesting.service.user.impl;

import com.javawebtesting.dao.ProductDAO;
import com.javawebtesting.dto.ProductDTO;
import com.javawebtesting.service.user.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<ProductDTO> getDataProduct() {
        List<ProductDTO> product = productDAO.getDataProduct();
        return product;
    }

    @Override
    public ProductDTO getProductById(long id) {
        return productDAO.getProductById(id).get(0);
    }
}
