package ru.mosi.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first") // all methods
public class FirstContrller {

    @GetMapping("/calculator")
    // принимаем параметры в HTTP GET запросе строки браузера
    public String calcPage(@RequestParam(value = "a", required = false) int a,
                           @RequestParam(value = "b", required = false) int b,
                           @RequestParam(value = "action", required = false) String action,
                           Model model) {
        double result = 0;

        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double)b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
        }

        // через МОДЕЛЬ отправляем результат в отображение
        model.addAttribute("message", "Result of " + action + " digit " + a + " and digit "
                + b + " is " + result);
        return "first/calculator";
    }

    @GetMapping("/hello")    // сюда получаем запросы
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false)
                                    String surname, Model model) {
        // обращаемя к методу модели для добавления по ключу message в представление
        model.addAttribute("message", "Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

}
