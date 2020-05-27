package codes.optiko.oc.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "responses")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//  foreign key to user: many responses(videos) to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//  foreign key to post: many responses to one post
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

//  foreign key to video: one response to one video
    @OneToOne
    @JoinColumn(name = "video_id")
    private Video video;

//  foreign key to comment: one response can have many comments
    @OneToMany //need to fix?
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @CreationTimestamp
    @Column
    private Timestamp date;

//************** CONSTRUCTORS ********************

//    empty constructor
    public Response(){
    }

    public Response(long id){
        this.id = id;
    }

    public Response(long id, User user){
        this.id = id;
        this.user = user;
    }

    public Response(long id, User user, Post post){
        this.id = id;
        this.user = user;
        this.post = post;
    }

    public Response(long id, User user, Post post, Video video){
        this.id = id;
        this.user = user;
        this.post = post;
        this.video = video;
    }

    public Response(long id, User user, Post post, Video video, Comment comment){
        this.id = id;
        this.user = user;
        this.post = post;
        this.video = video;
        this.comment = comment;
    }

    public Response(long id, User user, Post post, Video video, Comment comment, Timestamp date){
        this.id = id;
        this.user = user;
        this.post = post;
        this.video = video;
        this.comment = comment;
        this.date = date;
    }

//************** GETTERS and SETTERS ********************

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
