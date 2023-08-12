package com.learning.socialmediaapi.controller;

import com.learning.socialmediaapi.entity.Post;
import com.learning.socialmediaapi.entity.User;
import com.learning.socialmediaapi.exceptions.UserNotFoundException;
import com.learning.socialmediaapi.repository.PostRepository;
import com.learning.socialmediaapi.repository.UserRepository;
import jakarta.validation.Valid;
import org.apache.catalina.realm.X509UsernameRetriever;
import org.hibernate.boot.model.process.internal.UserTypeResolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class PostController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;
    @GetMapping("/users/{id}/posts")
    public List<Post> getAllPostsOfUserByID(@PathVariable int id){
        User user = userRepository.findById(id).orElse(null);
        if(Objects.isNull(user)) throw new UserNotFoundException("Id not found");
        return user.getPosts();
    }

    @GetMapping("/users/{id}/posts/{postId}")
    public Post getPostOfUserByID(@PathVariable int id, @PathVariable int postId){
        User user = userRepository.findById(id).orElse(null);
        if(Objects.isNull(user)) throw new UserNotFoundException("Id not found");
        return user.getPosts().stream().filter(post-> post.getId()==postId).findFirst().orElse(null);
    }

    @PostMapping("/users/{id}/posts")
    public Post createPostsForUserByID(@PathVariable int id, @Valid @RequestBody Post post){
        User user = userRepository.findById(id).orElse(null);
        if(Objects.isNull(user)) throw new UserNotFoundException("Id not found");
        post.setUser(user);
        postRepository.save(post);
        return post;
    }

}
