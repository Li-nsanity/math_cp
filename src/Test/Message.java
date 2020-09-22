package Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Message implements java.io.Serializable {

    String text;
    String face;
    int id;


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public String getFace() {
        return face;
    }


    public void setFace(String face) {
        this.face = face;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", face='" + face + '\'' +
                ", id=" + id +
                '}';
    }

}
