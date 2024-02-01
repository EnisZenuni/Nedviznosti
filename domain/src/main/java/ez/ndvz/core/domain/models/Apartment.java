package ez.ndvz.core.domain.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class Apartment extends Property {

    private Long houseId;

    private Integer floor;

}
