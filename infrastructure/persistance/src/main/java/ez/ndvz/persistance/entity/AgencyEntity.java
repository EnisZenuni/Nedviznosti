package ez.ndvz.persistance.entity;

import ez.ndvz.persistance.enumerations.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @NonNull
    @NotBlank
    @Size(min = 6)
    private String password;

    @NotBlank
    @NotNull
    private String location;

    @NotBlank
    @NotNull
    private String contactNumber;

    @Enumerated(value = EnumType.STRING)
    private Set<Roles> roles;

    @NotBlank
    @NotNull
    private Date establishmentDate;

    @OneToMany
    private List<UserEntity> agents = new ArrayList<>();

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PropertyEntity> propertyListings = new ArrayList<>();

    private Boolean isTrusted;
}
