package ua.com.alevel.db.impl;


import ua.com.alevel.db.BaseDB;
import ua.com.alevel.db.UserDB;
import ua.com.alevel.entiti.User;
import ua.com.alevel.util.DBHelperUtil;

import java.util.ArrayList;
import java.util.List;

public class UserInMemoryDB implements UserDB{

    private final List<User> users;
    private static UserInMemoryDB instance;

    private UserInMemoryDB() {
        users = new ArrayList<>();

    }

    public static UserInMemoryDB getInstance() {
        if (instance == null) {
            instance = new UserInMemoryDB();
        }
        return instance;
    }

    public void create(User user) {
        user.setId(DBHelperUtil.generateId(users));
        users.add(user);
    }

    public void update(User user) {
        User current = users.stream()
                .filter(u -> u.getId().equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("user not found idiot"));
        current.setAge(user.getAge());
        current.setName(user.getName());
    }

    public void delete(String id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public User findById(String id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("user not found idiot"));
    }

    public List<User> finalAll() {
        return users;
    }


    @Override
    public boolean existByEmail(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }
}
