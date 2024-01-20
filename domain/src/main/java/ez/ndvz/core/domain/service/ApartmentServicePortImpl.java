package ez.ndvz.core.domain.service;

import ez.ndvz.core.domain.models.Apartment;
import ez.ndvz.core.domain.models.House;
import ez.ndvz.ports.api.ApartmentServicePort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentServicePortImpl implements ApartmentServicePort {
    @Override
    public Apartment findById(Long apartmentId) {
        return null;
    }

    @Override
    public Apartment find(Apartment apartment) {
        return null;
    }

    @Override
    public Apartment create(Apartment apartment) {
        return null;
    }

    @Override
    public Apartment update(Long aparmentId, Apartment apartment) {
        return null;
    }

    @Override
    public List<Apartment> findAllAparments() {
        return null;
    }

    @Override
    public List<Apartment> findAllApartmentsByCity(String city) {
        return null;
    }

    @Override
    public List<House> filterApartmentsByPrice(Double price) {
        return null;
    }

    @Override
    public List<House> filterApartmentsByYearBuilt(Date yearBuilt) {
        return null;
    }

    @Override
    public List<House> filterApartmentsByAgency(Long apartmentsId) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
