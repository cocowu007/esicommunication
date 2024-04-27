package com.esi.esicommunication.posts.controller;

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

import com.esi.esicommunication.posts.dto.PostDto;
import com.esi.esicommunication.posts.service.PostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {

        @Autowired
        private PostService postService;

        @PostMapping("/posts")
        @ResponseStatus(HttpStatus.CREATED)
        public void createPost(@RequestBody PostDto postDto)
        {
            postService.createPost(postDto);
        }

        @GetMapping("/posts/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Optional<PostDto> getPostById(@PathVariable Long id)
        {
            return postService.getPostById(id);
        }

        @GetMapping("/posts")
        @ResponseStatus(HttpStatus.OK)
        public List<PostDto> getAllPosts()
        {
            return postService.getAllPosts();
        }

        @PutMapping("/posts/{id}")
        @ResponseStatus(HttpStatus.ACCEPTED)
        public void updatePost(@PathVariable Long id, @RequestBody PostDto postDto)
        {
            postService.updatePost(id, postDto);
        }

        @DeleteMapping("/posts/{id}")
        @ResponseStatus(HttpStatus.OK)
        public void deletePost(@PathVariable Long id)
        {
            postService.deletePost(id);
        }

}
