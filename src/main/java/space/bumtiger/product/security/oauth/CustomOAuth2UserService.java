package space.bumtiger.product.security.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import space.bumtiger.product.Provider;
import space.bumtiger.product.security.User;
import space.bumtiger.product.security.UserRepository;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest)
			throws OAuth2AuthenticationException {
		OAuth2User user = super.loadUser(userRequest);
		return new CustomOAuth2User(user);
	}

	@Autowired
	private UserRepository userRepo;

	public void processOAuthPostLogin(String email) {
		User dbUser = userRepo.findByUsername(email);

		if (dbUser == null) {
			User newUser = new User();
			newUser.setUsername(email);
			newUser.setProvider(Provider.FACEBOOK);
			newUser.setEnabled(true);
			newUser.setPassword("(NA)");
			newUser.setRole("ROLE_USER");

			userRepo.save(newUser);
		}
	}

}