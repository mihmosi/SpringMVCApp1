package ru.mosi.springcourse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

       /* класс заменяющий web.xml */
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    // Метод, указывающий на класс конфигурации
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};  // локация кнфигурации
    }

    /* Данный метод указывает url, на котором будет базироваться п риложение */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};  // все запросы посылаем на сервлет
    }
}
