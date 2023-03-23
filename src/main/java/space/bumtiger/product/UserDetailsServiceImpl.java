package space.bumtiger.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User user = userRepository.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("잘못된 유저 이름(username)");
		}
		return new ProdUserDetails(user);
	}

}
