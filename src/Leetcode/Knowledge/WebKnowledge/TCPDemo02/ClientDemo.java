package Leetcode.Knowledge.WebKnowledge.TCPDemo02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.1.102", 10086);
        OutputStream os = s.getOutputStream();
        os.write("你好，TCP!".getBytes());
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("数据是："+data);
        s.close();
    }
}
