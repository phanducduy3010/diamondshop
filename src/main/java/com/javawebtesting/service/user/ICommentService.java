package com.javawebtesting.service.user;

import com.javawebtesting.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICommentService {
    public List<Comment> getAllCommentsByIdProduct(long id);
}
