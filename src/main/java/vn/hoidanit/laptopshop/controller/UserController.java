package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUser = this.userService.getAllUser();
        List<User> arrUser1 = this.userService.getUserByEmail("anh2003cd@gmail.com");
        List<User> arrUser2 = this.userService.getUserByEmailAndAddress("anh2003cd@gmail.com", "11111");

        String test = this.userService.handleHello();
        model.addAttribute("eric", "test");
        model.addAttribute("teo", "teo top ten kkk kiesm 1k$");
        return "hello";

    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUser();

        model.addAttribute("users", users);
        return "admin/user/tableUser"; // cái này là link vào thư mục view

    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {

        User userDetail = this.userService.getUserById(id);
        // model.addAttribute("id", id);
        model.addAttribute("user", userDetail);
        return "admin/user/showDetailUser";
    }

    @RequestMapping("/admin/user/create") // GET
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    // value sẽ mapping sang cái form => cái url phải giống nhau
    public String createUserpage(Model model, @ModelAttribute("newUser") User teotopten) {

        this.userService.handelSaveUser(teotopten);
        return "hello";
    }

    @RequestMapping(value = "/admin/user/update/{id}") // get
    // value sẽ mapping sang cái form => cái url phải giống nhau
    public String updateUser(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "/admin/user/update";
    }

    @PostMapping("/admin/user/update") // posst
    public String submitupdateUser(Model model, @ModelAttribute("newUser") User user) {
        User currentUser = this.userService.getUserById(user.getId());
        if (currentUser != null) {
            currentUser.setAddress(user.getAddress());
            currentUser.setFullName(user.getFullName());
            currentUser.setPhone(user.getPhone());
            this.userService.handelSaveUser(user);

        }

        return "redirect:/admin/user";
    }

}
