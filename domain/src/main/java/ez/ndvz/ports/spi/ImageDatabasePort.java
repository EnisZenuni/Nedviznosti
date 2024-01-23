package ez.ndvz.ports.spi;

import ez.ndvz.core.domain.models.Image;

import java.util.List;

public interface ImageDatabasePort {
        Image create(Image image);
        Image delete(Long imageId);
        List<Image> findAll(Long propertyId);

}
