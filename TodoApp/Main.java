package TodoApp;

import TodoApp.Entities.Task;
import TodoApp.Entities.User;
import TodoApp.Repository.TaskRepository;
import TodoApp.Repository.UserRepository;
import TodoApp.Services.TaskService;
import TodoApp.Services.UserService;
import java.util.List;

public class Main {

    private static UserRepository userRepository = new UserRepository();
    private static UserService userService = new UserService(userRepository);
    private static TaskService taskService = new TaskService(new TaskRepository(), userService);

    public void main() {
        try {
            //testing for User service

            userService.addUser("shiv3923@gmail.com");
            userService.addUser("shiv1@gmail.com");

            //list of users
            List<User> users = userService.getAllUser();
            users.forEach(user -> IO.println("User id: " + user.getId() + " email: " + user.getEmail()));

            //Task Queries -------------------->
            IO.println("Task Queries =======================================>");

            //1. list of all tasks
            //add task by user id 1 
            taskService.addTask(1, "Go to Gym");
            IO.println("Task added successfully");

            taskService.addTask(2, "Go to school");
            IO.println("Task added successfully");

            taskService.addTask(1, "Going to Movie");
            taskService.addTask(1, "Going for shopping");
            taskService.addTask(1, "Learn SOLID Principles");
            taskService.addTask(1, "Complete LinkedLyst Project");

            PrintTaskDetails();

            //update task name with user id 1 and task id 1
            taskService.updateTask(1, 1, "Need to take wash");
            IO.println("Task updated successfully");

            PrintTaskDetails();

            //add task that is already exists for user id 1
            taskService.addTask(1, "Need to take wash");
            
        } catch (Exception e) {
            IO.println("Error: " + e.getMessage());
        }
    }

    public static void PrintTaskDetails() {
        IO.println("Task details =======================================>");
        List<Task> tasks = taskService.getAllTasks();
        tasks.forEach(t -> IO.println("Task id: " + t.getId() + " userId: " + t.getUserId() + " name: " + t.getName() + " status: " + t.getStatus() + " createdAt: " + t.getCreatedAt() + " updatedAt: " + t.getUpdatedAt()));
    }

}
