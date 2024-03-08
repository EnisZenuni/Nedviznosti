package ez.ndvz.ports.spi;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.domain.models.Property;

import java.util.List;
import java.util.Optional;

public interface AgencyDatabasePort {
    Agency exist(Long id);
    Agency find(Agency agency);
    Optional<Agency> findById(Long id);
    Agency create(Agency agency);
    Agency update(Long agencyId, Agency agency);
    List<Agency> findAllAgencies();
    void delete(Long id);
    Property addPropertyToAgency(Long agencyId, Property property);
}
