package codes.optiko.oc.model;
import javax.persistence.*;

@Entity
public class Response {
    @Id
    private long id;

    private String body;

//    private User user;

//    empty constructor
    public Response(){
    }

//    getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
