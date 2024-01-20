package ez.ndvz.ports.api;

import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.core.domain.models.House;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ApartmentServicePort {
    Apartment findById(Long apartmentId);

    Apartment find(Apartment apartment);

    //TODO add Page -> Pagination in backend
    Apartment create(Apartment apartment); //TODO add one with (User user ,Apartment apartment)

    Apartment update(Long aparmentId, Apartment apartment);

    List<Apartment> findAllAparments();

    List<Apartment> findAllApartmentsByCity(String city);

    List<House> filterApartmentsByPrice(Double price);

    List<House> filterApartmentsByYearBuilt(Date yearBuilt);

    List<House> filterApartmentsByAgency(Long agencyId);

    void delete(Long id);
}
