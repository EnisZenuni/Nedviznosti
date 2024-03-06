package ez.ndvz.core.domain.models;

import lombok.*;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class House extends Property {
    private Long houseId;
}
