package ez.ndvz.core.domain.models;

import ez.ndvz.core.domain.enumeration.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Agency {
    private Long id;

    private String name;

    private String email;

    private String password;

    private String location;

    private String contactNumber;

    private Set<Roles> roles;

    private Date establishmentDate;

    private List<User> agents;

    private List<Property> propertyListings;

    private Boolean isTrusted;
}
