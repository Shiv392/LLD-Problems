package TodoApp.Interfaces;

import java.util.List;
import TodoApp.Entities.Task;

public interface TaskInterface {
    List<Task> getAllTasksByUserId(long id);

    List<Task> getAllTask();

    boolean addTask(Task newTask);

    boolean deleteTask(long id, long userId);

    boolean updateTask(long id, Task updatedTask);

    boolean updateTaskStatus(long id, boolean status);

    boolean taskExists(long userId, String name);
}
