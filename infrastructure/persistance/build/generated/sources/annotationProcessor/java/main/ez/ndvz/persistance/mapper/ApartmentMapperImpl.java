package ez.ndvz.persistance.mapper;

import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.persistance.entity.ApartmentEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-28T13:26:03+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
public class ApartmentMapperImpl implements ApartmentMapper {

    @Override
    public Apartment toDomain(ApartmentEntity apartmentEntity) {
        if ( apartmentEntity == null ) {
            return null;
        }

        Apartment.ApartmentBuilder<?, ?> apartment = Apartment.builder();

        return apartment.build();
    }

    @Override
    public ApartmentEntity toEntity(Apartment apartment) {
        if ( apartment == null ) {
            return null;
        }

        ApartmentEntity apartmentEntity = new ApartmentEntity();

        return apartmentEntity;
    }
}
