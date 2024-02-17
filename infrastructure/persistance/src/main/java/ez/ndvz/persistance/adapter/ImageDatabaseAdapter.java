package ez.ndvz.persistance.adapter;

import ez.ndvz.core.domain.models.Image;
import ez.ndvz.persistance.entity.PropertyImageEntity;
import ez.ndvz.persistance.mapper.ImageMapper;
import ez.ndvz.persistance.repository.ImageRepository;
import ez.ndvz.ports.spi.ImageDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ImageDatabaseAdapter implements ImageDatabasePort {
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    @Override
    public Image create(Image image) {
        return imageMapper.toDomain(imageRepository.save(imageMapper.toEntity(image)));
    }

    @Override
    public void delete(Long imageId) {
        var image = imageRepository.findById(imageId);
        image.ifPresent(imageRepository::delete);
    }

    @Override
    public String upload(byte[] image) {
        return null;
    }

    @Override
    public byte[] retrieve(String filepath) {
        try {
            return Files.readAllBytes(Paths.get(filepath));
        } catch (IOException e) {
            // Handle exception (e.g., log, throw custom exception)
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Image> findAllImagesByProperty(Long propertyId) {
        List<PropertyImageEntity> propertyImageEntities =
                imageRepository.findAll()
                        .stream()
                        .filter(propertyImageEntity -> propertyImageEntity.getProperty().getId() == propertyId)
                        .toList();
        return imageMapper.toDomain(propertyImageEntities);

    }

    @Override
    public List<Image> findAllImages() {
        return imageMapper.toDomain(imageRepository.findAll());
    }
}
