package Leetcode.Knowledge.WebKnowledge.TCPDemo01;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String str = new String(bys,0,len);
        System.out.println("数据是："+str);
        s.close();
        ss.close();
    }
}
