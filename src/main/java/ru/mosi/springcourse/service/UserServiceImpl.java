package ru.mosi.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mosi.springcourse.dao.UserDaoImpl;
import ru.mosi.springcourse.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(int id, User updateUser) {
        userDao.update(id, updateUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
