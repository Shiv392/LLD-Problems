package TodoApp.Repository;

import TodoApp.Entities.User;
import TodoApp.Interfaces.UserInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepository implements UserInterface {

    private final Map<Long, User>users = new HashMap<>();    

    public UserRepository(){
        users.put(1L, new User(1L, "sonishiv309@gmail.com"));
        users.put(2L, new User(2L, "sonishiv3923@gmail.com"));
        users.put(3L, new User(3L, "shiv123@gmail.com"));
    }

    @Override 
    public void save(User newUser){
        if(users.containsKey(newUser.getId())){
            throw new IllegalArgumentException("User already exists");
        }

        users.put(newUser.getId(), newUser);
    }

    @Override 
    public Optional<User> findById(long _id){
        if(!users.containsKey(_id)) return Optional.empty();

        return Optional.of(users.get(_id));
    }

    @Override
    public Optional<User> findByEmail(String _email){
        return users.values().stream()
        .filter(user-> user.getEmail().equalsIgnoreCase(_email))
        .findFirst();
    }

    @Override 
    public List<User> getAllUsers(){
        return new ArrayList<>(users.values());
    }

    @Override 
    public boolean deleteUser(long id){
        if(!users.containsKey(id)){
            throw new IllegalArgumentException("User not exists");
        }

        users.remove(id);
        return true;
    }
}
