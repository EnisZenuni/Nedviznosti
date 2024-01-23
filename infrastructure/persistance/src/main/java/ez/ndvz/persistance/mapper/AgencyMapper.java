package ez.ndvz.persistance.mapper;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.persistance.entity.AgencyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AgencyMapper {

    Agency toDomain(AgencyEntity agencyEntity);

    AgencyEntity toEntity(Agency agency);
}
