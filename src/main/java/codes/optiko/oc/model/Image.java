package codes.optiko.oc.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    String image;

//  foreign key to post: one image to one post
    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @CreationTimestamp
    @Column
    private Timestamp date;

//************** CONSTRUCTORS ********************

    public Image(){
    }

    public Image(long id){
        this.id = id;
    }

    public Image(long id, String image){
        this.id = id;
        this.image = image;
    }

    public Image(long id, String image, Post post){
        this.id = id;
        this.image = image;
        this.post = post;
    }

    public Image(long id, String image, Post post, Timestamp date){
        this.id = id;
        this.image = image;
        this.post = post;
        this.date = date;
    }

//************** GETTERS and SETTERS ********************

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
