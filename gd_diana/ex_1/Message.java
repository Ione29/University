package gd_diana.ex_1;
import java.time.LocalDate;

public class Message {
    private MessageType messageType;
    private String content;
    private LocalDate sendTime;

    public Message(MessageType messageType, String content, LocalDate sendTime){
        this.messageType = messageType;
        this.content = content;
        this.sendTime = sendTime;
    }

    public MessageType getType(){
        return this.messageType;
    }

    public void setType( MessageType newType){
        this.messageType = newType;
    }

    public void display(){
        System.out.println(content);
    }
}
