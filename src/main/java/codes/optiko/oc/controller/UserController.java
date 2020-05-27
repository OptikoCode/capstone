package codes.optiko.oc.controller;

import codes.optiko.oc.model.User;
import codes.optiko.oc.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository users;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository users, PasswordEncoder passwordEncoder){
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

//****************** Edit Post functionality *************
    @GetMapping("/user/edit/{id}")
    public String showEditUserForm(@PathVariable String id, Model model){
        long parseId = Long.parseLong(id);
        User user = users.findById(parseId);
        model.addAttribute("user", user);
        return "users/edit";
    }
//************** This should update the uer in the database but needs some work...********************
    @PostMapping("/user/edit")
    public String editUser(@ModelAttribute User user){
        users.save(user);
        return "redirect:/users" + user.getId();
    }

    @GetMapping("/posts/editcreate")
    public String editCreatePost(Model model) {
        User user = users.getOne(1L);
        model.addAttribute("user", user);
        return "/users/edit";
    }
//************** This is the Delete Functionality [I Have not tested it yet] *******************
    @PostMapping("/user/delete")
    public String deletePost(@PathVariable long userId) {
        users.deleteById(userId);
        return "user/delete_successful";
    }
}
