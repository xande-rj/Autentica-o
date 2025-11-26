package alexandreS.Authentication.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alexandreS.Authentication.Entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

}
