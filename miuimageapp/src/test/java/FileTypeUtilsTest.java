/*
 * @(#) FileTypeUtils.java 2017年03月12日
 * 
 * Copyright 2010 hzxiaobo, MIT License.
 */

import com.miu.image.util.FileTypeUtils;

/**
 * @author xiaobo
 * @version 2017年03月12日
 */
public class FileTypeUtilsTest {

    public static void main(String[] args) throws Exception {

        String type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/gif-1.gif");
        System.out.println("gif-1.gif : "+type);
        System.out.println();
        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/gif-2.gif");
        System.out.println("gif-2.gif : "+type);
        System.out.println();
        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/gif-3.gif");
        System.out.println("gif-3.gif : "+type);
        System.out.println();
        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/jpg-1.jpeg");
        System.out.println("jpg-1.jpg : "+type);
        System.out.println();
        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/jpg-2.jpeg");
        System.out.println("jpg-2.jpg : "+type);
        System.out.println();
        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/png-1.png");
        System.out.println("png-1.png : "+type);
        System.out.println();
        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/png-2.png");
        System.out.println("png-2.png : "+type);
        System.out.println();
        type = FileTypeUtils.getFileType("/home/xiaobo/data/image-format/webp-1.webp");
        System.out.println("webp-1.webp : "+type);
        System.out.println();


    }
}
