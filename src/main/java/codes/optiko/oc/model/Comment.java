package codes.optiko.oc.model;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name="comment", columnDefinition = "text")
    private String body;

//  foreign key: many bodys to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    foreign key: many bodys to one response
    @ManyToOne
    @JoinColumn(name = "response_id")
    private Response response;

//    time stamps are sql-oriented
    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Timestamp createDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Timestamp updateDate;


//************** CONSTRUCTORS ********************

//    empty constructor
    public Comment(){
    }

    public Comment(long id){
        this.id = id;
    }

    public Comment(long id, String body){
        this.id = id;
        this.body = body;
    }

    public Comment(long id, String body, User user){
        this.id = id;
        this.body = body;
        this.user = user;
    }

    public Comment(long id, String body, User user, Response response){
        this.id = id;
        this.body = body;
        this.user = user;
        this.response = response;
    }

    public Comment(long id, String body, User user, Response response, Timestamp createDate){
        this.id = id;
        this.body = body;
        this.user = user;
        this.response = response;
        this.createDate = createDate;
    }

    public Comment(long id, String body, User user, Response response, Timestamp createDate, Timestamp updateDate){
        this.id = id;
        this.body = body;
        this.user = user;
        this.response = response;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

//************** GETTERS and SETTERS ********************

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getDate() {
        return createDate;
    }

    public void setDate(Timestamp date) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}
