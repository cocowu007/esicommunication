package com.esi.esicommunication.comments.model;

import java.util.Date;

import com.esi.esicommunication.posts.model.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "commenttable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "userId", nullable = false)
    private String userId;
    @Column(name = "createdAt", nullable = false)
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private Post post;

    public Comment(Long id) {
        this.id = id;
    }
}
