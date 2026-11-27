package com.post.comments.repository;

import com.post.comments.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByStatusAndAuthor(String status, String author);

    List<Post> findByStatus(String status);

    List<Post> findByAuthor(String author);
}
