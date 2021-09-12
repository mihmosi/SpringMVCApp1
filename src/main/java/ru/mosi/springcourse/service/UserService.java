package ru.mosi.springcourse.service;

import ru.mosi.springcourse.model.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(int id, User updateUser);
    void delete(int id);
}
