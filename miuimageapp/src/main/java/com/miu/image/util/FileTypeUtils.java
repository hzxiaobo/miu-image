/*
 * @(#) FileType.java 2017年03月11日
 *
 * Copyright 2010 hzxiaobo, MIT License.
 */
package com.miu.image.util;

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
public class FileTypeUtils {
    private final static Map<String, String> FILE_TYPE_MAP = new HashMap<>();

    static{
        loadImageFileTypes(); //初始化文件类型信息
    }

    /**
     * 相关文件的表示文件类型的头几个字节，预先load到Map中，方便读取后获得相应的type
     */
    private static void loadImageFileTypes()
    {
        FILE_TYPE_MAP.put("FFD8FF", "jpg");
        FILE_TYPE_MAP.put("89504E", "png");
        FILE_TYPE_MAP.put("474946", "gif");
        FILE_TYPE_MAP.put("49492A", "tif");
        FILE_TYPE_MAP.put("424D", "bmp");
        FILE_TYPE_MAP.put("524946","webp");

//        FILE_TYPE_MAP.put("41433130", "dwg"); //CAD
//        FILE_TYPE_MAP.put("38425053", "psd");
//        FILE_TYPE_MAP.put("7B5C727466", "rtf"); //日记本
//        FILE_TYPE_MAP.put("3C3F786D6C", "xml");
//        FILE_TYPE_MAP.put("68746D6C3E", "html");
//        FILE_TYPE_MAP.put("44656C69766572792D646174653A", "eml"); //邮件
//        FILE_TYPE_MAP.put("D0CF11E0", "doc");
//        FILE_TYPE_MAP.put("5374616E64617264204A", "mdb");
//        FILE_TYPE_MAP.put("252150532D41646F6265", "ps");
//        FILE_TYPE_MAP.put("255044462D312E", "pdf");
//        FILE_TYPE_MAP.put("504B0304", "zip");
//        FILE_TYPE_MAP.put("52617221", "rar");
//        FILE_TYPE_MAP.put("57415645", "wav");
//        FILE_TYPE_MAP.put("41564920", "avi");
//        FILE_TYPE_MAP.put("2E524D46", "rm");
//        FILE_TYPE_MAP.put("000001BA", "mpg");
//        FILE_TYPE_MAP.put("000001B3", "mpg");
//        FILE_TYPE_MAP.put("6D6F6F76", "mov");
//        FILE_TYPE_MAP.put("3026B2758E66CF11", "asf");
//        FILE_TYPE_MAP.put("4D546864", "mid");
//        FILE_TYPE_MAP.put("1F8B08", "gz");
    }

    /**
     * 将byte[]数组转化为十六进制字符串，进行对比
     * @param src 输入的byte[]数组
     * @return 返回十六进制的字符串
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
     * @param filePath 读取文件的路径
     * @return 返回文件的类型
     */
    public static String getFileType(String filePath){
        String res = null;
        FileInputStream is = null;
        try {
            is = new FileInputStream(filePath);
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



    public static String getFileType(byte[] imageBytes){
        String res = null;
        try {
            byte[] b = new byte[3]; //其中gif是前3个bytes定义了types
            System.arraycopy(imageBytes,0, b, 0, b.length);

//            is = new FileInputStream(filePath);
//
//            is.read(b, 0, b.length);
//            imageBytes.
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
