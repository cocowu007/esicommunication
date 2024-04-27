package com.esi.esicommunication.comments.dto;

import java.util.Date;

import com.esi.esicommunication.posts.model.Post;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    @Id
    private Long id;
    private String content;
    private String userId;
    private Date createdAt;
    private Post post;

    public CommentDto(Long id) {
        this.id = id;
    }
}
