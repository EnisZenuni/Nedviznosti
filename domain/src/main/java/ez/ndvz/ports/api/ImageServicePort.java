package ez.ndvz.ports.api;

import ez.ndvz.core.domain.models.Image;

import java.util.List;

public interface ImageServicePort {
    Image create(Image image);
    Image delete(Long imageId);
    String upload(byte[] image);
    byte[] retrieve(String filepath);
    List<Image> findAllImagesbyProperty(Long propertyId);
    List<Image> findAllImages();
}
