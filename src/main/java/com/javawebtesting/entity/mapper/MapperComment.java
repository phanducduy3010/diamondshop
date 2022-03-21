package com.javawebtesting.entity.mapper;

import com.javawebtesting.entity.Comment;
import com.javawebtesting.entity.Menu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperComment implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getInt("id"));
        comment.setId_user(rs.getLong("id_user"));
        comment.getId_product(rs.getLong("id_product"));
        comment.setContent(rs.getString("content"));
        return comment;
    }

}
