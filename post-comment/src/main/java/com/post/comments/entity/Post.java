package com.post.comments.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String title;

    private String description;

    private String status;

    //cascade means Operations on Post should propagate to PostDetails. and without post can not have Details.
    // For example, if you delete a Post, its associated PostDetails should also be deleted.
    //cascade usually goes on the parent side from where you perform save/update/delete operations.

    @OneToOne(mappedBy = "post" , cascade = CascadeType.ALL)
    private PostDetails postDetails;

    @OneToMany(mappedBy = "post" , cascade = CascadeType.ALL)
    private List<Comment> comments;
}
