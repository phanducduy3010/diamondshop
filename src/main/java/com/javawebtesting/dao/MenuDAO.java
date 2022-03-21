package com.javawebtesting.dao;

import com.javawebtesting.entity.Category;
import com.javawebtesting.entity.Menu;
import com.javawebtesting.entity.mapper.MapperCategory;
import com.javawebtesting.entity.mapper.MapperMenu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuDAO extends BaseDAO {

    public List<Menu> getDataMenu(){
        List<Menu> list = new ArrayList<Menu>();
        String sql = "SELECT * FROM menu";
        list = _jdbcTemplate.query(sql, new MapperMenu());
        return list;
    }
}