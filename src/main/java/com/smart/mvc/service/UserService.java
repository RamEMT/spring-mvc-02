package com.smart.mvc.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author Emilia
 * @Since 2020.11.04 22:00
 */
public interface UserService {
    /**
     * 上传图片
     * @param uid
     * @param multipartFile
     * @return
     */
    String uploadImage(int uid, MultipartFile multipartFile) throws IOException;
}
