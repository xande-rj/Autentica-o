package alexandreS.Authentication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import alexandreS.Authentication.Entity.UserDto;
import alexandreS.Authentication.Service.UserInfoService;

@RestController
public class UserControlle {

  @Autowired
  private UserInfoService userInfoService;

  @GetMapping("/hello")
  public String getHello() {
    return userInfoService.getHello();
  }

  @PostMapping("/cadastro")
  public String cadastroUsuario(@RequestBody UserDto usuarioDto) {
    return userInfoService.saveBD(usuarioDto);
  }

  @PostMapping("/token")
  public void geracaoToken() {

  }
}
