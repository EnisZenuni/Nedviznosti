package ez.ndvz.ports.api;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.domain.models.Property;


import java.util.List;
import java.util.Optional;

public interface AgencyServicePort {
    Optional<Agency> findById(Long agencyId);

    Agency find(Agency agency);

    Agency create(Agency agency);

    Agency update(Long agencyId, Agency agency);

    List<Agency> findAllAgencies();

    void delete(Long id);

    Property addProperty(Long agencyId, Property property);
}
