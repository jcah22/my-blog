package com.blog.blog.controller;

import com.blog.blog.entity.CommentEntity;
import com.blog.blog.entity.PostEntity;
import com.blog.blog.entity.UserEntity;
import com.blog.blog.service.PostService;
import com.blog.blog.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {


    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;




    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("posts",postService.getAllPost());
        return "posts/home";

    }

    @GetMapping("/new")
    public String newPostpage(){
        return "posts/create-post";
    }

    @PostMapping("/create")
    public String createPost(PostEntity post , HttpSession session){
        post.setCreatedAt(LocalDateTime.now());
        UserEntity user = userService.getuserBYId(Integer.parseInt(session.getAttribute("user_session_id").toString())).get();
        post.setUser(user);
        postService.savePost(post);
        return "redirect:/post/home";

    }

    @GetMapping("/postPage/{id}")
    public String postPage(@PathVariable Integer id, Model model){
        PostEntity post = postService.getPostById(id).orElseThrow( ()-> new IllegalArgumentException("Invalid post id"));
        List<CommentEntity> comments = post.getComments();
        model.addAttribute("post",post);
        model.addAttribute("comments",comments);
        return "/posts/post-page";
    }

    @GetMapping("/mine")
    public String myPost(Model model,HttpSession session){
        Integer userId = Integer.parseInt(session.getAttribute("user_session_id").toString());
        List<PostEntity> posts = postService.getPostByUserId(userId);
        model.addAttribute("posts",posts);
        return "posts/my-post";

    }

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable Integer id, Model model){
        PostEntity post = postService.getPostById(id).orElseThrow( ()-> new IllegalArgumentException("Invalid post id"));
        model.addAttribute("post",post);
        return "posts/update-post";
    }


    @GetMapping("/update")
    public String updatePost(PostEntity post ,@RequestParam("idPost") Integer id){
    postService.updatePost(id, post);

    return "redirect:/post/mine";

    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Integer id){
        postService.deletePost(id);
        return "redirect:/post/mine";
    }






}
