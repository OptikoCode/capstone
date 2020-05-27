package codes.optiko.oc.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String video;

    @CreationTimestamp
    @Column
    private Timestamp date;

//************** JOIN TABLE ********************

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
        name = "videos_responses",
        joinColumns = {@JoinColumn(name = "video_id")},
        inverseJoinColumns = {@JoinColumn(name = "response_id")}
)
private List<Response> responses;
//is list appropriate type?

//************** CONSTRUCTORS ********************

    public Video(){
    }

    public Video(long id){
        this.id = id;
    }

    public Video(long id, String video){
        this.id = id;
        this.video = video;
    }

    public Video(long id, String video, Timestamp date){
        this.id = id;
        this.video = video;
        this.date = date;
    }

//************** GETTERS and SETTERS ********************

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}
