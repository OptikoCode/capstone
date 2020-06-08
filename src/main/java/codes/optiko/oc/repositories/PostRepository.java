package codes.optiko.oc.repositories;

import codes.optiko.oc.model.Category;
import codes.optiko.oc.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post getPostById(Long id);

//    List<Post> findByDescriptionContainingOrTitleContaining(String searchTerm, String searchTerm1);
    @Query(value = "select distinct p.* from posts as p join categories as cat on p.id = cat.post_id join comments as c where p.title like %?1% or p.description like %?2% or cat.name like %?3% order by p.id desc", nativeQuery = true)
    List<Post> findAllPostSearchByTitleDescriptionCategoriesCommentsContaining(String searchTerm1, String searchTerm2, String searchTerm3);

    //@Query(value = "select * from posts where user_id = ?1", nativeQuery = true)
    List<Post> findByUserIdOrderByIdDesc(long id);

    @Query(value = "select * from posts order by id desc", nativeQuery = true)
    List<Post> findAllOrOrderByIdDesc();
}
