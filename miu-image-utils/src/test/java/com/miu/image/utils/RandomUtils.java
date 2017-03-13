package com.miu.image.utils;

import java.util.Random;

/**
 * 生成随机字符的函数
 *
 * @author xiaobo
 * @version 2016年2月2日
 */
public class RandomUtils {

    private static final String BASENUM = "0123456789"; // 用以生成纯数字的随机串 long类型
    private static final String BASENINE = "123456789"; // 用以生成纯数字的随机串 long类型的第一位，第一位不能是0
    private static final String BASECHAR = "abcdefghijklmnopqrstuvwxyz0123456789"; // 生成数字字母的字符随机串，string类型

    /**
     * 生成指定长度的字符串。length不能小于等于0
     * @param length
     * @return
     */
    public static String getOriginalRandomString(int length) { // length表示生成字符串的长度
        if (length <= 0) {
            return null;
        }
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(BASECHAR.length());
            sb.append(BASECHAR.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成指定长度的字符串，前半部是当前时间，后半部是随机生成的指定位数的随机字符串,length不能小于等于0
     * @param length
     * @return
     */
    public static String getRandomString(int length) { // length表示生成字符串的长度
        if (length <= 0) {
            return null;
        }
        return System.currentTimeMillis() + "_" + RandomUtils.getOriginalRandomString(length);
    }

    /**
     * 生成执行长度的随机long纯数字类型的long，length的长度取值范围[1 18]
     * @param length
     * @return
     */
    public static long getOriginalRandomLong(int length) {
        if (length <= 0 || length > 18) {
            return -1;
        }
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        int number = random.nextInt(BASENINE.length());
        sb.append(BASENINE.charAt(number));

        for (int i = 1; i < length; i++) {
            number = random.nextInt(BASENUM.length());
            sb.append(BASENUM.charAt(number));
        }
        return Long.parseLong(sb.toString());
    }

    /**
     * 生成执行长度的随机long纯数字类型的long，前半部是13位的当前时间，后半部是指定长度的纯数字类型的随机long，length长度取值范围[1,5]
     * @param length
     * @return
     */
    public static long getRandomLong(int length) {
        if (length <= 0 || length > 5) {
            return -1;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(System.currentTimeMillis()));
        sb.append(String.valueOf(RandomUtils.getOriginalRandomLong(length)));
        System.out.println(System.currentTimeMillis());
        System.out.println(sb.toString());
        return Long.parseLong(sb.toString());

    }

    /**
     * 测试用
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(RandomUtils.getRandomString(16));
        System.out.println(RandomUtils.getOriginalRandomLong(16));
        System.out.println(RandomUtils.getRandomLong(5));
    }
}
