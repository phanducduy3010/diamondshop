package com.javawebtesting.dao;

import com.javawebtesting.entity.User;
import com.javawebtesting.entity.mapper.MapperUser;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends BaseDAO{

    public int addAccount(User user) {
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT ");
        sql.append("INTO user ");
        sql.append("( ");
        sql.append("   username, ");
        sql.append("   password, ");
        sql.append("   display_name, ");
        sql.append("   address ");
        sql.append(") ");
        sql.append("VALUES ");
        sql.append("( ");
        sql.append("   '" + user.getUsername() + "', ");
        sql.append("   '" + user.getPassword() + "', ");
        sql.append("   '" + user.getDisplay_name() + "', ");
        sql.append("   '" + user.getAddress() + "' ");
        sql.append(")");

        int insert = _jdbcTemplate.update(sql.toString());
        return insert;
    }

    public User login(User user) {
        String sql = "SELECT * FROM user WHERE username = '" +user.getUsername() +"'";

       User rs = _jdbcTemplate.queryForObject(sql, new MapperUser());
       return rs;
    }
}
