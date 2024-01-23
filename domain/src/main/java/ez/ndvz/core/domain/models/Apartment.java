package ez.ndvz.core.domain.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Getter
@Setter
@Data
public class Apartment extends Property {

    private Long id;

    private Integer floor;


}
