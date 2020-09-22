package Test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class sendMessage implements java.io.Serializable{
    private static final long serialVersionUID = 9075345902819909949L;
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        //save message to outputstream
        Message message = new Message();
        message.setFace("smile");
        message.setText("test");
        message.setId(1);

        // save object
        FileOutputStream file = new FileOutputStream("d:\\Test\\1.abc");
        ObjectOutputStream ch = new ObjectOutputStream(file);
        ch.writeObject(message);
        ch.close();


    }
}
