package ez.ndvz.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "property_images")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropertyImageEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

    private String fileName;

    @Column(name = "mime_type")
    private String mimeType;

//    @Lob
//    private byte[] data;

    private String filePath;
}
