package codes.optiko.oc.model;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

//  foreign key to user: many posts for one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    foreign key to image: many images to one post
    @JoinColumn(name = "image_file")
    private String image;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="post")
    private List<Response> responses = new ArrayList<>();

    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Timestamp createDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Timestamp updateDate;

//************** JOIN TABLE ********************

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "posts_categories",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<Category> categories;

//************** CONSTRUCTORS ********************

    public Post(){
    }

    public Post(long id){
        this.id = id;
    }

    public Post(long id, String title){
        this.id = id;
        this.title = title;
    }

    public Post(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Post(long id, String title, String description, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public Post(long id, String title, String description, User user, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.image = image;
    }

    public Post(long id, String title, String description, User user, String image, Timestamp createDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.image = image;
        this.createDate = createDate;
    }

    public Post(long id, String title, String description, User user, String image, Timestamp createDate, Timestamp updateDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.image = image;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp date) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String formattedDate(){
        String dateString = this.createDate.toString();
        return dateString.substring(5,7) + "-" + dateString.substring(8,10) + "-" + dateString.substring(0,4);
    }

    public String formattedUpdate(){
        String dateString = this.updateDate.toString();
        return dateString.substring(5,7) + "-" + dateString.substring(8,10) + "-" + dateString.substring(0,4);
    }
}

