package TodoApp;

import TodoApp.Entities.User;
import TodoApp.Repository.UserRepository;
import TodoApp.Services.UserService;
import java.util.List;

public class Main {

    public void main() {
        try {
            //testing for User service
            UserRepository userRepository = new UserRepository();
            UserService userService = new UserService(userRepository);

            userService.addUser("shiv3923@gmail.com");
            userService.addUser("shiv1@gmail.com");

            //list of users
            List<User>users = userService.getAllUser();
            users.forEach(user-> IO.println("User id: "+user.getId()+" email: "+user.getEmail()));
            
        } catch (Exception e) {
            IO.println("Error: " + e.getMessage());
        }
    }
}
