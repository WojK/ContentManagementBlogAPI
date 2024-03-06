package com.blogApi.serviceImplementation;

import com.blogApi.model.Image;
import com.blogApi.repository.ImageRepo;
import com.blogApi.service.ComponentService;
import com.blogApi.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepo imageRepo;
    private final ComponentService componentService;


    private final String IMAGE_FOLDER_PATH = System.getProperty("user.home") + File.separator + "Pictures";

    @Override
    public boolean addImageToPost(MultipartFile file, Integer postId, String userEmail) throws IOException {
        UUID uuid = UUID.randomUUID();
        String imagePath = IMAGE_FOLDER_PATH + "\\" + uuid + "_." + file.getOriginalFilename();
        Image image =  Image.builder().name(file.getOriginalFilename()).
                type(file.getContentType()).imagePath(imagePath).build();
        boolean isSuccess = componentService.addComponentToPost(image, postId, userEmail, imageRepo, "image");

        if(isSuccess) file.transferTo(new File(imagePath));

        return isSuccess;
    }
}
