package alexandreS.Authentication.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserControlle {

  @GetMapping("/hello")
  public ResponseEntity<String> getHello() {
    return ResponseEntity.ok("Hello World");
  }

  @GetMapping("/foo-bar")
  public ResponseEntity<Void> verificarToken() {
    return ResponseEntity.noContent().build();
  }

}
