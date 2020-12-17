package com.example.algorithm.api;

import com.example.algorithm.Constant.PathConstant;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @author liujunhui
 * @date 2020/12/16 11:26
 */
public class ZipFileService {

    public static void main(String[] args) {
        // 1. Java自带api
        String filePath = PathConstant.DESKTOP_PATH + "1.txt";
        String zipPath = PathConstant.DESKTOP_PATH + "2.zip";
        //zipSingleFile(filePath, zipPath);
        //unZipSingleFile(zipPath, PathConstant.DESKTOP_PATH + "3.txt", "1.txt");
        String dir = "C:\\Users\\Administrator\\Desktop\\学生错题id";
        //zipDirectory(dir, PathConstant.DESKTOP_PATH + "2.zip");

        // 2. zip4j

    }

    /**
     * 压缩单个文件
     * @param filePath 被压缩文件
     * @param zipPath 压缩文件
     */
    public static void zipSingleFile(String filePath, String zipPath) {
        try {
            File file = new File(filePath);
            File zipFile = new File(zipPath);
            // 输入类读数据
            InputStream input = new FileInputStream(file);
            // 输出类写数据
            ZipOutputStream zipOutput = new ZipOutputStream(new FileOutputStream(zipFile));
            zipOutput.putNextEntry(new ZipEntry(file.getName()));
            int temp = 0;
            while ((temp = input.read()) != -1) {
                zipOutput.write(temp);
            }
            input.close();
            zipOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压单个文件
     * @param zipPath 压缩文件
     * @param outputPath 解压后文件
     * @param fileName 被解压的文件名
     */
    public static void unZipSingleFile(String zipPath, String outputPath, String fileName) {
        try {
            File file = new File(zipPath);
            File outFile = new File(outputPath);
            ZipFile zipFile = new ZipFile(file);
            ZipEntry zipEntry = zipFile.getEntry(fileName);

            InputStream input = zipFile.getInputStream(zipEntry);
            OutputStream output = new FileOutputStream(outFile);

            int temp = 0;
            while ((temp = input.read()) != -1) {
                output.write(temp);
            }
            input.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 压缩多个文件
     * 多个文件在同一文件夹下，且该文件夹下只有文件
     * @param dir
     * @param zipPath
     */
    public static void zipDirectory(String dir, String zipPath) {
        try {
            File dirFile = new File(dir);
            File zipFile = new File(zipPath);
            InputStream input = null;
            ZipOutputStream zipOutput = new ZipOutputStream(new FileOutputStream(zipFile));
            if (dirFile.isDirectory()) {
                File[] files = dirFile.listFiles();
                for (File file : files) {
                    input = new FileInputStream(file);
                    zipOutput.putNextEntry(new ZipEntry(file.getName()));
                    int temp = 0;
                    while ((temp = input.read()) != -1) {
                        zipOutput.write(temp);
                    }
                    input.close();
                }
            }
            zipOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
