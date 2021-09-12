package ru.mosi.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mosi.springcourse.dao.UserDao;
import ru.mosi.springcourse.dao.UserDaoImpl;
import ru.mosi.springcourse.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserServiceImpl userService;

    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        // получим всех юзеров из DАО и передадим на отображение в представление
        model.addAttribute("users", userService.index());
        return "users/index";
    }

    @GetMapping("/{id}")  // id передается в PathVariable
    public String show(@PathVariable("id") int id, Model model) {
        // получим одного человека из DAO и передадим на представление
        model.addAttribute("user", userService.show(id));
        return "users/show";
    }
}
