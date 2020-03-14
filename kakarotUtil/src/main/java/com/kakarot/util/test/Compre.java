package com.kakarot.util.test;

import com.kakarot.util.file.FileUtil;
import com.kakarot.util.file.ZipUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Compre {
    private static int count=0;
    private static String[] suffixs=new String[]{"rar","zip","7z","7Z"};
    private static final Logger log = LoggerFactory.getLogger(Compre.class);
    private static boolean isZip(String fileName){
        return Arrays.asList(suffixs).contains(FileUtil.getSuffix(fileName));
    }

    private static void unzipTheHomework(String filePath,String dPath,boolean isDel){
        File file = new File(filePath);
        if(file.exists()){
            File[] fs=file.listFiles();
            for(File f:fs){
                if (!f.isFile()){
                    unzipTheHomework(f.getAbsolutePath(),dPath,isDel);
                }else {
                    String fileName=f.getName();
                    if(isZip(fileName)){
                        count++;
//                        if(ZipUtil.unRar(f.getAbsolutePath(),dPath+"/"+f.getParentFile().getName())){
//                            right++;
//                        }
                        ZipUtil.unZipFiles(f.getAbsolutePath(),dPath+"/"+f.getParentFile().getName());
                        if(isDel){
                            ZipUtil.delDir(filePath);
                        }
                    }
                }
            }

        }

    }





    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
//        System.out.println("请输入文件路径：");
//        String filePath=scanner.next();
        System.out.println("是否删除源文件？1是2否");
        int del=scanner.nextInt();
        boolean isDel=del==1;
        String filePath="D:\\OneDrive - RLS ,inc\\学校资料\\工程学院\\17嵌入式\\课程资料\\作业\\0306作业\\126778693_17612968_6620845";
        String dPath="D:\\OneDrive - RLS ,inc\\学校资料\\工程学院\\17嵌入式\\课程资料\\作业\\0306作业\\解压后文件";
        log.info("获取地址成功：{}",filePath);
        unzipTheHomework(filePath,dPath,isDel);
        log.info("共找到{}个压缩包，解压成功{}个压缩包",count,count);
//        ZipUtil.unZipFiles("D://下载/timer.zip","D://下载/解压缩");
    }
}
