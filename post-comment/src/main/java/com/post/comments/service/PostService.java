package com.post.comments.service;

import com.post.comments.entity.Post;
import com.post.comments.entity.PostDetails;

import java.util.List;

public interface PostService {

    Post createPost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post updatePost(Long id, Post post);

    void deletePost(Long id);

    List<Post> getPostsByStatusAndAuthor(String status ,String author);

    PostDetails createPostWithDetails(Long postId, PostDetails postDetails);
}