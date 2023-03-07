package ua.com.alevel.db;

import ua.com.alevel.entiti.User;

import java.util.*;

public class SameUserDB {

    private final Set<User> users;
    private static SameUserDB instance;

    private SameUserDB() {
        users = new HashSet<>();

    }

    public static SameUserDB getInstance() {
        if (instance == null) {
            instance = new SameUserDB();
        }
        return instance;
    }

    public void create(User user) {
        user.setId(generateId());
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

    public Set<User> finalAll() {
        return users;
    }

    private String generateId() {
        final String id = UUID.randomUUID().toString();
        if (users.stream().anyMatch(user -> user.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}
