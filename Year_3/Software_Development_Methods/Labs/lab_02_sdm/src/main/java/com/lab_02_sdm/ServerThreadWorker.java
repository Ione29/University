package com.lab_02_sdm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
public class ServerThreadWorker extends Thread{
    private Socket socket;

    ServerThreadWorker(Socket socket) {
        this.socket = socket;
    }
    
    public void run() {
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
        	in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            
            String socketName = in.readUTF();
            System.out.println("Connection accepted: " + socketName);
            while(true){
                String received = in.readUTF();
                if(received == "END"){
                    in.close();
                    out.writeUTF("Connection Terminated.");    
                    out.close();
                    socket.close();
                }
                else{
                    System.out.println(received);
                    out.writeUTF(received);
                    out.flush();
                }
            }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
}
