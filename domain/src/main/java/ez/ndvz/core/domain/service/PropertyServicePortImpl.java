package ez.ndvz.core.domain.service;

import ez.ndvz.core.domain.models.Image;
import ez.ndvz.core.domain.models.Property;
import ez.ndvz.ports.api.PropertyServicePort;
import ez.ndvz.ports.spi.PropertyDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyServicePortImpl implements PropertyServicePort {

    private final PropertyDatabasePort propertyDatabasePort;

    @Override
    public Optional<Property> findById(Long propertyId) {
        return propertyDatabasePort.findById(propertyId);
    }

    @Override
    public Property find(Property property) {
        return null;
    }

    @Override
    public Property create(Property property) {
        return propertyDatabasePort.create(property);
    }

    @Override
    public Property update(Long propertyId, Property property) {
        return propertyDatabasePort.update(propertyId, property);
    }

    @Override
    public List<Property> findAllProperties() {
        return propertyDatabasePort.findAllProperties();
    }

    @Override
    public List<Property> findAllPropertiesByCity(String city) {
        return propertyDatabasePort.findAllPropertiesByCity(city);
    }

    @Override
    public List<Property> filterPropertiesByPrice(Double price) {
        return propertyDatabasePort.filterPropertiesByPrice(price);
    }

    @Override
    public List<Property> filterPropertiesByYearBuilt(Year yearBuilt) {
        return propertyDatabasePort.filterPropertiesByYearBuilt(yearBuilt);
    }

    @Override
    public List<Property> filterPropertiesByAgency(String agencyName) {
        return propertyDatabasePort.filterPropertiesByAgency(agencyName);
    }

    @Override
    public void addImageToProperty(Image image) {

    }

    @Override
    public void addImagesToProperty(List<Image> imageList) {

    }

    @Override
    public void delete(Long id) {
        propertyDatabasePort.delete(id);
    }
}
