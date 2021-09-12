package ru.mosi.springcourse.dao;

import ru.mosi.springcourse.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();
     User show(int id);
    void save(User user);
    void update(int id, User updateUser);
    void delete(int id);
}
