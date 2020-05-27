package codes.optiko.oc.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    //password - null not required because of hashing, and actually safer this way
    @Column
    private String password;

    @Column
    @CreationTimestamp
    private Timestamp createDate;

    @Column
    @UpdateTimestamp
    private Timestamp updateDate;

    @Column
    private Boolean isAdmin;

    //each user can have multiple posts
    //is below needed?
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

////************** CONSTRUCTORS ********************

    public User() {
    }

    public User(long id){
        this.id = id;
    }

    public User(long id, String firstName){
        this.id = id;
        this.firstName = firstName;
    }

    public User(long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(long id, String firstName, String lastName, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(long id, String firstName, String lastName, String email, String username){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
    }

    public User(long id, String firstName, String lastName, String email, String username, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(long id, String firstName, String lastName, String email, String username, String password, Timestamp createDate){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
    }

    public User(long id, String firstName, String lastName, String email, String username, String password, Timestamp createDate, Timestamp updateDate){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public User(long id, String firstName, String lastName, String email, String username, String password, Timestamp createDate, Timestamp updateDate, Boolean isAdmin){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isAdmin = isAdmin;
    }

    public User(long id, String firstName, String lastName, String email, String username, String password, Timestamp createDate, Timestamp updateDate, Boolean isAdmin, List<Post> posts){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isAdmin = isAdmin;
        this.posts = posts;
    }

 //*************** COPY CONSTRUCTOR ***************

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        firstName = copy.firstName;
        lastName = copy.lastName;
        email = copy.email;
        username = copy.email;
        password = copy.password;
        createDate = copy.createDate;
        updateDate = copy.updateDate;
        isAdmin = copy.isAdmin;
        posts = copy.posts;
    }

//************** GETTERS and SETTERS ********************

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
