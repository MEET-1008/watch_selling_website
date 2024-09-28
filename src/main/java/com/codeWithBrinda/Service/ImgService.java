package com.codeWithBrinda.Service;

import org.springframework.web.multipart.MultipartFile;

public interface ImgService {

    String UploadIMG(MultipartFile multipartFile);

    String getUrlFromPunlicId(String punlicId);
}
