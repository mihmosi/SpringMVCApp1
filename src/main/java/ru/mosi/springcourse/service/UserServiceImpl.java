package ru.mosi.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mosi.springcourse.dao.UserDaoImpl;
import ru.mosi.springcourse.model.User;

import java.util.List;
@Component
public class UserServiceImpl implements UserService{

    @Autowired
    UserDaoImpl userDao;

    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }
}
