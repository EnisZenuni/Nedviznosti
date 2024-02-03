package ez.ndvz.persistance.mapper;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.persistance.entity.AgencyEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AgencyMapper {

    Agency toDomain(AgencyEntity agencyEntity);

    AgencyEntity toEntity(Agency agency);
}
