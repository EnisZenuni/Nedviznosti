package ez.ndvz.ports.spi;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.domain.models.Property;

import java.util.List;
import java.util.Optional;

public interface AgencyDatabasePort {
    Agency findById(Long agencyId);

    Optional<Agency> find(Agency agency);

    //TODO add Page -> Pagination in backend
    Agency create(Agency agency);

    Agency update(Long agencyId, Agency agency);

    List<Agency> findAllAgencies();

    Double calculateRatings(List<Double> ratings);

    void delete(Long id);

    Property addProperty(Agency agency, Property property);
}
