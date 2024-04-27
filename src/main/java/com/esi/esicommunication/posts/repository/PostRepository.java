package com.esi.esicommunication.posts.repository;

import org.springframework.data.repository.CrudRepository;

import com.esi.esicommunication.posts.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
