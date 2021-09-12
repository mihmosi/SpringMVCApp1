package ru.mosi.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mosi.springcourse.dao.UserDao;
import ru.mosi.springcourse.dao.UserDaoImpl;
import ru.mosi.springcourse.model.User;
import ru.mosi.springcourse.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserServiceImpl userService;

    @Autowired
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

    @GetMapping("/new")   // GET запрос для получения новой формы
    public String newUser(@ModelAttribute("user") User user) {    //
//        model.addAttribute("user", new User());

        return "users/new";  // адрес представления
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit") // при наборе этого URL попадем в метод который вернет страницу
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id)); // получаем в поля user по id
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
userService.delete(id);
return "redirect:/users";
    }

}
