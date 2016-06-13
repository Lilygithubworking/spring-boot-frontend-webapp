package application.userdetailssection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mj on 9/6/16.
 */
@Repository
public interface FrontUserRepository extends JpaRepository<UserDomain, Long> {
    UserDomain findByUsername(String username);
}
