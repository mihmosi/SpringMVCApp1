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
        users.add(new User(++USER_COUNT, "Ivan", "Sidirov", 25));
        users.add(new User(++USER_COUNT, "Petr", "Ivanov", 34));
        users.add(new User(++USER_COUNT, "Mikhail", "Semin", 55));
        users.add(new User(++USER_COUNT, "Vasiliy", "Krymov", 45));
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


}
