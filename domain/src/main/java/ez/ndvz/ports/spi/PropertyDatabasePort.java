package ez.ndvz.ports.spi;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.domain.models.Property;

import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PropertyDatabasePort {

    Property exist(Long id);

    Property findById(Property property);

    Optional<Property> find(Long id);
    //TODO add Page -> Pagination in backend
    Property create(Property property); //TODO add one with (User user ,Apartment apartment)

    Property update(Long propertyId, Property property);

    List<Property> findAllProperties();

    List<Property> findAllPropertiesByCity(String city);
    List<Property> filterPropertiesByPrice(Double price);

    List<Property> filterPropertiesByYearBuilt(Year yearBuilt);

    List<Property> filterPropertiesByAgency(String agencyName);

    void delete(Long id);
}
