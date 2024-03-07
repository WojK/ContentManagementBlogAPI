package com.blogApi.serviceImplementation;

import com.blogApi.model.Image;
import com.blogApi.modelResponseDTO.ImageResponse;
import com.blogApi.repository.ImageRepo;
import com.blogApi.service.ComponentService;
import com.blogApi.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepo imageRepo;
    private final ComponentService componentService;


    private final String IMAGE_FOLDER_PATH = System.getProperty("user.home") + File.separator + "Pictures\\";

    @Override
    public boolean addImageToPost(MultipartFile file, Integer postId, String userEmail) throws IOException {
        UUID uuid = UUID.randomUUID();
        String imageName = uuid + "__" + file.getOriginalFilename();
        String imagePath = IMAGE_FOLDER_PATH  + imageName;
        Image image =  Image.builder().name(imageName).
                type(file.getContentType()).imagePath(imagePath).build();
        boolean isSuccess = componentService.addComponentToPost(image, postId, userEmail, imageRepo, "image");

        if(isSuccess) file.transferTo(new File(imagePath));

        return isSuccess;
    }

    @Override
    public ImageResponse getImageByName(String imageName) throws IOException {
        Image image = imageRepo.findByName(imageName);
        String imagePath = image.getImagePath();

        return ImageResponse.builder()
                .imageData(Files.readAllBytes(new File(imagePath).toPath())).type(image.getType()).build();
    }
}
