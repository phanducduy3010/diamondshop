package com.javawebtesting.entity.mapper;

import com.javawebtesting.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUser implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setDisplay_name(rs.getString("display_name"));
        user.setAddress(rs.getString("address"));
        return user;
    }
}
