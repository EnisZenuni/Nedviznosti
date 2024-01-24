package ez.ndvz.ports.api;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.core.domain.models.House;

import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ApartmentServicePort {
    Optional<Apartment> findById(Long apartmentId);

    Apartment find(Apartment apartment);

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
