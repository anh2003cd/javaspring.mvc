package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        System.out.println(arrUser);
        System.out.println(arrUser1);
        System.out.println(arrUser2);
        String test = this.userService.handleHello();
        model.addAttribute("eric", "test");
        model.addAttribute("teo", "teo top ten kkk kiesm 1k$");
        return "hello";

    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {

        model.addAttribute("newUser", new User());

        return "admin/user/create"; // cái này là link vào thư mục view

    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    // value sẽ mapping sang cái form => cái url phải giống nhau
    public String createUserpage(Model model, @ModelAttribute("newUser") User teotopten) {
        System.out.println("run here: " + teotopten);
        this.userService.handelSaveUser(teotopten);
        return "hello";
    }

}
