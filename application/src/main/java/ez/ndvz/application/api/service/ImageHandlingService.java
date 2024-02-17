package ez.ndvz.application.api.service;

import ez.ndvz.persistance.entity.PropertyImageEntity;
import ez.ndvz.persistance.mapper.ImageMapper;
import ez.ndvz.ports.api.ImageServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageHandlingService {
    private final ImageServicePort imageServicePort;
    private final ImageMapper imageMapper;
    private final String FOLDER_PATH = "C:\\Users\\nisiz\\Desktop\\Nedviznosti_Hexa\\Nedviznosti\\infrastructure\\persistance\\images";

    public String uploadToFileSystem(MultipartFile[] files) throws IOException {
        Files.createDirectories(Paths.get(FOLDER_PATH));

        for (var image : files) {
            String uniqueFilename = UUID.randomUUID() + "_" + image.getOriginalFilename();

            var imageEntity = PropertyImageEntity.builder()
                    .fileName(uniqueFilename)
                    .mimeType(image.getContentType())
                    .filePath(FOLDER_PATH + File.separator + uniqueFilename)
                    .build();

            imageServicePort.create(imageMapper.toDomain(imageEntity));

            try (OutputStream outputStream = new FileOutputStream(imageEntity.getFilePath())) {
                outputStream.write(image.getBytes());
            }

            System.out.println(imageEntity.getFilePath());
        }

        return "+++++++++++++++++++++ IMAGES SAVED +++++++++++++++++";
    }

    public byte[] retrieveImageFromFileSystem(String imagePath) {
        byte[] imageBytes = imageServicePort.retrieve(imagePath);
        if (imageBytes != null) {
            return imageBytes;
        } else {
            return null;
        }
    }
}
