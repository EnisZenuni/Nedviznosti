package ez.ndvz.core.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Agency {
    private Long id;

    private String name;


    private String email;

    private String location;


    private String contactNumber;


    private List<Double> ratings;


    private Date establishmentDate;

    private List<User> agents;
    private List<Property> propertyListings;

    private Boolean isTrusted;

}
