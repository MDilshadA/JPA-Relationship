package com.post.comments.service;

import com.post.comments.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment createComment(Comment comment);

    List<Comment> getAllComments();

    Comment getCommentById(Long id);

    Comment updateComment(Long id, Comment comment);

    void deleteComment(Long id);

    Comment createCommentForPost(Long postId, Comment comment);
}