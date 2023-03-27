package space.bumtiger.product.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import space.bumtiger.product.ProdUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);

		if (user == null) {
			String msg = username + "은 존재하지 않는 사용자입니다.";
			throw new UsernameNotFoundException(msg);
		}
		return new ProdUserDetails(user);
	}

}
