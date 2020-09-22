package Leetcode.Knowledge.WebKnowledge.TCPDemo02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    /**
     * 服务端：收到消息后给出反馈
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("数据是：" + data);
        OutputStream os = s.getOutputStream();
        os.write("已收到消息，谢谢！".getBytes());
        s.close();
        ss.close();
    }
}
