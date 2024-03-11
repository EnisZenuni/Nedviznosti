package ez.ndvz.application.api.v1.controller;

import ez.ndvz.application.api.v1.dto.agencyDTOs.AgencyAuthRequestDTO;
import ez.ndvz.application.api.v1.dto.agencyDTOs.AgencyRequestDTO;
import ez.ndvz.application.api.v1.dto.agencyDTOs.AgencyResponseDTO;
import ez.ndvz.application.api.v1.dto.agencyDTOs.AgencyUpdateDTO;
import ez.ndvz.application.api.v1.dto.authenticationDTOs.SignUpResponseDTO;
import ez.ndvz.application.api.v1.dto.propertyDTOs.PropertyRequestDTO;
import ez.ndvz.application.api.v1.dto.propertyDTOs.PropertyResponseDTO;
import ez.ndvz.application.api.v1.mapper.AgencyHttpMapper;
import ez.ndvz.application.api.v1.mapper.PropertyHttpMapper;
import ez.ndvz.core.domain.models.Agency;
import ez.ndvz.core.exceptions.ResourceNotFoundException;
import ez.ndvz.ports.api.AgencyServicePort;
import ez.ndvz.ports.api.PropertyServicePort;
import ez.ndvz.ports.spi.AgencyAuthenticationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/agency")
@RequiredArgsConstructor
public class AgencyController {
    private final AgencyServicePort agencyServicePort;
    private final AgencyAuthenticationPort agencyAuthenticationPort;
    private final AgencyHttpMapper agencyHttpMapper;
    private final PropertyServicePort propertyServicePort;
    private final PropertyHttpMapper propertyHttpMapper;

    @PostMapping("/signIn")
    public ResponseEntity<AgencyResponseDTO> signIn(@RequestBody AgencyAuthRequestDTO authRequestDTO) {
        var Agency = agencyAuthenticationPort.signIn(agencyHttpMapper.authToDomain(authRequestDTO));
        return ResponseEntity.ok(agencyHttpMapper.toDTO(Agency));
    }
    @PostMapping("/signUp")
    public ResponseEntity<SignUpResponseDTO> signUp(@RequestBody AgencyAuthRequestDTO authRequestDTO) {
        var Agency = agencyAuthenticationPort.signUp(agencyHttpMapper.authToDomain(authRequestDTO));
        var responseDTO = SignUpResponseDTO.builder()
                .jwt(agencyAuthenticationPort.getToken(Agency))
                .message(String.format("Agency %s registered", Agency.getName()))
                .success(true)
                .build();
        return ResponseEntity.ok(responseDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<List<AgencyResponseDTO>> getAllAgencies() {
        List<Agency> agencies = agencyServicePort.findAllAgencies();

        List<AgencyResponseDTO> agencyResponseDTOList = agencies
                .stream().map(agencyHttpMapper::toDTO)
                .toList();

        return ResponseEntity.ok(agencyResponseDTOList);
    }

    @GetMapping("/get/{agencyId}")
    public ResponseEntity<AgencyResponseDTO> getAgencyById(@PathVariable Long agencyId) {
        Optional<Agency> agency = agencyServicePort.findById(agencyId);
        return agency.map(p -> ResponseEntity.ok(agencyHttpMapper.toDTO(p))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<AgencyResponseDTO> createAgency(@RequestBody AgencyRequestDTO agencyRequestDTO) {
        var createdAgency = agencyServicePort.create(agencyHttpMapper.toDomain(agencyRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(agencyHttpMapper.toDTO(createdAgency));
    }

    @PutMapping("/update/{agencyId}")
    public ResponseEntity<AgencyResponseDTO> updateAgency(
            @PathVariable Long agencyId,
            @RequestBody AgencyUpdateDTO agencyUpdateDTO) {
        var agencyToUpdate = agencyServicePort.findById(agencyId).orElseThrow(()-> new ResourceNotFoundException("Agency not found with id "+ agencyId));
        var update = agencyHttpMapper.update(agencyUpdateDTO, agencyToUpdate);
        agencyServicePort.update(agencyId, update);
        return ResponseEntity.status(HttpStatus.CREATED).body(agencyHttpMapper.toDTO(update));
    }

    @DeleteMapping("/delete/{agencyId}")
    public ResponseEntity<Void> deletePropertyById(@PathVariable Long agencyId) {
        agencyServicePort.delete(agencyId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add/property/to/agency/{agencyId}")
    public ResponseEntity<PropertyResponseDTO> addPropertyToAgency(@PathVariable Long agencyId, @RequestBody PropertyRequestDTO propertyRequestDTO) {
        var createdProperty = propertyServicePort.create(propertyHttpMapper.toDomain(propertyRequestDTO));
        agencyServicePort.addProperty(agencyId, createdProperty);
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyHttpMapper.toDTO(createdProperty));
    }
}
