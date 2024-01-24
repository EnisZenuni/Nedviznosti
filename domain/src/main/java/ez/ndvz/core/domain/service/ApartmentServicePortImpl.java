package ez.ndvz.core.domain.service;

import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.ports.api.ApartmentServicePort;
import ez.ndvz.ports.spi.ApartmentDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ApartmentServicePortImpl implements ApartmentServicePort {
    private final ApartmentDatabasePort apartmentDatabasePort;

    @Override
    public Optional<Apartment> findById(Long apartmentId) {
        return apartmentDatabasePort.findById(apartmentId);
    }

    @Override
    public Apartment find(Apartment apartment) {
        return null;
    }

    @Override
    public Apartment create(Apartment apartment) {
        return apartmentDatabasePort.create(apartment);
    }

    @Override
    public Apartment update(Long aparmentId, Apartment apartment) {
        return apartmentDatabasePort.update(aparmentId,apartment);
    }

    @Override
    public List<Apartment> findAllAparments() {
        return apartmentDatabasePort.findAllAparments();
    }

    @Override
    public List<Apartment> findAllApartmentsByCity(String city) {
        return apartmentDatabasePort.findAllApartmentsByCity(city);
    }

    @Override
    public List<Apartment> filterApartmentsByPrice(Double price) {
        return apartmentDatabasePort.filterApartmentsByPrice(price);
    }

    @Override
    public List<Apartment> filterApartmentsByYearBuilt(Year yearBuilt) {
        return apartmentDatabasePort.filterApartmentsByYearBuilt(yearBuilt);
    }

    @Override
    public List<Apartment> filterApartmentsByAgency(String agencyName) {
        return apartmentDatabasePort.filterApartmentsByAgency(agencyName);
    }

    @Override
    public void delete(Long id) {
         apartmentDatabasePort.delete(id);
    }
}
