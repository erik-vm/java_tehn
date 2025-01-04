package dao;

import model.User;

public class UserDao {

    public User getUserByUserName(String userName) {
        return switch (userName) {
            case "user" -> new User("user", "user");
            case "admin" -> new User("admin", "admin");
            default -> null;
        };
    }
}
