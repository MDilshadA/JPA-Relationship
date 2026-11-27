package com.post.comments.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "post_details")
public class PostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer views;

    private Integer likes;

    private LocalDate publishedDate;


    // nullable false simply means that the postDetails entity cannot exist without a corresponding post entity.
    // In other words, every PostDetails must be associated with a Post,
    // and you cannot have a PostDetails record in the database that does not reference a Post.

    // joinColumn is used to specify the foreign key column in the PostDetails table
    // that will reference the primary key of the Post table.


    // @JsonIgnore can be placed on either side depending on what JSON response you want.
    // Put @JsonIgnore on the side you do not want serialized to JSON. means inside postDetails entity
    // there is post object, and we don't want to serialize that post object to JSON
    // when we return postDetails object as a response.

    @OneToOne
    @JoinColumn(name = "postId" , nullable = false)
    @JsonIgnore
    private Post post;
}