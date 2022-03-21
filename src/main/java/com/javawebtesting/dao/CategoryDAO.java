package com.javawebtesting.dao;

import com.javawebtesting.dto.ProductDTO;
import com.javawebtesting.dto.ProductDTOMapper;
import com.javawebtesting.entity.Category;
import com.javawebtesting.entity.mapper.MapperCategory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAO extends BaseDAO {

    private StringBuffer sqlString() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("p.id as id_product ");
        sql.append(", p.id_category ");
        sql.append(", p.size ");
        sql.append(", p.name ");
        sql.append(", p.price ");
        sql.append(", p.sale ");
        sql.append(", p.description ");
        sql.append(", p.highlight ");
        sql.append(", p.new_product ");
        sql.append(", p.detail ");
        sql.append(", c.id as id_color ");
        sql.append(", c.name as name_color ");
        sql.append(", c.code as code_color ");
        sql.append(", c.img ");
        sql.append(", p.created_at ");
        sql.append(", p.updated_at ");
        sql.append("FROM ");
        sql.append("product AS p ");
        sql.append("INNER JOIN ");
        sql.append("color AS c ");
        sql.append("ON p.id = c.id_product ");
        return sql;
    }

    private StringBuffer sqlProductsByCategoryId(int id) {
        StringBuffer sql = sqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND id_category = " + id + " ");
        return sql;
    }

    private String sqlProductsPagination(int idCategory, int start, int totalPages) {
        StringBuffer sql = sqlProductsByCategoryId(idCategory);
        sql.append("LIMIT " + start + ", " + totalPages);
        return sql.toString();
    }

    public List <ProductDTO> getAllProductsByCategoryId(int id) {
        String sql = sqlProductsByCategoryId(id).toString();
        List<ProductDTO> listProducts = _jdbcTemplate.query(sql, new ProductDTOMapper());
        return listProducts;
    }

    public List <ProductDTO> getAllProductsPagination(int idCategory, int start, int totalPages) {
        StringBuffer sqlGetDataById = sqlProductsByCategoryId(idCategory);
        List<ProductDTO> listproductsByCategoryId = _jdbcTemplate.query(sqlGetDataById.toString(), new ProductDTOMapper());
        List<ProductDTO> listProducts = new ArrayList<ProductDTO>();
        if(listproductsByCategoryId.size() >0) {
            String sql = sqlProductsPagination(idCategory, start, totalPages);
            listProducts = _jdbcTemplate.query(sql, new ProductDTOMapper());
        }


        return listProducts;
    }

    public List<Category> getDataCategory(){
        List<Category> list = new ArrayList<Category>();
        String sql = "SELECT * FROM category";
        list = _jdbcTemplate.query(sql, new MapperCategory());
        return list;
    }
}