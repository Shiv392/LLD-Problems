package TodoApp.Interfaces;

import TodoApp.Entities.User;
import java.util.List;
import java.util.Optional;

public interface UserInterface {
    void save(User user);
    Optional<User> findById(long id);
    Optional<User> findByEmail(String email);
    List<User> getAllUsers();

    default boolean deleteUser(long id){
        return false;
    }
}
