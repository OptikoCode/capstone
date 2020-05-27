package codes.optiko.oc.model;

import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    @Column
    private Timestamp date;

    @Column
    private Boolean isAdmin;

    //each user can have multiple posts
    //is below needed?
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    private List<Post> posts;

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

    public User(long id, String firstName, String lastName, String email, String username, String password, Timestamp date){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.date = date;
    }

    public User(long id, String firstName, String lastName, String email, String username, String password, Timestamp date, Boolean isAdmin){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.date = date;
        this.isAdmin = isAdmin;
    }

 //*************** COPY CONSTRUCTOR ***************

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        firstName = copy.firstName;
        lastName = copy.lastName;
        email = copy.email;
        username = copy.email;
        password = copy.password;
        date = copy.date;
        isAdmin = copy.isAdmin;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
