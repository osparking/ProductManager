package space.bumtiger.product.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import space.bumtiger.product.security.oauth.CustomOAuth2UserService;

@Configuration
public class SecurityConfig {
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// @formatter:off
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
					(authorize) -> authorize
					.requestMatchers("/", "/login").permitAll()
					.anyRequest().authenticated())
				.formLogin().loginPage("/login")
				.and()
				.oauth2Login(oauth2 -> oauth2
					.loginPage("/login")
						.userInfoEndpoint()
						.userService(oauth2UserService));

		return http.build();
	}
	// @formatter:on
	
  @Autowired
  private CustomOAuth2UserService oauth2UserService;
}
