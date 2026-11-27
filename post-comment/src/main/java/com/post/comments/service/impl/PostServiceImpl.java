package com.post.comments.service.impl;

import com.post.comments.entity.Post;
import com.post.comments.entity.PostDetails;
import com.post.comments.repository.PostDetailsRepository;
import com.post.comments.repository.PostRepository;
import com.post.comments.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final PostDetailsRepository postDetailsRepository;
    @Override
    public Post createPost(Post post) {

        // Here we are checking if the postDetails object is not null, and if it's not,
        // we are setting the post reference in the postDetails object to the current post object.
        // This is important because it establishes the bidirectional relationship between Post
        // and PostDetails entities.By doing this, we ensure that when we save the Post entity,
        // the associated PostDetails entity is also saved correctly with the reference to the Post.

        // another way when we send post that contains postDetails object, and also inside
        // the postDetails object we have a post object, and that post object must be set inside postDetails object,
        // so that when we save the post object, the postDetails object will also be saved correctly with the reference to the post.
        if(post.getPostDetails() != null){
            post.getPostDetails().setPost(post);
        }

        //above is for one-to-one relationship.

        return postRepository.save(post);
      }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public Post updatePost(Long id, Post post) {

        Post existing = getPostById(id);

        existing.setTitle(post.getTitle());
        existing.setDescription(post.getDescription());

        return postRepository.save(existing);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getPostsByStatusAndAuthor(String status ,String author) {
        if(status != null && author != null) {
            return postRepository.findByStatusAndAuthor(status, author);
        }

        if(status != null) {
            return postRepository.findByStatus(status);
        }

        if(author != null) {
            return postRepository.findByAuthor(author);
        }

        return postRepository.findAll();
    }

    @Override
    public PostDetails createPostWithDetails(Long postId, PostDetails postDetails) {
        Post post = getPostById(postId);
        if (post != null) {
            postDetails.setPost(post);
        }

        return postDetailsRepository.save(postDetails);

    }
}
