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


    @Column(nullable = false, columnDefinition = "text")
    private String comment;


//  foreign key: many comments to one user
    @ManyToOne
    private User user;

//    foreign key: many comments to one response
    @ManyToOne
    private Response response;

//    time stamps are sql-oriented
    @Column
    @CreationTimestamp
    private Timestamp createDate;

    @Column
    @UpdateTimestamp
    private Timestamp updateDate;


//************** CONSTRUCTORS ********************

//    empty constructor
    public Comment(){
    }

    public Comment(long id){
        this.id = id;
    }

    public Comment(long id, String comment){
        this.id = id;
        this.comment = comment;
    }

    public Comment(long id, String comment, User user){
        this.id = id;
        this.comment = comment;
        this.user = user;
    }

    public Comment(long id, String comment, User user, Timestamp createDate){
        this.id = id;
        this.comment = comment;
        this.user = user;
        this.createDate = createDate;
    }

    public Comment(long id, String comment, User user, Timestamp createDate, Timestamp updateDate){
        this.id = id;
        this.comment = comment;
        this.user = user;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Comment(long id, String comment, User user, Response response, Timestamp createDate, Timestamp updateDate){
        this.id = id;
        this.comment = comment;
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
        return comment;
    }

    public void setBody(String body) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
