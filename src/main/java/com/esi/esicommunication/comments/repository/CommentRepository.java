package com.esi.esicommunication.comments.repository;

import org.springframework.data.repository.CrudRepository;

import com.esi.esicommunication.comments.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
