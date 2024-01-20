package ez.ndvz.core.domain.models;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Getter
@Setter
@Data
public class Apartment extends Property {

    private Long apartmendId;
    @NotBlank
    @NonNull
    @PositiveOrZero
    private Integer floor;

    @Positive
    private double price;

    @Positive
    private double rentalPrice;
}
