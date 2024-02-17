package ez.ndvz.ports.spi;

import ez.ndvz.core.domain.models.Image;

import java.util.List;


public interface ImageDatabasePort {
        Image create(Image image);
        void delete(Long imageId);
        String upload(byte[] image);
        byte[] retrieve(String filepath);
        List<Image> findAllImagesByProperty(Long propertyId);
        List<Image> findAllImages();
}
