package ez.ndvz.core.domain.service;

import ez.ndvz.core.domain.models.Image;
import ez.ndvz.ports.api.ImageServicePort;
import ez.ndvz.ports.spi.ImageDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ImageServicePortImpl implements ImageServicePort {
    private final ImageDatabasePort imageDatabasePort;
    @Override
    public Image create(Image image) {
        return imageDatabasePort.create(image);
    }

    @Override
    public Image delete(Long imageId) {
        return null;
    }

    @Override
    public String upload(byte[] image) {
        return null;
    }

    @Override
    public byte[] retrieve(String filepath) {
        return imageDatabasePort.retrieve(filepath);
    }

    @Override
    public List<Image> findAllImagesbyProperty(Long propertyId) {
        return null;
    }

    @Override
    public List<Image> findAllImages() {
        return null;
    }
}
