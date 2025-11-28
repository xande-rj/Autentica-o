package alexandreS.Authentication.Security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class BearerTokenAuthFilter extends OncePerRequestFilter {

  private final static String tokenMock = "vYQIYxOpyfr==";

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String authHeader = request.getHeader("Authorization");
    if (authHeader != null && authHeader.startsWith("Bearer ") && !authHeader.substring(7).isBlank()) {
      String accessToken = authHeader.substring(7);
      if (!tokenMock.equals(accessToken)) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("{\"error\": \"Authorization falta de token ou token errado \"}");
        return;
      } else {
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        return;
      }
    }
    filterChain.doFilter(request, response);
  }
}
