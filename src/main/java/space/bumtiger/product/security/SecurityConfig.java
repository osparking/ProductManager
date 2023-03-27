package space.bumtiger.product.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
		http.formLogin().loginPage("/login");
		http.authorizeHttpRequests(
				(authorize) -> {
					try {
						authorize
						.anyRequest().authenticated()
						.and()
							.formLogin().permitAll()
						.and()
							.logout().permitAll();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				});

		return http.build();
	}
	// @formatter:on
}
