package codes.optiko.oc.controller;

import codes.optiko.oc.model.Comment;
import codes.optiko.oc.model.Post;
import codes.optiko.oc.model.Response;
import codes.optiko.oc.model.User;
import codes.optiko.oc.repositories.CommentRepository;
import codes.optiko.oc.repositories.PostRepository;
import codes.optiko.oc.repositories.ResponseRepository;
import codes.optiko.oc.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;

@Controller
public class CommentController {

    //********* DEPENDENCY INJECTION ***********
    private CommentRepository commentRepo;
    private PostRepository postRepo;
    private ResponseRepository responseRepo;
    private UserRepository userRepo;

    public CommentController(CommentRepository commentRepo, PostRepository postRepo, ResponseRepository responseRepo, UserRepository userRepo){
        this.commentRepo = commentRepo;
        this.responseRepo = responseRepo;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }
    //************************************


    //********* CREATE COMMENT ***********
//    @GetMapping("posts/{post_id}/responses/{response_id}/create-comment")
//    public String createComment(@PathVariable long post_id, @PathVariable long response_id, Model model){
//
//        model.addAttribute("comments", new Comment());
//        return "posts/responses/create-comment";
//    }

    @PostMapping("/posts/{post_id}/response/{response_id}/create-comment")
    public String createResponse(@PathVariable long post_id, @PathVariable long response_id, @ModelAttribute Comment comment) {
        Response response = responseRepo.getOne(response_id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        comment.setResponse(response);
        comment.setUser(user);
        comment.setCreateDate(new Timestamp(System.currentTimeMillis()));

        commentRepo.save(comment);

        return "redirect:/posts/" + post_id;
    }
    //***********************************


    //********* EDIT COMMENT ************s
//    @GetMapping("/posts/{post_id}/response/{response_id}/edit-comment/{comment_id}")
//    public String editComment(@PathVariable long post_id, @PathVariable long comment_id, Model model){
//        model.addAttribute("post", postRepo.getPostById(post_id));
//        model.addAttribute("responses", responseRepo.findByPostId(post_id));
//        model.addAttribute("comments", commentRepo.findByResponseId(post_id));
//        model.addAttribute("comment", commentRepo.getOne(comment_id));
//
//        return "posts/show";
//    }
//
//    @PostMapping("/posts/{post_id}/response/{response_id}/edit-comment/{comment_id}")
//    public String editComment(@PathVariable long post_id, @PathVariable long response_id, @PathVariable long comment_id, @ModelAttribute Comment comment){
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Response response = responseRepo.getOne(response_id);
//
//        comment.setUser(user);
//        comment.setResponse(response);
//        comment.setId(comment_id);
//        comment.setUpdateDate(new Timestamp(System.currentTimeMillis()));
//
//        commentRepo.save(comment);
//
//        return "redirect:/posts/" + post_id;
//    }
    //************************************


    //********* DELETE COMMENT ***********
    @GetMapping("/posts/{post_id}/response/{response_id}/delete-comment/{comment_id}")
    public String deleteComment(@PathVariable long post_id, @PathVariable long response_id, @PathVariable long comment_id){
        commentRepo.deleteById(comment_id);

        return "redirect:/posts/" + post_id;
    }
    //************************************
}
