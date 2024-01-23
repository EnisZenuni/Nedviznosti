package ez.ndvz.persistance.adapter;

import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.core.exceptions.ResourceNotFoundException;
import ez.ndvz.persistance.entity.ApartmentEntity;
import ez.ndvz.persistance.mapper.ApartmentMapper;
import ez.ndvz.persistance.repository.ApartmentRepository;
import ez.ndvz.ports.spi.ApartmentDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApartmentDatabaseAdapter implements ApartmentDatabasePort {
    private final ApartmentRepository apartmentRepository;
    private final ApartmentMapper apartmentMapper;

    @Transactional(readOnly = true)
    @Override
    public Apartment exist(Long id) {
        var propertyEntity = apartmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageFormat.format("Apartment with code {0} not found", id)));
        return apartmentMapper.toDomain(propertyEntity);
    }

    @Override
    public Apartment find(Apartment apartment) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Apartment> findById(Long id) {
        return Optional.of(exist(id));
    }

    @Transactional
    @Override
    public Apartment create(Apartment apartment) {
        return apartmentMapper.toDomain(apartmentRepository.save(apartmentMapper.toEntity(apartment)));
    }

    @Transactional
    @Override
    public Apartment update(Long aparmentId, Apartment apartment) {

        var apartmentUpdate = exist(aparmentId);
        BeanUtils.copyProperties(apartment, apartmentUpdate, "id");
        return apartmentMapper.toDomain(apartmentRepository.save(apartmentMapper.toEntity(apartment)));
    }

    @Transactional
    @Override
    public List<Apartment> findAllAparments() {
        List<ApartmentEntity> propertyEntities = apartmentRepository.findAll();
        return propertyEntities.stream()
                .map(apartmentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Apartment> findAllApartmentsByCity(String city) {
        List<ApartmentEntity> propertyEntities = apartmentRepository.findAll();
        return propertyEntities.stream()
                .filter(propertyEntity -> propertyEntity.getAddress().equalsIgnoreCase(city)) //TODO add city
                .map(apartmentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Apartment> filterApartmentsByPrice(Double price) {
        List<ApartmentEntity> propertyEntities = apartmentRepository.findAll();
        return propertyEntities.stream()
                .filter(propertyEntity -> propertyEntity.getPrice() <= price)
                .map(apartmentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Apartment> filterApartmentsByYearBuilt(Year yearBuilt) {
        List<ApartmentEntity> propertyEntities = apartmentRepository.findAll();
        return propertyEntities.stream()
                .filter(propertyEntity -> propertyEntity.getYearBuilt().isAfter(yearBuilt))
                .map(apartmentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Apartment> filterApartmentsByAgency(String agencyName) {
        List<ApartmentEntity> propertyEntities = apartmentRepository.findAll();
        return propertyEntities.stream()
                .filter(propertyEntity -> propertyEntity.getAgency().getName().equalsIgnoreCase(agencyName))
                .map(apartmentMapper::toDomain)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Long id) {
        var agencyOptional = apartmentRepository.findById(id);
        agencyOptional.ifPresent(apartmentRepository::delete);
    }
}
