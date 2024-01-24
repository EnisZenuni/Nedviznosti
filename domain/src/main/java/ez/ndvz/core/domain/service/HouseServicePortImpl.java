package ez.ndvz.core.domain.service;

import ez.ndvz.core.domain.models.House;
import ez.ndvz.ports.api.HouseServicePort;
import ez.ndvz.ports.spi.HouseDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseServicePortImpl implements HouseServicePort {

    private final HouseDatabasePort houseDatabasePort;

    @Override
    public Optional<House> findById(Long houseId) {
        return houseDatabasePort.findById(houseId);
    }

    @Override
    public House find(House house) {
        return null;
    }

    @Override
    public House create(House house) {
        return houseDatabasePort.create(house);
    }

    @Override
    public House update(Long houseId, House house) {
        return houseDatabasePort.update(houseId, house);
    }

    @Override
    public List<House> findAllHouses() {
        return houseDatabasePort.findAllHouses();
    }

    @Override
    public List<House> findAllHousesByCity(String city) {
        return houseDatabasePort.findAllHousesByCity(city);
    }

    @Override
    public List<House> filterHousesByPrice(Double price) {
        return houseDatabasePort.filterHousesByPrice(price);
    }

    @Override
    public List<House> filterHousesByYearBuilt(Year yearBuilt) {
        return houseDatabasePort.filterHousesByYearBuilt(yearBuilt);
    }

    @Override
    public List<House> filterHousesByAgency(String agencyName) {
        return houseDatabasePort.filterHousesByAgency(agencyName);
    }

    @Override
    public void delete(Long id) {
        houseDatabasePort.delete(id);
    }
}
