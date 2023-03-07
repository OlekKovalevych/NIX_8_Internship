package ua.com.alevel;
//1.40

import ua.com.alevel.entiti.User;
import ua.com.alevel.view.UserController;

import java.util.HashSet;
import java.util.Set;

public class StartOopMain {
    public static void main(String[] args) {
       /* System.out.println("StarOopMain.main");

        Set<User> users = new HashSet<>();
        User user = new User();
        user.setId("");
        user.setAge(0);
        user.setName("");
        users.add(user);
        user = new User();
        user.setId("");
        user.setAge(0);
        user.setName("");
        users.add(user);

        System.out.println("user = " + users.size());*/

        new UserController().run();
    }
}
