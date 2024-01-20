package ez.ndvz.ports.spi;

import ez.ndvz.core.domain.models.Property;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PropertyDatabasePort {

    Property findById(Long propertyId);

    Optional<Property> find(Property property);
    //TODO add Page -> Pagination in backend
    Property create(Property property); //TODO add one with (User user ,Apartment apartment)

    Property update(Long propertyId, Property property);

    List<Property> findAllProperties();

    List<Property> findAllPropertiesByCity(String city);
    List<Property> filterPropertiesByPrice(Double price);

    List<Property> filterPropertiesByYearBuilt(Date yearBuilt);

    List<Property> filterPropertyByAgency(Long agencyId);

    void delete(Long id);
}
