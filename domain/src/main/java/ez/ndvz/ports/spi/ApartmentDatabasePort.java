package ez.ndvz.ports.spi;

import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.core.domain.models.House;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface ApartmentDatabasePort {
    Apartment exist(Long id);

    Apartment find(Apartment apartment);
    Optional<Apartment> findById(Long id);

    //TODO add Page -> Pagination in backend
    Apartment create(Apartment apartment); //TODO add one with (User user ,Apartment apartment)

    Apartment update(Long aparmentId, Apartment apartment);

    List<Apartment> findAllAparments();

    List<Apartment> findAllApartmentsByCity(String city);

    List<Apartment> filterApartmentsByPrice(Double price);

    List<Apartment> filterApartmentsByYearBuilt(Year yearBuilt);

    List<Apartment> filterApartmentsByAgency(String agencyName);

    void delete(Long id);
}
