package com.miu.image.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 *
 * @author xiaobo
 * @version 2015年4月16日
 */
public class FileProcessUtils implements Serializable {
    private static final long serialVersionUID = -6645021658755390264L;
//    private static final Logger logger = Logger.getLogger(FileProcessUtils.class);

    /**
     * 默认读Resource文件，方式："UTF-8"的方式读写，返回：List<String>
     * @param fileName
     * @return
     */
    public static List<String> readResourceFileOpList(String fileName) {
        return readResourceFileOpList(fileName, "UTF-8");
    }

    /**
     * 读Resource文件，方式：以encoding的方式读写，返回：List<String>
     * @param fileName
     * @param encoding
     * @return
     */
    public static List<String> readResourceFileOpList(String fileName, String encoding) {
        try {
            List<String> opResult = new ArrayList<String>();

            InputStream input = FileProcessUtils.class.getResourceAsStream(fileName);
            InputStreamReader read = new InputStreamReader(input, encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                opResult.add(lineTxt);
            }
            read.close();
            return opResult;
        } catch (Exception e) {
//            logger.info(String.format("ReadFileError:%s", fileName), e);
            return null;
        }
    }

    /**
     * 默认读Resource文件，方式："UTF-8"的方式读写，返回：String
     * @param fileName
     * @return
     */
    public static String readResourceFile(String fileName) {
        return readResourceFile(fileName, "UTF-8");
    }

    /**
     * 读Resource文件，方式：以encoding的方式读写，返回：String
     * @param fileName
     * @param encoding
     * @return
     */
    public static String readResourceFile(String fileName, String encoding) {
        try {

            InputStream input = FileProcessUtils.class.getResourceAsStream(fileName);
            InputStreamReader read = new InputStreamReader(input, encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
            StringBuilder opTxt = new StringBuilder();
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                opTxt.append(lineTxt);
            }
            read.close();
            return opTxt.toString();
        } catch (Exception e) {
  //          logger.info(String.format("ReadFileError:%s", fileName), e);
            return null;
        }
    }

    /**
     * 默认读Local文件，方式："UTF-8"的方式读写，返回：List<String>
     * @param file
     * @return
     */
    public static List<String> readLocalFileOpList(String file) {
        return readLocalFileOpList(file, "UTF-8");
    }

    /**
     * 读Local文件，方式：以encoding的方式读写，返回：List<String>
     * @param file
     * @param encoding
     * @return
     */
    public static List<String> readLocalFileOpList(String file, String encoding) {
        try {
            List<String> opResult = new ArrayList<String>();
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                opResult.add(lineTxt);
            }
            read.close();
            return opResult;

        } catch (Exception e) {
    //        logger.info(String.format("ReadFileError:%s", file), e);
            return null;
        }
    }

    /**
     * 默认读Local文件，方式："UTF-8"的方式读写，返回：String
     * @param file
     * @return
     */
    public static String readLocalFile(String file) {
        return readLocalFile(file, "UTF-8");
    }

    /**
     * 读Local文件，方式：以encoding的方式读写，返回：String
     * @param file
     * @param encoding
     * @return
     */
    public static String readLocalFile(String file, String encoding) {
        try {

            InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
            StringBuilder opTxt = new StringBuilder();
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                opTxt.append(lineTxt);
            }
            read.close();
            return opTxt.toString();
        } catch (Exception e) {
      //      logger.info(String.format("ReadFileError:%s", file), e);
            return null;
        }
    }

    /**
     * 默认读Local文件，方式："UTF-8"的方式读写，返回：Map<String, String>
     * @param file
     * @return
     */
    public static Map<String, String> readLocalFileOpMap(String file) {
        return readLocalFileOpMap(file, "UTF-8");
    }

    /**
     * 读Local文件，方式：以encoding的方式读写，返回：Map<String, String>
     * @param file
     * @param encoding
     * @return
     */
    public static Map<String, String> readLocalFileOpMap(String file, String encoding) {
        try {
            List<String> contentList = readLocalFileOpList(file, encoding);
            Map<String, String> contentMap = new LinkedHashMap<String, String>();
            for (String content : contentList) {
                String[] mStr = content.split("\\|");
                if (mStr.length > 1) {
                    String contentKey = mStr[0].trim();
                    StringBuilder contentValue = new StringBuilder();
                    for (int i = 1; i < mStr.length; i++) {
                        contentValue.append(mStr[i].trim());
                    }
                    contentMap.put(contentKey, contentValue.toString());
                }
            }
            return contentMap;
        } catch (Exception e) {
    //        logger.info(String.format("ReadFileError:%s", file), e);
            return null;
        }
    }

    /**
     * 最内层的写文件的方式，直接新开文件
     * @param file
     * @param content
     */
    public static void writeFile(String file, String content) {
        writeFile(file, false, content);
    }

    /**
     * 最内层的写文件的方式，
     * @param file
     * @param appended
     * @param content
     */
    public static void writeFile(String file, Boolean appended, String content) {
        try {
            FileWriter fileWriter = new FileWriter(file, appended);
            fileWriter.write(content);
            fileWriter.close();
        } catch (Exception e) {
    //        logger.info(String.format("WriteFileError:%s", file), e);
        }
    }

    /**
     * 写String文件的方式，直接新开文件
     * @param file
     * @param content
     */
    public static void writeFileIpString(String file, String content) {
        writeFileIpString(file, false, content);
    }

    /**
     * 写String文件的方式，
     * @param file
     * @param appended
     * @param content
     */
    public static void writeFileIpString(String file, Boolean appended, String content) {
        try {
            content += "\n";
            writeFile(file, appended, content);
        } catch (Exception e) {
   //         logger.info(String.format("WriteFileError:%s", file), e);
        }
    }

    /**
     * 将List<T>写入文件, 直接新开文件
     * @param file
     * @param contentList
     */
    public static <T> void writeFileIpList(String file, List<T> contentList) {
        writeFileIpList(file, false, contentList);
    }

    /**
     * 将List<T>写入文件
     * @param file
     * @param appended
     * @param contentList
     */
    public static <T> void writeFileIpList(String file, Boolean appended, List<T> contentList) {
        try {
            StringBuilder content = new StringBuilder();
            for (T key : contentList) {
                content.append(key + "\n");
            }
            writeFile(file, appended, content.toString());
        } catch (Exception e) {
   //         logger.info(String.format("WriteFileError:%s", file), e);
        }
    }

    /**
     * 将List<T> 转为InputStream输出
     * @param contentList
     * @return
     */
    public static <T> InputStream listDataToInputStream(List<T> contentList) {
        try {
            StringBuilder content = new StringBuilder();
            for (T key : contentList) {
                content.append(key + "\n");
            }
            InputStream in_nocode = new ByteArrayInputStream(content.toString().getBytes());
            return in_nocode;
        } catch (Exception e) {
//            logger.info(String.format("listDataToInputStreamError:%s"), e);
            return null;
        }
    }

    /**
     * 将Map<T,T>写入文件， 直接新开文件
     * @param contentMap
     */
    public static <T> void writeFileIpMap(String file, Map<T, T> contentMap) {
        writeFileIpMap(file, false, contentMap);
    }

    /**
     * 将Map<T,T>写入文件
     * @param file
     * @param appended
     * @param contentMap
     */
    public static <T> void writeFileIpMap(String file, Boolean appended, Map<T, T> contentMap) {
        try {
            StringBuilder content = new StringBuilder();
            Set<T> contentKeySet = contentMap.keySet();
            for (T key : contentKeySet) {
                content.append(key + " | " + contentMap.get(key) + "\n");
            }
            writeFile(file, appended, content.toString());
        } catch (Exception e) {
//            logger.info(String.format("WriteFileError:%s", file), e);
        }
    }

    /**
     * 测试用
     * @param args
     */
    public static void main(String[] args) {
        String list = FileProcessUtils.readResourceFile("/spamTest.txt");
        System.out.println(list);

        String localString = FileProcessUtils.readLocalFile("D:/_1.txt");
        System.out.println(localString);

        List<String> localList = FileProcessUtils.readLocalFileOpList("D:/_1.txt");
        for (String str : localList) {
            System.out.println(str);
        }

        Map<String, String> localMap = FileProcessUtils.readLocalFileOpMap("D:/_map.txt");
        System.out.println(localMap);

        FileProcessUtils.writeFile("D:/_writefile.txt", localString);
        FileProcessUtils.writeFileIpString("D:/_writefile.txt", localString);
        FileProcessUtils.writeFileIpList("D:/_writeList.txt", localList);
        FileProcessUtils.writeFileIpMap("D:/_writeMap.txt", localMap);

        FileProcessUtils.writeFileIpString("D:/_writeFileAppend.txt", true, localString);
        FileProcessUtils.writeFileIpList("D:/_writeListAppend.txt", true, localList);
        FileProcessUtils.writeFileIpMap("D:/_writeMapAppend.txt", true, localMap);

    }

}
