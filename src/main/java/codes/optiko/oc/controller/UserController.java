package codes.optiko.oc.controller;

import codes.optiko.oc.model.Category;
import codes.optiko.oc.model.Post;
import codes.optiko.oc.model.User;
import codes.optiko.oc.repositories.PostRepository;
import codes.optiko.oc.repositories.SearchRepo;
import codes.optiko.oc.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private UserRepository users;
    private PasswordEncoder passwordEncoder;
    private PostRepository posts;
    private SearchRepo searchRepo;

    public UserController(UserRepository users, PasswordEncoder passwordEncoder, PostRepository posts){
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.posts = posts;
    }

//**************** Registration Functionality ***********************
    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

//*** After a user signs up they will be redirected to the login page ***
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "users/login";
    }

//********* Sends user to the Login page ********************
    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }

//************* Will redirect user from the login page to their profile ****************
    @PostMapping("/login")
    public String showProfile(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "redirect:/profile";
    }

//***************** Will display the users profile page *********************
    @GetMapping("/profile")
    public String showProfileIndexPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("posts", posts.findByUserIdOrderByIdDesc(user.getId()));
//        model.addAttribute("post", posts.findByUserIdOrderByIdDesc(user.getId()));
        model.addAttribute("user", user);
        return "users/profile";
    }

//************** This handles the logout functionality for the user ****************
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

//****************** Edit Profile functionality *************
    @GetMapping("/user/edit/{id}")
    public String showEditUserForm(@PathVariable long id, Model model){
        User user = users.findById(id);
        model.addAttribute("user", user);
        return "users/edit";
    }
//************** This will update the user info in the database ********************
    @PostMapping("/user/edit/{id}")
    public String editUser(@PathVariable long id, @ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        users.save(user);
        return "redirect:/profile";
    }

//************** This is the Delete Functionality *******************
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable long id, HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        kills current session:
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        users.deleteById(id);
        return "redirect:/posts";

    }

//*********** This will allow the user to search the posts on the website???? **************

    @GetMapping("/search")
    public String searchForPosts(@RequestParam(name = "searchTerm") String searchTerm, Model model){
        model.addAttribute("posts", posts.findAllPostSearchByTitleDescriptionCategoriesCommentsContaining(searchTerm, searchTerm, searchTerm, searchTerm));
        return "users/search";
    }

//******** USING TO TEST FILESTACK API **************

  //Call the Post class to get access to he getImage() method
    @GetMapping("/image")
    public String uploadFunctionality(Model model){
        model.addAttribute("posts", new Post());
        return"posts/image";
    }

    @PostMapping("/image")
    public String uploadFinished(@ModelAttribute Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        posts.save(post);
        return "redirect:/profile";
    }

//*********** Brings user to the about page *************
    @GetMapping("/about")
    public String aboutUs(){
        return "about";
    }


    //***** mapping for how-to page *****//
    @GetMapping("/how")
    public String howTo(){
        return "how";
    }
}









//    @GetMapping("/image")
//    public String uploadFunctionality(){
//        return"posts/image";
//    }

//    @RequestMapping(value = "/image", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity<?> uploadFile(
//            @RequestParam("uploadfile") MultipartFile uploadfile) {
//
//        try {
//            // Get the filename and build the local file path (be sure that the
//            // application have write permissions on such directory)
//            String filename = uploadfile.getOriginalFilename();
//            String directory = "/var/netgloo_blog/uploads";
//            String filepath = Paths.get(directory, filename).toString();
//
//            // Save the file locally
//            BufferedOutputStream stream =
//                    new BufferedOutputStream(new FileOutputStream(new File(filepath)));
//            stream.write(uploadfile.getBytes());
//            stream.close();
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @GetMapping("/user/delete/{id}")
//    public String logout(@PathVariable long id) {
//        users.logout()
//    }


