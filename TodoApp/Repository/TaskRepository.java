package TodoApp.Repository;

import TodoApp.Interfaces.TaskInterface;
import java.util.List;
import java.util.ArrayList;
import TodoApp.Entities.Task;

public class TaskRepository implements TaskInterface {

    List<Task>tasks = new ArrayList<>();
    
    @Override 
    public List<Task> getAllTasksByUserId(long userId){
        return tasks.stream().filter(task-> task.getUserId() == userId).toList();
    }

    @Override 
    public List<Task> getAllTask(){
        return tasks;
    }

    @Override 
    public boolean addTask(Task newTask){
        tasks.add(newTask);
        return true;
    }

    @Override 
    public boolean deleteTask(long id, long userId){
        Task task = tasks.stream().filter(t-> t.getId() == id && t.getUserId() == userId).findFirst().orElse(null);
        if(task == null){
            throw new IllegalArgumentException("Task not exists");
        }
        
        tasks.remove(task);
        return true;
    }

    @Override 
    public boolean updateTask(long id, Task updatedTask){
        Task task = tasks.stream().filter(t-> t.getId() == id).findFirst().orElse(null);
        if(task == null){
            throw new IllegalArgumentException("Task not exists");
        }

        task.setName(updatedTask.getName());
        return true;
    }

    @Override 
    public boolean updateTaskStatus(long id, boolean status){
        Task task = tasks.stream().filter(t-> t.getId() == id).findFirst().orElse(null);
        if(task == null){
            throw new IllegalArgumentException("Task not exists");
        }

        task.setStatus(status);
        return true;
    }

    @Override 
    public boolean taskExists(long userId, String name){
        Task task = tasks.stream()
        .filter(t-> t.getUserId() == userId && t.getName().toLowerCase().trim().equals(name))
        .findFirst()
        .orElse(null);

        return task!=null;
    }
}
