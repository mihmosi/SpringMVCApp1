package ru.mosi.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//помечаем класс как контроллер
@Controller
public class HelloController {

    // Указываем какой урл приходит в этот метод контроллера
    /*когда это набирается ы поисковой
         строке тогда этот запрос будет приходить в этот метод контроллера
         мы можем перенаправлять, обращаться в этом методе к модели, доставать данные из базы
         , показывать пользователю и т. д. */
    @GetMapping("/hello-world")
    public String sayHello() {
return "hello_world";  // вернет представление
    }
}
