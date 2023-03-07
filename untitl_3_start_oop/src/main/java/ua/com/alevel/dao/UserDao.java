package ua.com.alevel.dao;



import ua.com.alevel.db.impl.UserInMemoryDB;
import ua.com.alevel.entiti.User;

import java.util.List;

public class UserDao {


    public void create(User user) {
        UserInMemoryDB.getInstance().create(user);
    }

    public void update(User user) {
        UserInMemoryDB.getInstance().update(user);
    }

    public void delete(String id) {
        UserInMemoryDB.getInstance().delete(id);
    }

    public User findById(String id) {
        return UserInMemoryDB.getInstance().findById(id);
    }

    public List<User> finalAll() {
        return UserInMemoryDB.getInstance().finalAll();
    }

}
