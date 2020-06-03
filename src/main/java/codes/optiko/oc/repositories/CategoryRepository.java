package codes.optiko.oc.repositories;

import codes.optiko.oc.model.Category;
import codes.optiko.oc.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select * from posts where post_id = ?1", nativeQuery = true)
    List<Category> findByPostId(Long id);
}
