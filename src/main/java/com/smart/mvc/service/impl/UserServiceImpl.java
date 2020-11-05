package com.smart.mvc.service.impl;

import com.smart.mvc.service.UserService;
import com.smart.mvc.utils.UploadFileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author Emilia
 * @Since 2020.11.04 22:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String uploadImage(int uid, MultipartFile multipartFile) throws IOException {
        return UploadFileUtils.imagePath(multipartFile);
    }
}
