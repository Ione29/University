package com.lab_02_sdm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientThreadWorker extends Thread{
    private Socket socket;
    private String socketName;

    ClientThreadWorker(Socket socket, String socketName) {
        this.socket = socket;
        this.socketName = socketName;
    }
    
    public void run() {
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            Scanner scanner = new Scanner(System.in);
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        
            out.writeUTF(socketName);
            
            for(int i = 1; i <= 10; i++){
                String message = "I am " + i;
                out.writeUTF(message);
                out.flush();
            }
            
            while(scanner.nextLine() != "END"){
                System.out.println("Write \'END\' to end the transmission.");
            }

            in.close();
            out.close();
            socket.close();
            scanner.close();
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
