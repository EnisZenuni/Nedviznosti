package ez.ndvz.persistance.repository;

import ez.ndvz.persistance.entity.PropertyImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<PropertyImageEntity, Long> {
}
