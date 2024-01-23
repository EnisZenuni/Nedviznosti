package ez.ndvz.persistance.repository;

import ez.ndvz.persistance.entity.ApartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<ApartmentEntity, Long> {
}
