package codes.optiko.oc.repositories;

import codes.optiko.oc.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {
    @Query(value = "select * from responses where post_id = ?1", nativeQuery = true)
    List<Response> findByPostId(Long id);
}
