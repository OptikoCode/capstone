package codes.optiko.oc.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // string of URL of video
    @Column(nullable = false)
    private String video;

    @CreationTimestamp
    @Column
    private Timestamp createDate;

    @UpdateTimestamp
    @Column
    private Timestamp updateDate;

//************** JOIN TABLE ********************

    //many to many?
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
        name = "videos_responses",
        joinColumns = {@JoinColumn(name = "video_id")},
        inverseJoinColumns = {@JoinColumn(name = "response_id")}
)
private List<Response> responses;

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

    public Video(long id, String video, Timestamp createDate){
        this.id = id;
        this.video = video;
        this.createDate = createDate;
    }

    public Video(long id, String video, Timestamp createDate, Timestamp updateDate){
        this.id = id;
        this.video = video;
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

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}
