package ez.ndvz.persistance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "agencies",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name", name = "unique_name_constraint")
        }
)
public class AgencyEntity extends BaseEntity {

    @NotBlank
    @NotBlank
    private String name;

    @NotBlank
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @NotNull
    private String location;

    @NotBlank
    @NotNull
    private String contactNumber;

    @NotEmpty
    @ElementCollection
    private List<Double> ratings;

    @NotBlank
    @NotNull
    private Date establishmentDate;

    @OneToMany
    private List<UserEntity> agents;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<PropertyEntity> propertyListings;

    private Boolean isTrusted;
}
