package TodoApp.Services;

import TodoApp.Repository.TaskRepository;
import java.util.List;
import java.util.Optional;

import TodoApp.Entities.Task;
import TodoApp.Entities.User;
import TodoApp.Services.UserService;

public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository _taskRepository, UserService _userService){
        taskRepository = _taskRepository;
        userService = _userService;
    }

    public List<Task> getAllTaskByUserId(long userId){
        return this.taskRepository.getAllTasksByUserId(userId);
    }

    public List<Task> getAllTasks(){
        return this.taskRepository.getAllTask();
    }

    public boolean addTask(long userId, String name){
        if(userId<=0 || name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input");
        }

        //first check if userid exists or not;
        Optional<User>user = this.userService.getUserById(userId);
        if(user.isEmpty()){
            throw new IllegalArgumentException("User not exists");
        }

        boolean taskExists = this.taskRepository.taskExists(userId, name.toLowerCase().trim());
        if(taskExists){
            throw new IllegalArgumentException("Task already exists");
        }

        long taskId = this.taskRepository.getAllTask().size()+1;
        Task newTask = new Task(taskId, userId, name.toLowerCase().trim());
        return this.taskRepository.addTask(newTask);
    }

    public boolean deleteTask(long taskId, long userId){
        if(taskId<=0 || userId<=0){
            throw new IllegalArgumentException("Invalid input");
        }

        Optional<User>user = this.userService.getUserById(userId);
        if(user.isEmpty()){
            throw new IllegalArgumentException("User not exists");
        }

        return this.taskRepository.deleteTask(taskId, userId);
    }

    public boolean updateTask(long taskId, long userId, String name){
        if(taskId<=0 || userId<=0 || name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid inputs");
        }

        Optional<User> user = this.userService.getUserById(userId);
        if(user.isEmpty()){
            throw new IllegalArgumentException("User not exists");
        }

        Task task = this.taskRepository.getAllTask().stream().filter(t-> t.getId() == taskId && t.getUserId() == userId)
        .findFirst().orElse(null);
        if(task == null){
            throw new IllegalArgumentException("Task not exists");
        }

        Task updatedTask = new Task(taskId, userId, name.toLowerCase().trim());
        return this.taskRepository.updateTask(taskId, updatedTask);
    }

    public boolean updateTaskStatus(long taskId, long userId, boolean status){
        if(taskId<=0 || userId<=0){
            throw new IllegalArgumentException("Invalid inputs");
        }

        Optional<User> user = this.userService.getUserById(userId);
        if(user.isEmpty()){
            throw new IllegalArgumentException("User not exists");
        }

        Task task = this.taskRepository.getAllTask().stream().filter(t-> t.getId() == taskId && t.getUserId() == userId)
        .findFirst().orElse(null);
        if(task == null){
            throw new IllegalArgumentException("Task not exists");
        }

        return this.taskRepository.updateTaskStatus(taskId, status);
    }
}
