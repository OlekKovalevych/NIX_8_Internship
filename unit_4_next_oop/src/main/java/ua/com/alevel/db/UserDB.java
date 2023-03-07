package ua.com.alevel.db;

import ua.com.alevel.entiti.User;

public interface UserDB extends BaseDB<User> {

    boolean existByEmail(String email);
}
