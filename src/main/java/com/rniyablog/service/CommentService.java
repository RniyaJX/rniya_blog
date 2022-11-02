package com.rniyablog.service;

import com.rniyablog.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    int saveComment(Comment comment, Comment parentComment);

    void deleteComment(Comment comment, Long id);
}
