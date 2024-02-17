package ez.ndvz.application.api.v1.dto.imageDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Builder
@Data
public class ImageRequestDTO {
    MultipartFile multipartFile;
}
