package ez.ndvz.persistance.repository;

import ez.ndvz.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findApplicationUserByName(String username);

    Optional<UserEntity> findApplicationUserByEmail(String email);
}
