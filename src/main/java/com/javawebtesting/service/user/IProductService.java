package com.javawebtesting.service.user;

import com.javawebtesting.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {

    @Autowired
    public List<ProductDTO> getDataProduct();

    public ProductDTO getProductById(long id);
}
