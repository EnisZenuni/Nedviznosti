package ez.ndvz.ports.spi;

import ez.ndvz.core.domain.models.House;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HouseDatabasePort {
    House findById(Long houseId);
    Optional<House> find(House house);

    //TODO add Page -> Pagination in backend
    House create(House house);

    House update(Long houseId, House house);

    List<House> findAllHouses();

    List<House> findAllHousesByCity(String city);

    List<House> filterHousesByPrice(Double price);

    List<House> filterHousesByYearBuilt(Date yearBuilt);

    List<House> filterHousesByAgency(Long agencyId);
    void delete(Long id);
}
