package ez.ndvz.persistance.entity;

import ez.ndvz.persistance.enumerations.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email", name = "unique_email_constraint")
        }
)
public class UserEntity extends BaseEntity {
    @NonNull
    @NotBlank
    private String name;

    @NotBlank
    @NonNull
    private String lastName;

    @NonNull
    @NotBlank
    @Pattern(regexp = "^\\+(389)\\s?([2-7]0|78|77|75|76|71|72|73|74)\\s?([0-9]{6})$", message = "Invalid phone number format for North Macedonia")
    private String phoneNumber;

    @NotBlank
    @NonNull
    @Email
    private String email;

    @NonNull
    @NotBlank
    @Size(min = 6)
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Set<Roles> roles;
}