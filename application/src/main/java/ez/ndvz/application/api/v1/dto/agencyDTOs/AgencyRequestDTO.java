package ez.ndvz.application.api.v1.dto.agencyDTOs;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AgencyRequestDTO {
    public String name;
    public String email;
    public String location;
    public String contactNumber;
    public Date establishmentDate;
}
