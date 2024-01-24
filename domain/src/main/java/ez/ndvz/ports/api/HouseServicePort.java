package ez.ndvz.ports.api;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.core.domain.models.House;

import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HouseServicePort {
    Optional<House> findById(Long houseId);

    House find(House house);

    //TODO add Page -> Pagination in backend
    House create(House house);

    House update(Long houseId, House house);

    List<House> findAllHouses();

    List<House> findAllHousesByCity(String city);

    List<House> filterHousesByPrice(Double price);

    List<House> filterHousesByYearBuilt(Year yearBuilt);

    List<House> filterHousesByAgency(String agencyName);

    void delete(Long id);
}
