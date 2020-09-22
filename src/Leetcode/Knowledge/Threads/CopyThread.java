package Leetcode.Knowledge.Threads;

import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

public class CopyThread implements Runnable {
    File startfile;
    File endfile;
    static int finishNo = 0;
    static int totalNo;

    public CopyThread(File startfile, File endfile) {
        this.startfile = startfile;
        this.endfile = endfile;
    }

    @Override
    public void run() {
        try {
            copyFile(startfile, endfile);
            //finish one copy
            java.util.concurrent.locks.ReentrantLock r = new ReentrantLock();
            r.lock();
            finishNo++;
            if (finishNo == totalNo)
                System.out.println("All Success" + totalNo);
            r.unlock();

        } catch (IOException e) {
            e.printStackTrace();
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
        System.out.println(src.getName() + "结束");
    }

    private static void copy() {
        File src = new File("F:\\JAVASource");
        File dest = new File("F:\\JAVATest");
        File[] files = src.listFiles();
        Thread[] tr = new Thread[files.length];

        for (int i = 0; i < files.length; i++) {
            CopyThread ct = new CopyThread(files[i], new File(dest + File.separator + files[i].getName()));
            ct.startfile = files[i];
            tr[i] = new Thread(ct);
            tr[i].start();
        }
        totalNo = tr.length;
    }

    public static void main(String[] args) {
        copy();
    }
}
