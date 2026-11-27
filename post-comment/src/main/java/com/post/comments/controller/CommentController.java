package com.post.comments.controller;

import com.post.comments.entity.Comment;
import com.post.comments.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public Comment createComment(
            @RequestBody Comment comment) {

        return commentService.createComment(comment);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(
            @PathVariable Long id) {

        return commentService.getCommentById(id);
    }

    @PutMapping("/{id}")
    public Comment updateComment(
            @PathVariable Long id,
            @RequestBody Comment comment) {

        return commentService.updateComment(id, comment);
    }

    @DeleteMapping("/{id}")
    public String deleteComment(
            @PathVariable Long id) {

        commentService.deleteComment(id);

        return "Comment Deleted Successfully";
    }


    //http://localhost:8080/comments/1/comments
    //this endpoint is used to create a comment for a specific post.
    //The postId is passed as a path variable in the URL, and the comment data
    @PostMapping("/{postId}/comments")
    public Comment createCommentForPost(
            @PathVariable Long postId,
            @RequestBody Comment comment) {

        return commentService.createCommentForPost(postId, comment);
    }
}
