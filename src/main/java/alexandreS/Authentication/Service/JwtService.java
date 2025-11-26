package alexandreS.Authentication.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Component
public class JwtService {

  @Value("${api.secret.token.jwt}")
  private String secret;

  public String gerarToken(Long id) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      String token = JWT.create().withIssuer("Authentication").withSubject(id.toString()).sign(algorithm);
      return token;
    } catch (JWTCreationException exception) {
      throw new RuntimeException(exception);
    }
  }

}
