package com.javawebtesting.dao;

import com.javawebtesting.entity.Comment;
import com.javawebtesting.entity.mapper.MapperComment;

import java.util.List;

public class CommentDAO extends BaseDAO{

    private String getAllCommentsByIdProductSql(long id){
        StringBuffer sql = null;
        sql.append("SELECT * FROM comment ");
        sql.append("WHERE ");
        sql.append("id_product = " + id);
        return sql.toString();
    }

    public List<Comment> getAllCommentsByIdProduct(long id) {
        String sql = getAllCommentsByIdProductSql(id);
        List<Comment> comments = _jdbcTemplate.query(sql, new MapperComment());
        return comments;
    }
}
