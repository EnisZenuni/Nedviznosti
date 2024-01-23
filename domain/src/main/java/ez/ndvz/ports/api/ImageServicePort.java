package ez.ndvz.ports.api;

import ez.ndvz.core.domain.models.Image;

import java.util.List;

public interface ImageServicePort {
    Image create(Image image);
    Image delete(Long imageId);
    List<Image> findAll(Long propertyId);

}
