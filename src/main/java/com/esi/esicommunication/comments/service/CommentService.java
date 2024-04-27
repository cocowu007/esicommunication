package com.esi.esicommunication.comments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esi.esicommunication.comments.model.Comment;
import com.esi.esicommunication.comments.dto.CommentDto;
import com.esi.esicommunication.comments.repository.CommentRepository;
import com.esi.esicommunication.posts.model.Post;
import com.esi.esicommunication.posts.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public List<CommentDto> getAllComments() {
        List<Comment> comments = new ArrayList<>();
        commentRepository.findAll().forEach(comments::add);
        log.info("All comments retrieved: " + comments.size());
        return comments.stream()
                .map(this::convertToDto)
                .toList();
    }

    public Optional<CommentDto> getCommentById(Long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()) {
            log.info("Comment found with id: " + id);
        } else {
            log.error("Comment not found with id: " + id);
            throw new RuntimeException("Comment not found with id: " + id);
        }
        return commentOptional.map(this::convertToDto);
    }

    public void createComment(CommentDto commentDto) {

        Comment comment = convertToEntity(commentDto);
        commentRepository.save(comment);
        log.info("Comment created with id: " + comment.getId());
    }

    public void updateComment(Long id, CommentDto commentDto) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()) {
            Comment existingComment = commentOptional.get();
            existingComment.setContent(commentDto.getContent());
            commentRepository.save(existingComment);
            log.info("Comment updated with id: " + id);
        } else {
            log.error("Comment not found with id: " + id);
            throw new RuntimeException("Comment not found with id: " + id);
        }
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
        log.info("Comment deleted with id: " + id);
    }

    private CommentDto convertToDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .userId(comment.getUserId())
                .createdAt(comment.getCreatedAt())
                .build();
    }

    private Comment convertToEntity(CommentDto commentDto) {
        return Comment.builder()
                .id(commentDto.getId())
                .content(commentDto.getContent())
                .userId(commentDto.getUserId())
                .createdAt(commentDto.getCreatedAt())
                .build();
    }

}
