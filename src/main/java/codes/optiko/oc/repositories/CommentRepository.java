package codes.optiko.oc.repositories;

import codes.optiko.oc.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
