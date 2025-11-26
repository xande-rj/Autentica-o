package alexandreS.Authentication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alexandreS.Authentication.Entity.UserDto;
import alexandreS.Authentication.Entity.UserInfo;
import alexandreS.Authentication.Repository.UserRepository;

@Service
public class UserInfoService {

  private final UserRepository userRepository;
  private final JwtService jwtService;

  public UserInfoService(UserRepository userRepository, JwtService jwtService) {
    this.userRepository = userRepository;
    this.jwtService = jwtService;
  }

  public String getHello() {
    return "hello World";
  }

  public String saveBD(UserDto userDto) {
    UserInfo userInfo = new UserInfo();
    userInfo.setNome(userDto.getNome());
    return getToken(userRepository.save(userInfo).getId());
  }

  public String getToken(Long id) {
    return jwtService.gerarToken(id);
  }

}
