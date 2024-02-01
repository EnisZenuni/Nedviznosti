package ez.ndvz.persistance.repository;

import ez.ndvz.persistance.entity.AgencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<AgencyEntity, Long> {

}
