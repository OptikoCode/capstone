package codes.optiko.oc.controller;

import codes.optiko.oc.model.Category;
import codes.optiko.oc.model.Comment;
import codes.optiko.oc.model.Post;
import codes.optiko.oc.model.User;
import codes.optiko.oc.repositories.CategoryRepository;
import codes.optiko.oc.repositories.PostRepository;
import codes.optiko.oc.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    //********* DEPENDENCY INJECTION ***********
    private CategoryRepository categoryRepo;
    private UserRepository userRepo;
    private PostRepository postRepo;

    public CategoryController(CategoryRepository categoryRepo, UserRepository userRepo, PostRepository postRepo){
        this.categoryRepo = categoryRepo;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }
    //************************************

    //will set this content in post controller


    //********* CREATE CATEGORY ***********
    @GetMapping("/posts/{post_id}/create-category")
    public String createCategory(@PathVariable long post_id, Model model){
        model.addAttribute("categories", new Category());

        return "posts/create-category";
    }

    @PostMapping("/posts/{post_id}/create-category")
    public String createCategory(@PathVariable long post_id, @ModelAttribute Category category){
        Post post = postRepo.getOne(post_id);

        category.setPost(post);

        categoryRepo.save(category);

        return "posts/" + post_id;
    }
    //************************************


    //********* EDIT CATEGORY ************
    @GetMapping("posts/{post_id}/edit-category/{category_id}/")
    public String editCategory(@PathVariable long post_id, @PathVariable long category_id, Model model){
        model.addAttribute("categories", categoryRepo.getOne(category_id));

        return "posts/edit-category";
    }

    @PostMapping("posts/{post_id}/edit-category/{category_id}/")
    public String editCategory(@PathVariable long post_id, @PathVariable long category_id, @ModelAttribute Category category){
        categoryRepo.save(category);

        return "posts/" + post_id;
    }
    //************************************


    //********* DELETE CATEGORY ***********
    @PostMapping("posts/{post_id}/delete-category/{category_id}/")
    public String deleteCategory(@PathVariable long post_id, @PathVariable long category_id){
        categoryRepo.deleteById(category_id);

        return "posts/" + post_id;
    }
    //*************************************
}
