package ez.ndvz.core.domain.models;

import ez.ndvz.core.domain.enumeration.Roles;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private Long id;

    private String name;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String password;

    private Set<Roles> roles;

    private List<Property> propertyList;
}
