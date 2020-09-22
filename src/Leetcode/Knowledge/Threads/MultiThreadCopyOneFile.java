package Leetcode.Knowledge.Threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile是java Io体系中功能最丰富的文件内容访问类。即可以读取文件内容，也可以向文件中写入内容。但是和其他输入/输入流不同的是，程序可以直接跳到文件的任意位置来读写数据。
 *
 */
public class MultiThreadCopyOneFile implements Runnable {
    private File src;   //源文件
    private File tar;   //目标文件
    private int n;  //线程个数
    private int no; //当前线程编号
    static int FileFinishNum;   //拷贝文件完成个数
    static long begintime;   //文件拷贝开始时间

    public MultiThreadCopyOneFile(File src, File tar, int n, int no) {
        this.src = src;
        this.tar = tar;
        this.n = n;
        this.no = no;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            RandomAccessFile rsrc = new RandomAccessFile(src, "r");
            String filename = src.getName();
            tar = new File(tar + File.separator + filename);
            RandomAccessFile rtar = new RandomAccessFile(tar, "rw");
            long len = src.length();
            long size = len % n == 0 ? len / n : len / n + 1;
            byte[] b = new byte[1024 * 8];
            int num = 0;
            long startposition = size * no;
            rsrc.seek(startposition);
            rtar.seek(startposition);
            int sum = 0;
            while ((num = rsrc.read(b)) != -1 && sum < size) {
                rtar.write(b, 0, num);
                sum += num;
            }
            synchronized (this) {
                FileFinishNum++;
                if (FileFinishNum == n) {
                    long endtime = System.currentTimeMillis();
                    System.out.println("File Copy OK!   耗时" + (endtime - begintime) + "毫秒");
                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void FileCopy() {
        File source = new File("F:\\JAVASource/TableauDesktop-64bit-2020-3-0.exe");
        File destination = new File("F:\\JAVATest");
        int n = 3;
        for (int i = 0; i < n; i++) {
            new Thread(new MultiThreadCopyOneFile(source, destination, n, i)).start();
        }
        System.out.println("File Copy OK");
    }

    public static void main(String[] args) {
        FileCopy();
    }
}
