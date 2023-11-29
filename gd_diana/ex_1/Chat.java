package gd_diana.ex_1;

public abstract class Chat {
    
    public ChatType chatType;

    public ChatType getChatType(){
        return this.chatType;
    }

    public void setChatType(ChatType chatType){
        if(this.chatType == chatType)
            System.out.println("This chat is already of type " + chatType);
        else
            switch (chatType) {
                case DIRECT:
                     
                    break;
            
                case GROUP:

                    break;
            }

        this.chatType = chatType;
    }

    public abstract void receiveMessage(Message receivedMessage);

    
}
