package alexandreS.Authentication.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import alexandreS.Authentication.Service.JwtService;
import alexandreS.Authentication.Service.UserInfoService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

  private final UserInfoService userInfoService;
  private final JwtService jwtService;

  @Autowired
  public JwtFilter(UserInfoService userInfoService, JwtService jwtService) {
    this.userInfoService = userInfoService;
    this.jwtService = jwtService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    // recebo o header da requisicao
    String authHeader = request.getHeader("Authorization");
    // variavel de token
    String token = null;
    // nome do usuario
    String username = null;

    // verifico se o header for diferente de null e se comeca com Bearer
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      // token recebe tudo apos o Bearer
      token = authHeader.substring(7);
      // estrair o nome do token
      // username = jwtService.extrairNome(token);
    }
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = userInfoService.carregarUserByUsername(username);
      if (jwtService.validarToken(token, userDetails)) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
            null, userDetails.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

      }
    }
    filterChain.doFilter(request, response);
  }
}
