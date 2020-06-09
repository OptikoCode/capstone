package codes.optiko.oc.model;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "responses")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //video url
    @Column(columnDefinition = "text")
    private String video;

//  foreign key to user: many responses(videos) to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//  foreign key to post: many responses to one post
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="response")
    private List<Comment> comments = new ArrayList<>();

    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Timestamp createDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Timestamp updateDate;

//************** CONSTRUCTORS ********************

    public Response() {
    }

    public Response(long id) { this.id = id; }

    public Response(long id, String video) {
        this.id = id;
        this.video = video;
    }

    public Response(long id, String video, User user) {
        this.id = id;
        this.video = video;
        this.user = user;
    }

    public Response(long id, String video, User user, Post post) {
        this.id = id;
        this.video = video;
        this.user = user;
        this.post = post;
    }

    public Response(long id, String video, User user, Post post, List<Comment> comments) {
        this.id = id;
        this.video = video;
        this.user = user;
        this.post = post;
        this.comments = comments;
    }

    public Response(long id, String video, User user, Post post, List<Comment> comments, Timestamp createDate) {
        this.id = id;
        this.video = video;
        this.user = user;
        this.post = post;
        this.comments = comments;
        this.createDate = createDate;
    }

    public Response(long id, String video, User user, Post post, List<Comment> comments, Timestamp createDate, Timestamp updateDate) {
        this.id = id;
        this.video = video;
        this.user = user;
        this.post = post;
        this.comments = comments;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Response(String video, User user, Post post, List<Comment> comments, Timestamp createDate) {
        this.video = video;
        this.user = user;
        this.post = post;
        this.comments = comments;
        this.createDate = createDate;
    }

    public Response(String video, User user, Post post, List<Comment> comments, Timestamp createDate, Timestamp updateDate) {
        this.video = video;
        this.user = user;
        this.post = post;
        this.comments = comments;
        this.createDate = createDate;
        this.updateDate = updateDate;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp date) {
        this.createDate = createDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String formattedDate(){
        String dateString = this.createDate.toString();
        return dateString.substring(5,7) + "-" + dateString.substring(8,10) + "-" + dateString.substring(0,4);
    }

    public String formattedUpdate(){
        String dateString = this.updateDate.toString();
        return dateString.substring(5,7) + "-" + dateString.substring(8,10) + "-" + dateString.substring(0,4);
    }

    public String prettyDate(){
        PrettyTime p = new PrettyTime();
        return p.format(this.createDate);
    }

    public String prettyUpdate(){
        PrettyTime p = new PrettyTime();
        return p.format(this.updateDate);
    }
}
