package ru.mosi.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.mosi.springcourse.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    private static int USER_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT, "Ivan", "Sidirov", "email1@email.ru"));
        users.add(new User(++USER_COUNT, "Petr", "Ivanov", "email2@email.ru"));
        users.add(new User(++USER_COUNT, "Mikhail", "Semin", "email3@email.ru"));
        users.add(new User(++USER_COUNT, "Vasiliy", "Krymov", "email4@email.ru"));
    }

    @Override
    public List<User> index() {
        return users;
    }

    @Override
    public User show(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }

    @Override
    public void update(int id, User updateUser) {
        User userToBeUpdate = show(id);

        userToBeUpdate.setName(updateUser.getName());
        userToBeUpdate.setLastname(updateUser.getLastname());
        userToBeUpdate.setEmail(updateUser.getEmail());
    }

    @Override
    public void delete(int id) {
        users.removeIf(p-> p.getId()==id);
    }


}
