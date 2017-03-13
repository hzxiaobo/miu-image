package com.miu.image.utils;/*
 * @(#) FileTypeUtils.java 2017年03月12日
 * 
 * Copyright 2010 hzxiaobo, MIT License.
 */

import java.util.List;

import org.junit.Test;

/**
 * @author xiaobo
 * @version 2017年03月12日
 */
public class FileTypeUtilsTest {

    @Test
    public void testFileType() throws Exception {
        String filePath = "src/test/resources/test-image-type/";
        String fileListPath = filePath + "image-type.list" ;
        System.out.println("file Path is : " + fileListPath);
        List<String> fileList = FileProcessUtils.readLocalFileOpList(fileListPath);
        System.out.println("param check, num of fileList is: " + fileList.size());
        int numContain = 0;
       // List<String> opUrl = Lists.newArrayList();
        for (String fileName : fileList) {
            String imgFilePath = filePath+ fileName;
            String type = FileTypeUtils.getFileType(imgFilePath);
            System.out.println(fileName + "'s type is: "+ type);
            assert fileName.startsWith(type):"assert Wrong, " + fileName + "'s type: " + type;
            //发现了一堆png格式的图像，明天去修改命名吧
        }


//        String type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/gif-1.gif");
//        System.out.println("gif-1.gif : "+type);
//        System.out.println();
//        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/gif-2.gif");
//        System.out.println("gif-2.gif : "+type);
//        System.out.println();
//        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/gif-3.gif");
//        System.out.println("gif-3.gif : "+type);
//        System.out.println();
//        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/jpg-1.jpeg");
//        System.out.println("jpg-1.jpg : "+type);
//        System.out.println();
//        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/jpg-2.jpeg");
//        System.out.println("jpg-2.jpg : "+type);
//        System.out.println();
//        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/png-1.png");
//        System.out.println("png-1.png : "+type);
//        System.out.println();
//        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/png-2.png");
//        System.out.println("png-2.png : "+type);
//        System.out.println();
//        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/webp-1.webp");
//        System.out.println("webp-1.webp : "+type);
//        System.out.println();


    }
}
