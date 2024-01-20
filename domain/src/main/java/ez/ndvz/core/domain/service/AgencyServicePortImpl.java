package ez.ndvz.core.domain.service;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.domain.models.Property;
import ez.ndvz.ports.api.AgencyServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServicePortImpl implements AgencyServicePort {
    @Override
    public Agency findById(Long agencyId) {
        return null;
    }

    @Override
    public Agency find(Agency agency) {
        return null;
    }

    @Override
    public Agency create(Agency agency) {
        return null;
    }

    @Override
    public Agency update(Long agencyId, Agency agency) {
        return null;
    }

    @Override
    public List<Agency> findAllAgencies() {
        return null;
    }

    @Override
    public Double calculateRatings(List<Double> ratings) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Property addProperty(Agency agency, Property property) {
        return null;
    }
}
