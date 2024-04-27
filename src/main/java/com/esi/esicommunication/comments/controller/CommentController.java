package com.esi.esicommunication.comments.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.esi.esicommunication.comments.service.CommentService;
import com.esi.esicommunication.comments.dto.CommentDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@RequestBody CommentDto commentDto)
    {
        commentService.createComment(commentDto);
    }

    @GetMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CommentDto> getCommentById(@PathVariable Long id)
    {
        return commentService.getCommentById(id);
    }

    @GetMapping("/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getAllComments()
    {
        return commentService.getAllComments();
    }

    @PutMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto)
    {
        commentService.updateComment(id, commentDto);
    }

    @DeleteMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable Long id)
    {
        commentService.deleteComment(id);
    }

    

}
