package ez.ndvz.persistance.adapter;

import ez.ndvz.core.domain.models.Property;
import ez.ndvz.core.exceptions.ResourceNotFoundException;
import ez.ndvz.persistance.entity.AgencyEntity;
import ez.ndvz.persistance.entity.PropertyEntity;
import ez.ndvz.persistance.mapper.PropertyMapper;
import ez.ndvz.persistance.repository.PropertyRepository;
import ez.ndvz.ports.spi.PropertyDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyDatabaseAdapter implements PropertyDatabasePort {

    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    @Override
    @Transactional(readOnly = true)
    public Property exist(Long id) {
        var propertyEntity = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageFormat.format("Property with code {0} not found", id)));
        return propertyMapper.toDomain(propertyEntity);
    }

    @Override
    public Property findById(Property property) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Property> find(Long id) {
        return Optional.of(exist(id));
    }

    @Override
    @Transactional
    public Property create(Property property) {
        return propertyMapper.toDomain(propertyRepository.save(propertyMapper.toEntity(property)));
    }

    @Override
    @Transactional
    public Property update(Long propertyId, Property property) {
        var propertyUpdate = exist(propertyId);
        BeanUtils.copyProperties(property, propertyUpdate, "id");
        return propertyMapper.toDomain(propertyRepository.save(propertyMapper.toEntity(property)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Property> findAllProperties() {
        List<PropertyEntity> propertyEntities = propertyRepository.findAll();
        return propertyEntities.stream()
                .map(propertyMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Property> findAllPropertiesByCity(String city) {
        List<PropertyEntity> propertyEntities = propertyRepository.findAll();
        return propertyEntities.stream()
                .filter(propertyEntity->propertyEntity.getAddress().equalsIgnoreCase(city)) //TODO add city
                .map(propertyMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Property> filterPropertiesByPrice(Double price) {
        List<PropertyEntity> propertyEntities = propertyRepository.findAll();
        return propertyEntities.stream()
                .filter(propertyEntity -> propertyEntity.getPrice() <= price)
                .map(propertyMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Property> filterPropertiesByYearBuilt(Year yearBuilt) {
        List<PropertyEntity> propertyEntities = propertyRepository.findAll();
        return propertyEntities.stream()
                .filter(propertyEntity -> propertyEntity.getYearBuilt().isAfter(yearBuilt))
                .map(propertyMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Property> filterPropertiesByAgency(String agencyName) {
        List<PropertyEntity> propertyEntities = propertyRepository.findAll();
        return propertyEntities.stream()
                .filter(propertyEntity -> propertyEntity.getAgency().getName().equalsIgnoreCase(agencyName))
                .map(propertyMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var agencyOptional = propertyRepository.findById(id);
        agencyOptional.ifPresent(propertyRepository::delete);
    }
}
