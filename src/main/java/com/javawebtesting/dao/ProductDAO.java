package com.javawebtesting.dao;

import com.javawebtesting.dto.ProductDTO;
import com.javawebtesting.dto.ProductDTOMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO extends BaseDAO{

    private final boolean YES = true;
    private final boolean NO = false;

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

    private String sqlProducts(boolean newProduct, boolean highLight) {
        StringBuffer sql = sqlString();
        sql.append("WHERE 1 = 1 ");
        if (highLight) {
            sql.append("AND p.highlight = true ");
        }
        if (newProduct) {
            sql.append("AND p.new_product = true ");
        }
        sql.append("GROUP BY p.id, c.id_product ");
        sql.append("ORDER BY RAND() ");
        if (highLight) {
            sql.append("LIMIT 9 ");
        }
        if (newProduct) {
            sql.append("LIMIT 12 ");
        }
        return sql.toString();
    }

    private String sqlProductById(long id) {
        StringBuffer sql = sqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND p.id = " + id + " ");
        sql.append("LIMIT 1 ");
        return sql.toString();
    }

    public List<ProductDTO> getDataProduct() {
        String sql = sqlProducts(NO, YES);
        List<ProductDTO> products = _jdbcTemplate.query(sql, new ProductDTOMapper());
        return  products;
    }

    public List<ProductDTO> getProductById(long id) {
        String sql = sqlProductById(id);
        List<ProductDTO> listProducts = _jdbcTemplate.query(sql, new ProductDTOMapper());
        return listProducts;
    }

    public ProductDTO findProductById(long id) {
        String sql = sqlProductById(id);
        ProductDTO product = _jdbcTemplate.queryForObject(sql, new ProductDTOMapper());
        return product;
    }
}
