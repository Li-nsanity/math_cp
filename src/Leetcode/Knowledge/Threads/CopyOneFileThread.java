package Leetcode.Knowledge.Threads;

import java.io.*;
import java.util.Date;

public class CopyOneFileThread implements Runnable{
    private File src;// 源文件
    private File tar;// 目标文件
    private int n;// 分几部分
    private int no;// 每部分的编号

    public CopyOneFileThread(File src, File tar, int n, int no) {
        this.src = src;
        this.tar = tar;
        this.n = n;
        this.no = no;
    }

    @Override
    public void run() {
        try {
            RandomAccessFile rafsrc = new RandomAccessFile(src, "r");
            String fileName = src.getName();
            tar=new File(tar+File.separator+fileName);
            RandomAccessFile raftar = new RandomAccessFile(tar, "rw");
            long len = src.length();
            long size = len % n == 0 ? len / n : len / n + 1;// 每部分的字节数
            byte[] b = new byte[1024 * 8];// 每次读取的文件大小
            int num = 0;// 每次读取的字节数
            long start = size * no;// 读写的起始位置
            rafsrc.seek(start);
            raftar.seek(start);
            int sum = 0;// 累加每次读取个数
            while ((num = rafsrc.read(b)) != -1 && sum < size) {
                raftar.write(b, 0, num);
                sum += num;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    private static void copyOneFile() {

        File srcFile = new File("F:\\JAVASource/TableauDesktop-64bit-2020-3-0.exe");
        File destFile = new File("F:\\JAVATest");
        int n = 5;
        Thread[] tr = new Thread[n];
        Date startDate = new Date();
        for (int i = 0; i < 5; i++) {
            CopyOneFileThread coft = new CopyOneFileThread(srcFile,destFile,n,i);
            tr[i] = new Thread();
            tr[i].start();
        }
        System.out.println("复制文件用"+n+"线程，用时："+(new Date().getTime()-startDate.getTime()));
    }

    public static void main(String[] args) {
        copyOneFile();
    }


}
