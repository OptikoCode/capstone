package codes.optiko.oc.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String image;

//  foreign key to post: one image to one post
    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @CreationTimestamp
    @Column
    private Timestamp createDate;

    @UpdateTimestamp
    @Column
    private Timestamp updateDate;

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

    public Image(long id, String image, Post post, Timestamp createDate){
        this.id = id;
        this.image = image;
        this.post = post;
        this.createDate = createDate;
    }

    public Image(long id, String image, Post post,Timestamp createDate, Timestamp updateDate){
        this.id = id;
        this.image = image;
        this.post = post;
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}
