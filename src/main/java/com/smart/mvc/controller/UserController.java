package com.smart.mvc.controller;

import com.smart.mvc.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author Emilia
 * @Since 2020.11.04 22:01
 */
@RestController
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("uid") int uid ,@RequestParam("img") MultipartFile multipartFile){
        String imagePath = null;
        try {
            imagePath = userService.uploadImage(uid, multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePath;
    }
}
