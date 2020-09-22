package Leetcode.Knowledge.WebKnowledge.TCPDemo01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.1.102",10086);
        OutputStream os = s.getOutputStream();
        os.write("Hello,TCP,你好".getBytes());
        s.close();
    }
}
