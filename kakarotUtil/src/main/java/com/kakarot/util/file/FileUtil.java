package com.kakarot.util.file;

import com.kakarot.util.string.StringUtils;

/**
 * 文件操作工具类
 */
public class FileUtil {
    /**
     * 获取文件后缀名
     * @param fileName 文件名
     * @return 找不到或为空则返回原值
     */
    public static String  getSuffix(String fileName){
        if(StringUtils.isNotEmpty(fileName)){
            String[] fs=fileName.split("\\.");
            return fs[fs.length-1];
        }
        return fileName;
    }

    public static String getFileName(String fileName){
        return fileName.substring(0,fileName.lastIndexOf("."));
    }
}
