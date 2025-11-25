package alexandreS.Authentication.Controller;

import org.springframework.web.bind.annotation.*;

@RestController

public class UserControlle {

  @GetMapping("/hello")
  public String getHello() {
    return "Hello World";
  }

  @PostMapping("cadastro")
  public String cadastroUsuario(@RequestBody String usuarioDto) {
    return usuarioDto;
  }
}
