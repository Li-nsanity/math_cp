package Leetcode.Knowledge.CopyFolder;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        File srcfile = new File("F:\\JavaTools\\redis-5.0.8.tar.gz");
        File destfile = new File("F:\\JavaTools\\copy.tar.gz");
        copyFile(srcfile, destfile);
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
