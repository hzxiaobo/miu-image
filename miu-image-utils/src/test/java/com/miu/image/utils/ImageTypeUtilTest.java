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

    /**
     * 测试函数getImageType(String filePath)，
     * 直接输入本地文件名，读取图像，并读取头文件。
     * @throws Exception IOException
     */
    @Test
    public void testGetImageTypeLocalFile() throws Exception {
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

    /**
     * 测试函数getImageType(byte[] imageBytes)，
     * 在测试函数中读取本地文件后，转为ByteArray之后，再测试函数
     * @throws Exception IOException
     */
    @Test
    public void testGetImageTypeFromByteArray() throws Exception{
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
