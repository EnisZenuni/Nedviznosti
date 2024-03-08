package ez.ndvz.application.api.v1.dto.agencyDTOs;

import ez.ndvz.core.domain.models.Property;
import ez.ndvz.core.domain.models.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class AgencyResponseDTO {
    public String name;
    public String email;
    public String location;
    public String contactNumber;
    public Date establishmentDate;
    public List<User> agents;
    public List<Property> propertyListings;
    public Boolean isTrusted;
}
