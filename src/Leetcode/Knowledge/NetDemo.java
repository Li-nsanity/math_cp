package Leetcode.Knowledge;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetDemo {
    public static void main(String[] args) throws UnknownHostException {
        //InetAddress address = InetAddress.getByName("DESKTOP-OU0CDED");
        InetAddress address = InetAddress.getByName("192.168.1.102");
        String name = address.getHostName();
        String ip = address.getHostAddress();
        System.out.println("主机名："+name);
        System.out.println("IP地址："+ip);
    }
}
