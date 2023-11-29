package gd_diana.ex_1;

public class Settings {


    public boolean receiveNotifications;

    public void viewMyProfile(){
    
    }

    public void setNotifications(){
        if(this.receiveNotifications)
            this.receiveNotifications = false;
        else 
            this.receiveNotifications = true;
    }

    
}
