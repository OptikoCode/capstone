package codes.optiko.oc.repositories;

import codes.optiko.oc.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post getPostById(Long id);

    List<Post> findByDescriptionContainingOrTitleContaining(String searchTerm, String searchTerm1);

    //@Query(value = "select * from posts where user_id = ?1", nativeQuery = true)
    List<Post> findByUserIdOrderByIdDesc(long id);

    @Query(value = "select p.*, ifnull(count(r.post_id), 0) from posts as p left join responses as r on p.id = r.post_id group by p.id order by p.id desc", nativeQuery = true)
    List<Post> findAllAndCountResponsesOrderByPostIdDesc();
}
