package dao;

import model.User;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<Integer, User> users = new HashMap<>();
    public void saveUser(User user) {
        users.put(user.getId() , user);
    }

    public void deleteUser(User user) {
        users.remove(user.getId());
    }

    public User getUser(Integer id) {
        return users.get(id);
    }
}
