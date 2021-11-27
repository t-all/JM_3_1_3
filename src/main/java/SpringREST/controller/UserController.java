package SpringREST.controller;

import SpringREST.model.Role;
import SpringREST.model.User;
import SpringREST.service.RoleService;
import SpringREST.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/user")
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "user";
    }

    @GetMapping(value = "/admin")
    public String listUsers(@AuthenticationPrincipal User user, @AuthenticationPrincipal Role role, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("allRoles", roleService.getAllRoles());
        model.addAttribute("allUsers", userService.getAllUsers());
        return "admin";
    }

//    @PostMapping("/admin/create")
//    public String create(@ModelAttribute User user, @RequestParam(value = "newRoles") String[] editRoles) {
//        Set<Role> roleSet = new HashSet<>();
//        for (String role : editRoles) {
//            roleSet.add(roleService.getRoleByRole(role));
//        }
//        user.setRoles(roleSet);
//        userService.addUser(user);
//
//        return "redirect:/admin";
//    }

//    @PutMapping(value = "/edit/{id}")
//    public String update(@ModelAttribute User user, @RequestParam(value = "editRoles") String[] editRoles) {
//        Set<Role> roleSet = new HashSet<>();
//        for (String rolesAdd : editRoles) {
//            roleSet.add(roleService.getRoleByRole(rolesAdd));
//        }
//        user.setRoles(roleSet);
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }

//    @DeleteMapping("delete/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        userService.deleteUserById(id);
//        return "redirect:/admin";
//    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;

    }
}