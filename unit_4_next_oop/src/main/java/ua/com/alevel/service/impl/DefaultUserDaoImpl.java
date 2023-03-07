package ua.com.alevel.service.impl;

import ua.com.alevel.dao.UserDao;
import ua.com.alevel.db.UserDB;
import ua.com.alevel.db.impl.UserInMemoryDB;
import ua.com.alevel.entiti.User;
import ua.com.alevel.service.UserService;

import java.util.Collection;

public class DefaultUserDaoImpl implements UserDao {

    private final UserDB db = UserInMemoryDB.getInstance();
    @Override
    public void create(User entity) {
        db.create(entity);
    }

    @Override
    public void update(User entity) {
        db.update(entity);
    }

    @Override
    public void delete(String id) {
        db.delete(id);
    }

    @Override
    public User findById(String id) {
        return db.findById(id);
    }

    @Override
    public Collection<User> finalAll() {
        return db.finalAll();
    }

    @Override
    public boolean existByEmail(String email) {
        return db.existByEmail(email);
    }
}

