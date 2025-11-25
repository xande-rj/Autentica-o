package alexandreS.Authentication.Service;

import org.springframework.stereotype.Service;

import alexandreS.Authentication.Repository.UserRepository;

@Service
public class UserInfoService {

  private final UserRepository userRepository;

  public UserInfoService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public String getHello() {
    return "hello World";
  }
}
