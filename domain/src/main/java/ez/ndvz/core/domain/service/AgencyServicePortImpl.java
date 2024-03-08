package ez.ndvz.core.domain.service;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.domain.models.Property;
import ez.ndvz.ports.api.AgencyServicePort;
import ez.ndvz.ports.spi.AgencyDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgencyServicePortImpl implements AgencyServicePort {

    private final AgencyDatabasePort agencyDatabasePort;

    @Override
    public Optional<Agency> findById(Long agencyId) {
        return agencyDatabasePort.findById(agencyId);
    }

    @Override
    public Agency find(Agency agency) {
        return null;
    }

    @Override
    public Agency create(Agency agency) {
        return agencyDatabasePort.create(agency);
    }

    @Override
    public Agency update(Long agencyId, Agency agency) {
        return agencyDatabasePort.update(agencyId, agency);
    }

    @Override
    public List<Agency> findAllAgencies() {
        return agencyDatabasePort.findAllAgencies();
    }

    @Override
    public void delete(Long id) {
        agencyDatabasePort.delete(id);
    }

    @Override
    public Property addProperty(Long agencyId, Property property) {
        return agencyDatabasePort.addPropertyToAgency(agencyId, property);
    }
}
