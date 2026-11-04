package TodoApp.Entities;

public class User {
    private long id;
    private String email;

    public User(long _id, String _email){
        if(_email == null || _email.isBlank()){
            throw new IllegalArgumentException("Email can't be empty");
        }

        id = _id;
        email = _email.trim();
    }

    public long getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
}
