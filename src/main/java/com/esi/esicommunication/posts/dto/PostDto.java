package com.esi.esicommunication.posts.dto;

import java.util.HashSet;
import java.util.Set;

import com.esi.esicommunication.comments.model.Comment;

import java.util.Date;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    @Id
    private Long id;
    private String title;
    private String content;
    private String userId;
    private Date createdAt;
    private Set<Comment> comments = new HashSet<>();

    public PostDto(Long id) {
        this.id = id;
    }
}
