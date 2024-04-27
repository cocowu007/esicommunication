package com.esi.esicommunication.posts.model;

import java.util.HashSet;
import java.util.Set;

import com.esi.esicommunication.comments.model.Comment;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posttable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId", nullable = false)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "userId", nullable = false)
    private String userId;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> comments = new HashSet<>();

    public Post(Long id) {
        this.id = id;
    }

}
