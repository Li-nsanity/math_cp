package Leetcode.Knowledge.WebKnowledge.TCPDemo05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket s;

    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line;
            int count = 0;
            File file = new File("F:\\JAVATest\\" + count + ".txt");
            while (file.exists()) {
                count++;
                file = new File("F:\\JAVATest\\" + count + ".txt");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            while ((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
            bw.close();
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bwServer.write("文件上传成功");
            bwServer.newLine();
            bwServer.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
