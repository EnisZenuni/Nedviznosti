package ez.ndvz.application.api.v1.controller;

import ez.ndvz.application.api.v1.dto.propertyDTOs.PropertyRequestDTO;
import ez.ndvz.application.api.v1.dto.propertyDTOs.PropertyResponseDTO;
import ez.ndvz.application.api.v1.dto.propertyDTOs.PropertyUpdateDTO;
import ez.ndvz.application.api.v1.mapper.PropertyHttpMapper;
import ez.ndvz.core.domain.models.Property;
import ez.ndvz.core.exceptions.ResourceNotFoundException;
import ez.ndvz.ports.api.PropertyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/property")
@RequiredArgsConstructor
public class PropertyController {
    private final PropertyServicePort propertyServicePort;
    private final PropertyHttpMapper propertyHttpMapper;


    @GetMapping("/all")
    public ResponseEntity<List<PropertyResponseDTO>> getAllProperties() {
        List<Property> properties = propertyServicePort.findAllProperties();

        List<PropertyResponseDTO> responseDTOs = properties.stream()
                .map(propertyHttpMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/allByCity")
    public ResponseEntity<List<PropertyResponseDTO>> getAllPropertiesByCity(@RequestParam("city") String city) {
        List<Property> properties = propertyServicePort.findAllPropertiesByCity(city);
        List<PropertyResponseDTO> responseDTOs = properties.stream()
                .map(propertyHttpMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/allByPrice")
    public ResponseEntity<List<PropertyResponseDTO>> getAllPropertiesByPrice(@RequestParam("price") Double price) {
        List<Property> properties = propertyServicePort.filterPropertiesByPrice(price);
        List<PropertyResponseDTO> responseDTOs = properties.stream()
                .map(propertyHttpMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/allByYear")
    public ResponseEntity<List<PropertyResponseDTO>> getAllPropertiesByYear(@RequestParam("year") String year) {
        List<Property> properties = propertyServicePort.filterPropertiesByYearBuilt(Year.parse(year));
        List<PropertyResponseDTO> responseDTOs = properties.stream()
                .map(propertyHttpMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseDTOs);
    }

    @PostMapping("/create")
    public ResponseEntity<PropertyResponseDTO> createProperty(@RequestBody PropertyRequestDTO propertyRequestDTO) {
        var createdProperty = propertyServicePort.create(propertyHttpMapper.toDomain(propertyRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyHttpMapper.toDTO(createdProperty));
    }


    @GetMapping("/get/{propertyId}")
    public ResponseEntity<PropertyResponseDTO> getPropertyById(@PathVariable Long propertyId) {
        Optional<Property> property = propertyServicePort.findById(propertyId);
        return property.map(p -> ResponseEntity.ok(propertyHttpMapper.toDTO(p))).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{propertyId}")
    public ResponseEntity<PropertyResponseDTO> updateProperty(
            @PathVariable Long propertyId,
            @RequestBody PropertyUpdateDTO propertyUpdateDTO) {

        var propertyToUpdate = propertyServicePort.findById(propertyId).orElseThrow(()-> new ResourceNotFoundException("Property not found with Id" + propertyId));
        var update = propertyHttpMapper.update(propertyUpdateDTO,propertyToUpdate);
        propertyServicePort.update(propertyId, update);
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyHttpMapper.toDTO(update));
    }


    @DeleteMapping("/delete/{propertyId}")
    public ResponseEntity<Void> deletePropertyById(@PathVariable Long propertyId) {
        propertyServicePort.delete(propertyId);
        return ResponseEntity.noContent().build();
    }
}
