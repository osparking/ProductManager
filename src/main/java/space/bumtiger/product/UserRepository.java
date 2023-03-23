package space.bumtiger.product;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
	@Query("SELECT * FROM users u WHERE u.username = :username")
	public User findByUsername(@Param("username") String username);
}
