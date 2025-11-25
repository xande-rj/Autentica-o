package alexandreS.Authentication.Controller;

import org.springframework.web.bind.annotation.*;

import alexandreS.Authentication.Service.UserInfoService;

@RestController

public class UserControlle {

  private UserInfoService userInfoService;

  @GetMapping("/hello")
  public String getHello() {
    return userInfoService.getHello();
  }

  @PostMapping("/cadastro")
  public String cadastroUsuario(@RequestBody String usuarioDto) {
    return usuarioDto;
  }

  @PostMapping("/token")
  public void geracaoToken() {

  }
}
