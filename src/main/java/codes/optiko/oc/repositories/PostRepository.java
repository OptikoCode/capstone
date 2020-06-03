package codes.optiko.oc.repositories;

import codes.optiko.oc.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post getPostById(Long id);

    List<Post> findByDescriptionContainingOrTitleContaining(String searchTerm, String searchTerm1);

}
