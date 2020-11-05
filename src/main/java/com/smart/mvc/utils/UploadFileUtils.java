package com.smart.mvc.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Author Emilia
 * @Since 2020.11.04 22:07
 */
public class UploadFileUtils {
    public static final String IMG = "IMG_";
    public static final String DATETIME_TYPE = "yyyyMMddHHmmss";
    public static final String DATE_TYPE = "yyyyMMdd";
    public static final String ROOT_PATH = "F:\\File";
    public static final String IMAGES_PATH = "images";

    /**
     * 获取保存文件的路径
     *
     * @param multipartFile
     * @return
     */
    public static String imagePath(MultipartFile multipartFile) throws IOException {
        //设置图片路径
        String imagePath = IMAGES_PATH + File.separator + DateFormatUtils.format(new Date(), DATE_TYPE);

        //保存文件的绝对路径
        File file = new File(ROOT_PATH + File.separator + imagePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取生成时间戳的图片名
        String imgNewName = getImgNewName(multipartFile.getOriginalFilename());
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(file,imgNewName));

        //保存图片的相对路径到数据库中
        return imagePath + File.separator + imgNewName;
    }

    /**
     * 生成时间戳的图片名
     * @param oldName
     * @return
     */
    public static String getImgNewName(String oldName) {
        String format = DateFormatUtils.format(new Date(), DATETIME_TYPE);
        return String.format("%s%s%s", IMG, format, getFileSuffixName(oldName));
    }

    /**
     * 获取文件后缀
     *
     * @param fileName
     * @return
     */
    public static String getFileSuffixName(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}
