package TodoApp.Entities;

import java.time.LocalDateTime;

public class Task {
    private final long id;
    private final long userId;
    private String name;
    private boolean status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(long _id, long _userId, String _name){
       if(_name == null || _name.isBlank()){
        throw  new IllegalArgumentException("Name can't be empty");
       }

        id = _id;
        userId = _userId;
        name = _name.trim();
        status = false;
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    //setter methods ------------------------>
    public void setName(String _name){
        String newName = _name.toLowerCase().trim();

        if(!newName.equals(name)){
            name = newName;
            setUpdatedAt();
        }
    }
    public void setStatus(boolean _status){
        if(status != _status){
            setUpdatedAt();
            status = _status;
        }
    }
    private void setUpdatedAt(){
        updatedAt = LocalDateTime.now();
    }

    //getter methods -------------------------->
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public boolean getStatus(){
        return status;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    public long getUserId(){
        return userId;
    }
}
