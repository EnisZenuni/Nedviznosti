package ez.ndvz.persistance.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Apartment")
public class ApartmentEntity extends PropertyEntity {

    @NotBlank
    @NonNull
    @PositiveOrZero
    private Integer floor;

}
