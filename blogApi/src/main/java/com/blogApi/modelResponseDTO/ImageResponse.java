package com.blogApi.modelResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ImageResponse {
    byte[] imageData;
    String type;
}
