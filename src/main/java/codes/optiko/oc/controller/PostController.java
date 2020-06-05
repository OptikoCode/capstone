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
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
public class PostController {

    //********* DEPENDENCY INJECTION ***********
    private PostRepository postRepo;
    private UserRepository userRepo;
    private ResponseRepository responseRepo;
    private CommentRepository commentRepo;

    public PostController(PostRepository postRepo, UserRepository userRepo, ResponseRepository responseRepo, CommentRepository commentRepo){
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.responseRepo = responseRepo;
        this.commentRepo = commentRepo;
    }
    //***************************************


    //********* SHOW ALL POSTS ***********
    @GetMapping("/posts")
    public String showPosts(Model model){
        //da wae of jpa:
        model.addAttribute("posts", postRepo.findAllAndCountResponsesOrderByPostIdDesc());
        return "posts/index";
    }
    //***********************************


    //********* CREATE NEW POST ***********
    @GetMapping("posts/create")
    public String gotoCreatePostForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        post.setCreateDate(new Timestamp(System.currentTimeMillis()));
        postRepo.save(post);
        return "redirect:/posts";
    }
    //***********************************


    //********* SHOW SINGLE POST ***********
    //view individual post with id
    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepo.getPostById(id));
        //can also do .getOne(id), which is JPA, instead of .getPostById(id);
        model.addAttribute("responses", responseRepo.findResponsesByPostId(id));
        model.addAttribute("response", new Response());
        model.addAttribute("comments", commentRepo.findByResponseId(id));
        model.addAttribute("comment", new Comment());

        return "posts/show";
    }
    //***********************************


    //********* EDIT A POST ***********
    @GetMapping("/posts/edit/{id}")
    public String postEditForm(@PathVariable long id, Model model) {
        Post post = postRepo.getPostById(id);
        model.addAttribute("post", post);
        return "posts/edit-post";
    }

    @PostMapping("/posts/edit/{id}")
    public String postEdit(@PathVariable long id, @ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        post.setId(id);
        post.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        post.setUser(user);

        postRepo.save(post);
        return "redirect:/posts/" + id;
    }
    //***********************************


    //********* DELETE A POST ***********
    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id, Model model){

        postRepo.deleteById(id);
        return "redirect:/posts";
    }
    //***********************************
}
