package ez.ndvz.core.domain.service;

import ez.ndvz.core.domain.models.Property;
import ez.ndvz.ports.api.PropertyServicePort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PropertyServicePortImpl implements PropertyServicePort {
    @Override
    public Property findById(Long propertyId) {
        return null;
    }

    @Override
    public Property find(Property property) {
        return null;
    }

    @Override
    public Property create(Property property) {
        return null;
    }

    @Override
    public Property update(Long propertyId, Property property) {
        return null;
    }

    @Override
    public List<Property> findAllProperties() {
        return null;
    }

    @Override
    public List<Property> findAllPropertiesByCity(String city) {
        return null;
    }

    @Override
    public List<Property> filterPropertiesByPrice(Double price) {
        return null;
    }

    @Override
    public List<Property> filterPropertiesByYearBuilt(Date yearBuilt) {
        return null;
    }

    @Override
    public List<Property> filterPropertyByAgency(Long agencyId) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
