package codes.optiko.oc.model;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

//  foreign key: many categories can be affiliated to one post
    @ManyToOne
    @JoinColumn(name = "post_id") //is this needed since there's a join table between posts & categories?
    private Post post;

//************** CONSTRUCTORS ********************

    public Category(){
    }

    public Category(long id){
        this.id = id;
    }

    public Category(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Category(long id, String name, Post post){
        this.id = id;
        this.name = name;
        this.post = post;
    }

//************** GETTERS and SETTERS ********************

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
