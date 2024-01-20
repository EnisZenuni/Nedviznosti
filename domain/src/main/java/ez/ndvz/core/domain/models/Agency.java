package ez.ndvz.core.domain.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public class Agency {
    private Long agencyId;

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


    private List<Double> ratings;

    @NotBlank
    @NotNull
    private Date establishmentDate;

    private List<User> agents;
    private List<Property> propertyListings;

    private Boolean isTrusted;

}
