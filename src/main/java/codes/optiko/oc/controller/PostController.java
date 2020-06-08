package codes.optiko.oc.controller;

import codes.optiko.oc.model.*;
import codes.optiko.oc.repositories.*;
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
    private CategoryRepository categoryRepo;

    public PostController(PostRepository postRepo, UserRepository userRepo, ResponseRepository responseRepo, CommentRepository commentRepo, CategoryRepository categoryRepo){
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.responseRepo = responseRepo;
        this.commentRepo = commentRepo;
        this.categoryRepo = categoryRepo;
    }
    //***************************************


    //********* SHOW ALL POSTS ***********
    @GetMapping("/posts")
    public String showPosts(Model model){
        //da wae of jpa:
        model.addAttribute("posts", postRepo.findAllOrOrderByIdDesc());
        return "posts/index";
    }
    //***********************************


    //********* CREATE NEW POST ***********
    @GetMapping("posts/create")
    public String gotoCreatePostForm(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("category", new Category());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post, @ModelAttribute Category category) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);

        post.setCreateDate(new Timestamp(System.currentTimeMillis()));

        postRepo.save(post);

        category.setPost(post);
        categoryRepo.save(category);

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
