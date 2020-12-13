package com.example.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.api.model.Comment;

@FeignClient(name = "commentFeignClient", url = "https://jsonplaceholder.typicode.com/")
public interface CommentFeignClient {

	@GetMapping("/comments")
    List<Comment> getAllComments();
 
    @GetMapping("/comments/{commentId}")
    Comment getCommentById(@PathVariable(name="commentId") Long commentId);
    
    @GetMapping("/comments")
    List<Comment> getCommentsByPostId(@RequestParam(name="postId") Long postId);
}
