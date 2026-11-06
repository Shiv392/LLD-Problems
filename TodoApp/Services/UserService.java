package TodoApp.Services;

import TodoApp.Entities.User;
import TodoApp.Repository.UserRepository;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository _userRepository){
        userRepository = _userRepository;
    }

    public void addUser(String email){
       Optional<User>user =  this.userRepository.findByEmail(email);
       if(user.isPresent()){
        throw new IllegalArgumentException("email already exists");
       }

       long newId = this.userRepository.getAllUsers().size()+1;
       User newUser = new User(newId, email);

       this.userRepository.save(newUser);
       IO.println("User added successfully");
    }

    public void deleteUser(long id){
        Optional<User>user = this.userRepository.findById(id);
        if(user.isEmpty()){
            throw new IllegalArgumentException("User not exists");
        }

        this.userRepository.deleteUser(id);
        IO.println("User deleted successfully");
    }

    public List<User> getAllUser(){
        return this.userRepository.getAllUsers();
    }

    public Optional<User> getUserById(long id){
        return this.userRepository.findById(id);
    }
}
