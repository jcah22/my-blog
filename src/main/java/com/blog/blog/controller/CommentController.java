package com.blog.blog.controller;

import com.blog.blog.entity.CommentEntity;
import com.blog.blog.entity.PostEntity;
import com.blog.blog.entity.UserEntity;
import com.blog.blog.service.CommentService;
import com.blog.blog.service.PostService;
import com.blog.blog.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;


    @PostMapping("/addComment")
    public String addComment(@RequestParam("postId") Integer postId, CommentEntity comment , HttpSession session){

        UserEntity user =userService.getuserBYId(Integer.parseInt(session.getAttribute("user_session_id").toString())).get();
        PostEntity post = postService.getPostById(postId).orElseThrow( ()-> new IllegalArgumentException("Invalid post id"));
        comment.setCreatedAt(LocalDateTime.now());
        comment.setUser(user);
        comment.setPost(post);
        commentService.createComment(comment);

        return "redirect:/post/postPage/" + postId;
    }
}
