package com.esi.esicommunication.posts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esi.esicommunication.posts.dto.PostDto;
import com.esi.esicommunication.posts.model.Post;
import com.esi.esicommunication.posts.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostDto> getAllPosts() {
        List<Post> posts =  new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        log.info("Posts found: " + posts.size());
        return posts.stream()
                .map(this::convertToDto)
                .toList();
    }

    public Optional<PostDto> getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            log.info("Post found with id: " + id);
        } else {
            log.error("Post not found with id: " + id);
            throw new RuntimeException("Post not found with id: " + id);
        }
        return post.map(this::convertToDto);
    }

    public void createPost(PostDto postDto) {
        Post post = convertToEntity(postDto);
        postRepository.save(post);
        log.info("Post created with id: " + post.getId());
    }

    public void updatePost(Long id, PostDto postDto) {
        Optional<Post> existingPostOptional = postRepository.findById(id);
        if (existingPostOptional.isPresent()) {
            Post existingPost = existingPostOptional.get();
            existingPost.setTitle(postDto.getTitle());
            existingPost.setContent(postDto.getContent());
            // Update other fields if needed
            postRepository.save(existingPost);
            log.info("Post updated with id: " + id);
        } else {
            log.error("Post not found with id: " + id);
            throw new RuntimeException("Post not found with id: " + id);
        }
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
        log.info("Post deleted with id: " + id);
    }

    private PostDto convertToDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .userId(post.getUserId())
                .createdAt(post.getCreatedAt())
                .comments(post.getComments())
                .build();
    }

    private Post convertToEntity(PostDto postDto) {
        return  Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .userId(postDto.getUserId())
                .createdAt(postDto.getCreatedAt())
                .comments(postDto.getComments())
                .build();
    }

}
