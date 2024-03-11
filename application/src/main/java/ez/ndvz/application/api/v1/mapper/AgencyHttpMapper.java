package ez.ndvz.application.api.v1.mapper;

import ez.ndvz.application.api.v1.dto.agencyDTOs.AgencyAuthRequestDTO;
import ez.ndvz.application.api.v1.dto.agencyDTOs.AgencyRequestDTO;
import ez.ndvz.application.api.v1.dto.agencyDTOs.AgencyResponseDTO;
import ez.ndvz.application.api.v1.dto.agencyDTOs.AgencyUpdateDTO;
import ez.ndvz.core.domain.models.Agency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AgencyHttpMapper {
    @Mapping(target = "isTrusted", ignore = true)
    @Mapping(target = "propertyListings", ignore = true)
    @Mapping(target = "agents", ignore = true)
    Agency toDomain(AgencyRequestDTO agencyRequestDTO);

    @Mapping(target = "isTrusted", ignore = true)
    @Mapping(target = "propertyListings", ignore = true)
    @Mapping(target = "agents", ignore = true)
    Agency authToDomain(AgencyAuthRequestDTO authRequestDTO);

    AgencyResponseDTO toDTO(Agency agency);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "propertyListings", ignore = true)
    @Mapping(target = "agents", ignore = true)
    Agency update(AgencyUpdateDTO source, @MappingTarget Agency target);
}
