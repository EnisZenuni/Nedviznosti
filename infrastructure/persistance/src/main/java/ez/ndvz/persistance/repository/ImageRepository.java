package ez.ndvz.persistance.repository;

import ez.ndvz.persistance.entity.PropertyImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<PropertyImage, Long> {
}
