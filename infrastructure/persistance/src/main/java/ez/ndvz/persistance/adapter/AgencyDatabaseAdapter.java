package ez.ndvz.persistance.adapter;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.domain.models.Property;
import ez.ndvz.core.exceptions.ResourceNotFoundException;
import ez.ndvz.persistance.entity.AgencyEntity;
import ez.ndvz.persistance.entity.PropertyEntity;
import ez.ndvz.persistance.mapper.AgencyMapper;
import ez.ndvz.persistance.mapper.PropertyMapper;
import ez.ndvz.persistance.repository.AgencyRepository;
import ez.ndvz.persistance.repository.PropertyRepository;
import ez.ndvz.ports.spi.AgencyDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgencyDatabaseAdapter implements AgencyDatabasePort {

    private final AgencyRepository agencyRepository;
    private final AgencyMapper agencyMapper;
    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    @Transactional(readOnly = true)
    @Override
    public Agency exist(Long id) {
        var agencyEntity = agencyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Agency with id %d not found", id)));
        return agencyMapper.toDomain(agencyEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Agency> findById(Long agencyId) {
        return Optional.of(exist(agencyId));
    }

    @Transactional(readOnly = true)
    @Override
    public Agency find(Agency agency) {
        return null;
    }

    @Override
    public Agency create(Agency agency) {
        return agencyMapper.toDomain(agencyRepository.save(agencyMapper.toEntity(agency)));
    }

    @Transactional
    @Override
    public Agency update(Long agencyId, Agency agency) {
        var agencyEntityToUpdate = agencyMapper.toEntity(agency);
        agencyEntityToUpdate.setId(agencyId);
        return agencyMapper.toDomain(agencyRepository.save(agencyEntityToUpdate));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Agency> findAllAgencies() {
        List<AgencyEntity> agencyEntities = agencyRepository.findAll();
        return agencyEntities.stream()
                .map(agencyMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        var agencyOptional = agencyRepository.findById(id);
        agencyOptional.ifPresent(agencyRepository::delete);
    }

    @Transactional
    @Override
    public Property addPropertyToAgency(Long agencyId, Property property) {
        AgencyEntity agencyEntity = agencyRepository.findById(agencyId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Agency with id %d not found", agencyId)));

        PropertyEntity propertyEntity = propertyMapper.toEntity(property);
        propertyEntity.setAgency(agencyEntity);
        propertyRepository.save(propertyEntity);

        agencyEntity.getPropertyListings().add(propertyEntity);

        return propertyMapper.toDomain(propertyEntity);
    }
}
