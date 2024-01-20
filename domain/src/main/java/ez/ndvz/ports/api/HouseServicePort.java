package ez.ndvz.ports.api;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.core.domain.models.House;

import java.util.Date;
import java.util.List;

public interface HouseServicePort {
    House findById(Long houseId);

    House find(House house);

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
