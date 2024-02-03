package ez.ndvz.postgreslauncher.configuration;

import ez.ndvz.application.Application;
import ez.ndvz.core.domain.service.*;
import ez.ndvz.persistance.adapter.*;
import ez.ndvz.persistance.enumerations.HouseMapper;
import ez.ndvz.persistance.mapper.AgencyMapper;
import ez.ndvz.persistance.mapper.ApartmentMapper;
import ez.ndvz.persistance.mapper.PropertyMapper;
import ez.ndvz.persistance.mapper.UserMapper;
import ez.ndvz.persistance.repository.*;
import ez.ndvz.ports.api.*;
import ez.ndvz.ports.spi.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class AppBean {
    @Bean
    public AgencyDatabasePort agencyDatabasePort(AgencyRepository repository, AgencyMapper agencyMapper, PropertyRepository propertyRepository, PropertyMapper propertyMapper) {
        return new AgencyDatabaseAdapter(repository,agencyMapper,propertyRepository,propertyMapper);
    }

    @Bean
    public AgencyServicePort agencyServicePort(AgencyDatabasePort agencyDatabasePort) {
        return new AgencyServicePortImpl(agencyDatabasePort);
    }

    @Bean
    public PropertyDatabasePort propertyDatabasePort(PropertyRepository repository, PropertyMapper mapper) {
        return new PropertyDatabaseAdapter(repository,mapper);
    }

    @Bean
    public PropertyServicePort propertyServicePort(PropertyDatabasePort propertyDatabasePort) {
        return new PropertyServicePortImpl(propertyDatabasePort);
    }

    @Bean
    public ApartmentDatabasePort apartmentDatabasePort(ApartmentRepository repository, ApartmentMapper mapper) {
        return new ApartmentDatabaseAdapter(repository,mapper);
    }

    @Bean
    public ApartmentServicePort apartmentServicePort(ApartmentDatabasePort apartmentDatabasePort) {
        return new ApartmentServicePortImpl(apartmentDatabasePort);
    }

    @Bean
    public HouseDatabasePort houseDatabasePort(HouseRepository repository, HouseMapper mapper) {
        return new HouseDatabaseAdapter(repository,mapper);
    }

    @Bean
    public HouseServicePort houseServicePort(HouseDatabasePort houseDatabasePort) {
        return new HouseServicePortImpl(houseDatabasePort);
    }

    @Bean
    public UserDatabasePort userDatabasePort(UserRepository repository, UserMapper mapper) {
        return new UserDatabaseAdapter(repository,mapper);
    }

    @Bean
    public UserServicePort userServicePort(UserDatabasePort userDatabasePort) {
        return new UserServicePortImpl(userDatabasePort);
    }
}
