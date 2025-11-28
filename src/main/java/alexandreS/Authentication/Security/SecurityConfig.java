package alexandreS.Authentication.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

  @Autowired
  BearerTokenAuthFilter bearerTokenAuthFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(request -> {
      request.requestMatchers("/hello").permitAll();
      request.anyRequest().authenticated();
    }).csrf(AbstractHttpConfigurer::disable).addFilterAfter(bearerTokenAuthFilter, BasicAuthenticationFilter.class);

    return http.build();
  }
}
