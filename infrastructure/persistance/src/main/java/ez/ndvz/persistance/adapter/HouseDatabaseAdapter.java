package ez.ndvz.persistance.adapter;

import ez.ndvz.core.domain.models.House;
import ez.ndvz.core.exceptions.ResourceNotFoundException;
import ez.ndvz.persistance.entity.HouseEntity;
import ez.ndvz.persistance.mapper.HouseMapper;
import ez.ndvz.persistance.repository.HouseRepository;
import ez.ndvz.ports.spi.HouseDatabasePort;
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
public class HouseDatabaseAdapter implements HouseDatabasePort {
    private final HouseRepository houseRepository;
    private final HouseMapper houseMapper;

    @Transactional(readOnly = true)
    @Override
    public House exist(Long id) {
        var houseEntity = houseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageFormat.format("House with code {0} not found", id)));
        return houseMapper.toDomain(houseEntity);
    }

    @Override
    public House find(House house) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<House> findById(Long id) {
        return Optional.of(exist(id));
    }

    @Transactional
    @Override
    public House create(House house) {
        return houseMapper.toDomain(houseRepository.save(houseMapper.toEntity(house)));
    }

    @Transactional
    @Override
    public House update(Long houseId, House house) {
        var houseUpdate = exist(houseId);
        BeanUtils.copyProperties(house, houseUpdate, "id");
        return houseMapper.toDomain(houseRepository.save(houseMapper.toEntity(house)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<House> findAllHouses() {
        List<HouseEntity> propertyEntities = houseRepository.findAll();
        return propertyEntities.stream()
                .map(houseMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<House> findAllHousesByCity(String city) {
        List<HouseEntity> propertyEntities = houseRepository.findAll();
        return propertyEntities.stream()
                .filter(propertyEntity -> propertyEntity.getAddress().equalsIgnoreCase(city)) //TODO add city
                .map(houseMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<House> filterHousesByPrice(Double price) {
        List<HouseEntity> propertyEntities = houseRepository.findAll();
        return propertyEntities.stream()
                .filter(propertyEntity -> propertyEntity.getPrice() <= price)
                .map(houseMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<House> filterHousesByYearBuilt(Year yearBuilt) {
        List<HouseEntity> propertyEntities = houseRepository.findAll();
        return propertyEntities.stream()
                .filter(propertyEntity -> propertyEntity.getYearBuilt().isAfter(yearBuilt))
                .map(houseMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<House> filterHousesByAgency(String agencyName) {
        List<HouseEntity> propertyEntities = houseRepository.findAll();
        return propertyEntities.stream()
                .filter(propertyEntity -> propertyEntity.getAgency().getName().equalsIgnoreCase(agencyName))
                .map(houseMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        var agencyOptional = houseRepository.findById(id);
        agencyOptional.ifPresent(houseRepository::delete);
    }
}
