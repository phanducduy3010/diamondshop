package com.javawebtesting.service.user.impl;

import com.javawebtesting.dao.CommentDAO;
import com.javawebtesting.entity.Comment;
import com.javawebtesting.service.user.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceImpl implements ICommentService {

    @Autowired
    CommentDAO commentDAO;

    @Override
    public List<Comment> getAllCommentsByIdProduct(long id) {
        return commentDAO.getAllCommentsByIdProduct(id);
    }
}
