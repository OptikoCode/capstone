package codes.optiko.oc.repositories;

import codes.optiko.oc.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchRepo extends CrudRepository<Post, String> {

    @Query("SELECT t.title FROM Post t WHERE t.title LIKE %?1%")
    List<Post> findByTitle(@Param("title") String title);

}