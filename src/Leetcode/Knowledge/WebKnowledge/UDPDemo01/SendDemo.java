package Leetcode.Knowledge.WebKnowledge.UDPDemo01;

import java.io.IOException;
import java.net.*;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        byte[] bys = "Hello，UDP，我来了".getBytes();
        DatagramPacket dp = new DatagramPacket(bys,bys.length, InetAddress.getByName("192.168.1.102"),10086);
        ds.send(dp);
        ds.close();
    }
}
