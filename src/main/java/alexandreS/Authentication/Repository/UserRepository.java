package alexandreS.Authentication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import alexandreS.Authentication.Entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long> {

}
