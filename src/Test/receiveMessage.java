package Test;

import java.io.*;

public class receiveMessage implements java.io.Serializable  {
    private static final long serialVersionUID = -5912314371689111892L;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("d:\\Test\\1.abc");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Message ms = new Message();
        ms = (Message)ois.readObject();
        System.out.println(ms.toString());
    }
}
