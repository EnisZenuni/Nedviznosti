package ez.ndvz.persistance.entity;


import ez.ndvz.persistance.enumerations.Details;
import ez.ndvz.persistance.enumerations.EnergySource;
import ez.ndvz.persistance.enumerations.FlooringType;
import ez.ndvz.persistance.enumerations.Heating;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.Year;
import java.util.List;


//TODO change to MappedSu
// perClass if we dont to use inheritnce type single table
// but then we wont have a discriminator to differentiate what kind of property we want to persist


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "property_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
public abstract class PropertyEntity extends BaseEntity {
    @NonNull
    @NotBlank
    private String address; //TODO -> Create Value Object

    @NotNull
    @NotBlank(message = "Please provide a detailed description")
    private String description;


    private Year yearBuilt;


    @NotNull
    @NotBlank(message = "Please Insert size in km")
    private Float squareFootage;

    @NotBlank(message = "Please insert number of bedrooms")
    @Size(min = 1)
    private Integer bedrooms;

    @NotBlank(message = "Please insert number of bedrooms")
    @Size(min = 1)
    private Integer bathrooms;

    @NotBlank(message = "Please select heating type from the provided options")
    @Enumerated(EnumType.STRING)
    private Heating heatingType;

    @Enumerated(EnumType.STRING)
    @NotEmpty
    @NotBlank(message = "Please select energy source from the provided options")
    private EnergySource energySource;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Please select flooring type from the provided options")
    FlooringType flooringType;

    @ElementCollection(targetClass = Details.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "property_details", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "details")
    List<Details> detailsList;

    @ManyToOne
    private AgencyEntity agency;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PropertyImageEntity> images;

    @Positive
    private double price;

    @Positive
    private double rentalPrice;
}
