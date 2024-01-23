package ez.ndvz.core.domain.models;

import lombok.*;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class House extends Property {

    private Long id;

    private Integer numberOfFloors;

}
