package ez.ndvz.persistance.repository;

import ez.ndvz.persistance.entity.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<HouseEntity, Long> {
}
