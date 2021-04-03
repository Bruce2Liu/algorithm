package com.example.algorithm.utils;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

/**
 * @author liujunhui
 * @date 2021/1/25 10:40
 */
public class MyFileUtil {

    public String getDeskTopDir() {
        return FileSystemView.getFileSystemView().getHomeDirectory().getPath();
    }

    public static File createNewFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        }
        return file;
    }

    public static void main(String[] args) {

    }
}
