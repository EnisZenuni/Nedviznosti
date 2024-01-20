package ez.ndvz.core.domain.models;

import ez.ndvz.core.domain.enumeration.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private Long userId;

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

    private Set<Roles> roles;
}
