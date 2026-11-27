package com.post.comments.controller;

import com.post.comments.entity.Post;
import com.post.comments.entity.PostDetails;
import com.post.comments.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(
            @PathVariable Long id,
            @RequestBody Post post) {

        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {

        postService.deletePost(id);

        return "Post Deleted Successfully";
    }


    //#################--CRUD Operations for Post end here--########################

    /**
     * Get posts by status and author.
     * If both status and author are provided, it will filter by both.
     * If only one of them is provided, it will filter by that one.
     * If neither is provided, it will return all posts.
     * <p>
     * *    so far we have learned here custom query method in the repository
     * *    layer and how to use it in the service layer and controller layer.
     * </p>
     * @param status the status of the posts to filter by (optional)
     * @param author the author of the posts to filter by (optional)
     * @return a list of posts matching the given criteria
     */

    @GetMapping("/filter")
    public List<Post> getPostsByStatusAndAuthor(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String author) {

        return postService.getPostsByStatusAndAuthor(status, author);
    }


    /**
     * Adding more details to the post with the given postId.
     * This method creates a new PostDetails object and associates it with the specified Post.
     * So far this is for unidirectional mapping.
     *
     * @param postId      the ID of the post to associate with the details
     * @param postDetails the details of the post to create
     * @return the created PostDetails object
     */
    @PostMapping("/{postId}/details")
    public PostDetails createPostWithDetails(@PathVariable Long postId, @RequestBody PostDetails postDetails) {
        return postService.createPostWithDetails(postId, postDetails);
    }










}