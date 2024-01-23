package ez.ndvz.persistance.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("House")
public class HouseEntity extends PropertyEntity {

    @NonNull
    @NotBlank
    private Integer numberOfFloors;

}