package ez.ndvz.application.api.v1.controller;

import ez.ndvz.application.api.service.ImageHandlingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageHandlingService imageHandlingService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("image") MultipartFile[] multipartFile) throws IOException {
        return ResponseEntity.ok(imageHandlingService.uploadToFileSystem(multipartFile));
    }

    @GetMapping("/retrieve")
    public ResponseEntity<byte[]> retrieve(@RequestParam("filePath") String filePath) {
        byte[] imageData = imageHandlingService.retrieveImageFromFileSystem(filePath);
        if (imageData != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Change based on your image type
            return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
