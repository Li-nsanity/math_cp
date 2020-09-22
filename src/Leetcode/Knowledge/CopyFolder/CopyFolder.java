package Leetcode.Knowledge.CopyFolder;

import java.io.*;

public class CopyFolder {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("F:\\学习资料");
        File destFile = new File("F:\\JAVATest");
        copyFolder(srcFile, destFile);
    }

    private static void copyFolder(File src, File dest) throws IOException {
        if (src.isDirectory()) {
            String srcFileName = src.getName();
            File newFolder = new File(dest, srcFileName);
            if (!newFolder.exists()) {
                newFolder.mkdir();
            }
            File[] files = src.listFiles();
            for (File file : files) {
                copyFolder(file, newFolder);
            }
        } else {
            File newFile = new File(dest, src.getName());
            copyFile(src, newFile);
        }
    }

    private static void copyFile(File src, File newFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bos.close();
        bis.close();
    }

}
