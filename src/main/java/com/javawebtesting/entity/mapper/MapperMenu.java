package com.javawebtesting.entity.mapper;

import com.javawebtesting.entity.Category;
import com.javawebtesting.entity.Menu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperMenu implements RowMapper<Menu> {

    public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
        Menu menu = new Menu();
        menu.setId(rs.getInt("id"));
        menu.setName(rs.getString("name"));
        menu.setUrl(rs.getString("url"));
        return menu;
    }
}