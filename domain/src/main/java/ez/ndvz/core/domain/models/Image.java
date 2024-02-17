package ez.ndvz.core.domain.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//TODO maybe add a map <Property,List<Image>>
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Image {
    private String id;
    private Property property;
    private String fileName;
    private String mimeType;
    //private byte[] data;
    private String filePath;
}
