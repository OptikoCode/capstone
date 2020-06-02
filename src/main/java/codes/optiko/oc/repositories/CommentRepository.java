package codes.optiko.oc.repositories;

import codes.optiko.oc.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "select * from comments where response_id = any(select id from responses where post_id = ?1)", nativeQuery = true)
    //@Query(value = "select * from comments where response_id = ?1", nativeQuery = true)
    List<Comment> findByResponseId(Long id);
}
