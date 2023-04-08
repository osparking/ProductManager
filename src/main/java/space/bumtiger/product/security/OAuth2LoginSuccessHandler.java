package space.bumtiger.product.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import space.bumtiger.product.security.oauth.CustomOAuth2User;
import space.bumtiger.product.security.oauth.CustomOAuth2UserService;

@Component
public class OAuth2LoginSuccessHandler
		extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private CustomOAuth2UserService userService;

	@Autowired
	private UserRepository userRepo;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		CustomOAuth2User user = (CustomOAuth2User) authentication.getPrincipal();

		User existingUser = userRepo.findByUsername(user.getEmail());

		if (existingUser == null) {
			userService.processOAuthPostLogin(user.getEmail());
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
