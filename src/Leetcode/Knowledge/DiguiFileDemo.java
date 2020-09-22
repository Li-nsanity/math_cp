package Leetcode.Knowledge;

import java.io.File;

public class DiguiFileDemo {
    public static void main(String[] args) {
        File srcfile = new File("F:\\学习资料");
        getAllFilePath(srcfile);
    }

    public static void getAllFilePath(File srcfile) {
        File[] filearray = srcfile.listFiles();
        if (filearray != null) {
            for (File f : filearray) {
                if (f.isDirectory()) {
                    getAllFilePath(f);
                } else {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
}
