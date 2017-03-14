/*
 * @(#) FileTypeUtils.java 2017年03月12日
 * 
 * Copyright 2010 hzxiaobo, MIT License.
 */
package com.miu.image.utils;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.junit.Test;

/**
 * @author xiaobo
 * @version 2017年03月12日
 */
public class ImageTypeUtilTest {

    @Test
    public void testImageType() throws Exception {
        String filePath = "src/test/resources/test-image-type/";
        String fileListPath = filePath + "image-type.list";
        System.out.println(String.format("file Path is : %s", fileListPath));
        List<String> fileList = FileProcessUtils.readLocalFileOpList(fileListPath);
        System.out.println("param check, num of fileList is: " + fileList.size());
        for (String fileName : fileList) {
            String imgFilePath = filePath + fileName;
            String type = ImageTypeUtil.getImageType(imgFilePath);
            System.out.println(String.format("%s 's type is : %s", fileName, type));
            Validate.isTrue(fileName.startsWith(type), String.format("image type isn't match, %s : %s", fileName, type));
        }
    }

    @Test
    public void getImageTypeTest() throws Exception{
        String filePath = "src/test/resources/test-image-type/";
        String fileListPath = filePath + "image-type.list";
        System.out.println(String.format("file Path is : %s", fileListPath));
        List<String> fileList = FileProcessUtils.readLocalFileOpList(fileListPath);
        System.out.println("param check, num of fileList is: " + fileList.size());
        for (String fileName : fileList) {
            String imgFilePath = filePath + fileName;
            byte[] inputBytes = ImageTypeUtil.inputStream2ByteArray(imgFilePath);
            String type = ImageTypeUtil.getImageType(inputBytes);
            System.out.println(String.format("%s 's type is : %s", fileName, type));
            Validate.isTrue(fileName.startsWith(type), String.format("image type isn't match, %s : %s", fileName, type));
        }
    }
}
