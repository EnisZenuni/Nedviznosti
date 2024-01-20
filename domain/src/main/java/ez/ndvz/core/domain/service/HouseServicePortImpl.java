package ez.ndvz.core.domain.service;

import ez.ndvz.core.domain.models.House;
import ez.ndvz.ports.api.HouseServicePort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HouseServicePortImpl implements HouseServicePort {
    @Override
    public House findById(Long houseId) {
        return null;
    }

    @Override
    public House find(House house) {
        return null;
    }

    @Override
    public House create(House house) {
        return null;
    }

    @Override
    public House update(Long houseId, House house) {
        return null;
    }

    @Override
    public List<House> findAllHouses() {
        return null;
    }

    @Override
    public List<House> findAllHousesByCity(String city) {
        return null;
    }

    @Override
    public List<House> filterHousesByPrice(Double price) {
        return null;
    }

    @Override
    public List<House> filterHousesByYearBuilt(Date yearBuilt) {
        return null;
    }

    @Override
    public List<House> filterHousesByAgency(Long agencyId) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
