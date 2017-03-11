/*
 * @(#) FileType.java 2017年03月11日
 *
 * Copyright 2010 hzxiaobo, MIT License.
 */
package com.github.miu.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author hzxiaobo
 * @version 2017年03月10日
 */
public class FileType {
    private final static Map<String, String> FILE_TYPE_MAP = new HashMap<>();

    private FileType(){}
    static{
        getAllFileType(); //初始化文件类型信息
    }

    /**
     * Discription:[getAllFileType,常见文件头信息]
     */
    private static void getAllFileType()
    {
        FILE_TYPE_MAP.put("FFD8FF", "jpg");
        FILE_TYPE_MAP.put("89504E", "png");
        FILE_TYPE_MAP.put("474946", "gif");
        FILE_TYPE_MAP.put("49492A", "tif");
        FILE_TYPE_MAP.put("424D", "bmp");
        FILE_TYPE_MAP.put("524946","webp");
        //
        FILE_TYPE_MAP.put("41433130", "dwg"); //CAD
        FILE_TYPE_MAP.put("38425053", "psd");
        FILE_TYPE_MAP.put("7B5C727466", "rtf"); //日记本
        FILE_TYPE_MAP.put("3C3F786D6C", "xml");
        FILE_TYPE_MAP.put("68746D6C3E", "html");
        FILE_TYPE_MAP.put("44656C69766572792D646174653A", "eml"); //邮件
        FILE_TYPE_MAP.put("D0CF11E0", "doc");
        FILE_TYPE_MAP.put("5374616E64617264204A", "mdb");
        FILE_TYPE_MAP.put("252150532D41646F6265", "ps");
        FILE_TYPE_MAP.put("255044462D312E", "pdf");
        FILE_TYPE_MAP.put("504B0304", "zip");
        FILE_TYPE_MAP.put("52617221", "rar");
        FILE_TYPE_MAP.put("57415645", "wav");
        FILE_TYPE_MAP.put("41564920", "avi");
        FILE_TYPE_MAP.put("2E524D46", "rm");
        FILE_TYPE_MAP.put("000001BA", "mpg");
        FILE_TYPE_MAP.put("000001B3", "mpg");
        FILE_TYPE_MAP.put("6D6F6F76", "mov");
        FILE_TYPE_MAP.put("3026B2758E66CF11", "asf");
        FILE_TYPE_MAP.put("4D546864", "mid");
        FILE_TYPE_MAP.put("1F8B08", "gz");
    }

    /**
     * 得到上传文件的文件头
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 根据制定文件的文件头判断其文件类型
     * @param filePaht
     * @return
     */
    public static String getFileType(String filePaht){
        String res = null;
        FileInputStream is = null;
        try {
            is = new FileInputStream(filePaht);
            byte[] b = new byte[3]; //其中gif是前3个bytes定义了types
            is.read(b, 0, b.length);
            String fileCode = bytesToHexString(b);

            System.out.println("result check, file code is : " + fileCode);


            //这种方法在字典的头代码不够位数的时候可以用但是速度相对慢一点
            Iterator<String> keyIter = FILE_TYPE_MAP.keySet().iterator();
            while(keyIter.hasNext()){
                String key = keyIter.next();
                if(key.toLowerCase().startsWith(fileCode.toLowerCase()) || fileCode.toLowerCase().startsWith(key.toLowerCase())){
                    System.out.println("result check, matched key is : " + key);
                    res = FILE_TYPE_MAP.get(key);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        if(null != is) {
            try {
                is.close();
            } catch (IOException e) {}
        }
    }
        return res;
    }

    public static void main(String[] args) throws Exception {

        String type = getFileType("/home/xiaobo/data/image-format/gif-1.gif");
        System.out.println("gif-1.gif : "+type);
        System.out.println();
        type = getFileType("/home/xiaobo/data/image-format/gif-2.gif");
        System.out.println("gif-2.gif : "+type);
        System.out.println();
        type = getFileType("/home/xiaobo/data/image-format/gif-3.gif");
        System.out.println("gif-3.gif : "+type);
        System.out.println();
        type = getFileType("/home/xiaobo/data/image-format/jpg-1.jpeg");
        System.out.println("jpg-1.jpg : "+type);
        System.out.println();
        type = getFileType("/home/xiaobo/data/image-format/jpg-2.jpeg");
        System.out.println("jpg-2.jpg : "+type);
        System.out.println();
        type = getFileType("/home/xiaobo/data/image-format/png-1.png");
        System.out.println("png-1.png : "+type);
        System.out.println();
        type = getFileType("/home/xiaobo/data/image-format/png-2.png");
        System.out.println("png-2.png : "+type);
        System.out.println();
        type = getFileType("/home/xiaobo/data/image-format/webp-1.webp");
        System.out.println("webp-1.webp : "+type);
        System.out.println();


    }
}
