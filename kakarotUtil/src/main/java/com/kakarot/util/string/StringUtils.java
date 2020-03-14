package com.kakarot.util.string;

/**
 * 字符串操作工具类
 */
public class StringUtils {
    /**
     * 判断字符串是否为空
     * @param str 要判断的字符串
     * @return  为空返回
     */
    public static boolean isEmpty(String str){
        return str==null||str.length()==0;
    }

    /**
     * 判断是否有值
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

}
