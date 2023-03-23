package space.bumtiger.product;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}
