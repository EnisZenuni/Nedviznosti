package ez.ndvz.ports.api;

import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.core.domain.models.House;
import ez.ndvz.core.domain.models.Image;
import ez.ndvz.core.domain.models.Property;

import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PropertyServicePort {
    Optional<Property> findById(Long propertyId);

    Property find(Property property);

    //TODO add Page -> Pagination in backend
    Property create(Property property); //TODO add one with (User user ,Apartment apartment)

    Property update(Long propertyId, Property property);

    List<Property> findAllProperties();

    List<Property> findAllPropertiesByCity(String city);
    List<Property> filterPropertiesByPrice(Double price);

    List<Property> filterPropertiesByYearBuilt(Year yearBuilt);

    List<Property> filterPropertiesByAgency(String agencyName);

    void addImageToProperty(Image image);
    void addImagesToProperty(List<Image> imageList);

    void delete(Long id);
}
